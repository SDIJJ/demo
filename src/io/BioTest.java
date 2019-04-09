package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: bio测试
 * @author: Arnold
 * @since: 2019/4/8 15:50
 * @version: v1.0.0
 */
public class BioTest {
    public static void service(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        ExecutorService service = Executors.newFixedThreadPool(6);
        while (true) {
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from " + clientSocket);
            service.execute(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    while (true) {
                        writer.println(reader.lines());
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
