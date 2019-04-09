package test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 测试idea快捷键
 * @author: Arnold
 * @since: 2019/4/8 11:56
 * @version: v1.0.0
 */
public class IdeaShortKeyTest extends Thread{

    private String aaaa;

    public void say(){
        getList();
        // FIXME: 2019/4/8
        if (aaaa == null) {
            String name=null;
        }

    }


    private void getList() {
        List list=new LinkedList();
        aaaa = "aaaa";
        list.add(aaaa);
        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");
        list.add("aaaa");
    }
}
