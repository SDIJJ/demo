package test;

/**
 * @Description:
 * @author: Arnold
 * @since: 2019/1/1 8:45
 * @version: v1.0.0
 */
public class LinkedStack<T> {
    private class Node<T>{
        T t;
        Node<T> next;
        public Node(){
            this.t=null;
            this.next=null;
        }
        public Node(T t,Node next){
            this.t=t;
            this.next=next;
        }
        boolean end(){return t==null&&next==null; }
    }
    private int  count=0;
    private Node<T> top=new Node<>();
    public int size(){return count;}
    public void push(T t){
        top=new Node(t,top);
        count++;
    }
    public T pop(){
        T result=top.t;
        if(!top.end()){
            top=top.next;
        }
        count--;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack=new LinkedStack<>();
        linkedStack.push("123123");
        linkedStack.push("222");
        linkedStack.push("333");
        linkedStack.push("444");
        System.out.println(linkedStack.size());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.size());

    }

}
