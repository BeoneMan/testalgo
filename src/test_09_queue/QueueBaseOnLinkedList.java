package test_09_queue;
/**
 * 基于链表实现的队列
 *
 * Author: DriveMan
 */
public class QueueBaseOnLinkedList {
    public static class Node{
        private String data;
        private Node next;

        public Node() {
            this.data=null;
            this.next=null;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public QueueBaseOnLinkedList() {
        this(null,null);
    }

    public QueueBaseOnLinkedList(Node head,Node tail) {
        this.head = head;
        this.tail=tail;
    }

    //入队
    public void enqueue(String value){
        Node newNode=new Node(value,null);
        if(this.tail==null){
            this.tail=newNode;
            this.head=newNode;
        }
        else{
            tail.next=newNode;
            tail=tail.next;
        }
    }

    //出队
    public String dequeue(){
        if(head==null)return null;
        String res=head.getData();
        head= head.next;
        if(head==null){
            tail=null;
        }
        return res;
    }



    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueBaseOnLinkedList aq=new QueueBaseOnLinkedList();
        System.out.println(aq.dequeue());
        aq.printAll();
        aq.enqueue("世");
        aq.enqueue("界");
        aq.enqueue("你");
        aq.enqueue("好");
        aq.enqueue("吗");
        aq.enqueue("！");
        aq.enqueue("世");
        aq.enqueue("界");
        aq.enqueue("你");
        aq.enqueue("好");
        System.out.println(aq.dequeue());
        aq.enqueue("吗");
        aq.printAll();
    }
}
