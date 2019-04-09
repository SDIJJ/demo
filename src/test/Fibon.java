package test;

import java.util.Iterator;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/1 9:23
 * @version: v1.0.0
 */
public class Fibon {
    private int count=0;
    public int next(){
        return fib(count++);
    }
    private int fib(int n){
        if(n<2)
            return 1;
        return fib(n-1)+fib(n-2);
    }

//    public static void main(String[] args) {
//        Fibon fibon=new Fibon();
//        System.out.println(fibon.next());
//        System.out.println(fibon.next());
//        System.out.println(fibon.next());
//        System.out.println(fibon.next());
//    }
}


class IterableFib extends Fibon implements Iterable<Integer> {
    private int n;
    public IterableFib(int  count){
        this.n=count;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFib.this.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for ( int i:new IterableFib(18) ){
            System.out.println(i);
        }


    }
   // public <A> void test(A a){}
}
