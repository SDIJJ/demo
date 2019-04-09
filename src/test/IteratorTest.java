package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 迭代器异常测试
 * @author: Arnold
 * @since: 2019/3/23 17:30
 * @version: v1.0.0
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            list.remove(iterator.next());
        }

    }
}
