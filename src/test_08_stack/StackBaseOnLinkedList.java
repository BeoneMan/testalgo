package test_08_stack;
/**
 * 基于链表实现的栈。
 *
 * Author: DriveMan
 */
public class StackBaseOnLinkedList {
    private Node top;
    //进栈
    public void push(int data){
        Node newNode=new Node(data,null);
        if(top==null){
            top=newNode;
        }else{
            newNode.setNext(top);
            top=newNode;
        }
    }

    //弹栈
    public int pop(){
        int topData=top.getData();
        if(top==null)return -1;
        top=top.next;
        return topData;
    }



    public  class Node{
        private int data;
        private Node next;

        public Node() {
            this(0,null);
    }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackBaseOnLinkedList stack=new StackBaseOnLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.printAll();

        stack.pop();
        stack.printAll();
    }

}
