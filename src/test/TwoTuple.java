package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2018/12/31 15:57
 * @version: v1.0.0
 */
public class TwoTuple<A,B> {
    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a+" "+b;
    }

    public static void main(String[] args) {
        TwoTuple<String , Integer> tuple=new TwoTuple<>("222",111);
        System.out.println(tuple);

        String readA=tuple.a;
        System.out.println(readA);
//        tuple.a="234";

    }
}

class ThreeTuple<A,B,C> extends TwoTuple< A,B>{
    public final C c;
    public ThreeTuple(A a,B b,C c){
        super(a,b);
        this.c=c;
    }

    @Override
    public String toString() {
        return a+" "+b+" "+c;
    }
}
