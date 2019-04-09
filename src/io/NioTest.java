package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: nio测试
 * @author: Arnold
 * @since: 2019/4/8 16:15
 * @version: v1.0.0
 */
public class NioTest {
    public void server(int port) throws IOException {
        System.out.println("Listening for connections on port " + port);
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        //将ServerSocket绑定到指定的端口
        ss.bind(address);
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //将channel注册到Selector里,并说明让Selector关注的点,这里是关注建立连接这个是事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            try {
                //阻塞等待就绪的Channel,既没有客户端建立连接前就一次轮询
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                //结合业务处理异常逻辑
                break;
            }
        }
        //获取到Selector里所有就绪的SelectedKey实例,每将一个channel注册到一个selector就会产生一个SelectedKey
        Set<SelectionKey> readyKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = readyKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            //将就绪的SelectedKey从Selector中移除,因为马上就要处理它,防止重复执行
            iterator.remove();
            try {
                //若SelectedKey处于Acceptable状态
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //接收客户端连接
                    SocketChannel client = server.accept();
                    System.out.println("Accepted connection from " + client);
                    client.configureBlocking(false);
                    //向selector注册socketchannel, 主要关注读写,并传入一个ByteBuffer实例供读写缓存
                    client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                }
                //若SelectedKey处于可读状态
                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer output = (ByteBuffer) key.attachment();
                    //从channel里读取数据存入到ByteBuffer里面
                    client.read(output);
                }
                //若SelectedKey处于可写转态
                if (key.isWritable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer output = (ByteBuffer) key.attachment();
                    output.flip();
                    //将ByteBuffer里的数据写入到channel里
                    client.read(output);
                    output.compact();  //将编写好的数据从缓存中移出
                }

            } catch (IOException ex) {
                key.cancel();
                try {
                    key.channel().close();
                } catch (IOException cex) {
                }
            }
        }
    }
}
