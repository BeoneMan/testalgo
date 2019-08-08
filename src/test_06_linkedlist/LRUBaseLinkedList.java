package test_06_linkedlist;

import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 * @author DriveMan
 * @create 2019-8-7
 */
public class LRUBaseLinkedList<T> {

    //默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;
    //链表容量
    private Integer capacity;

    //链表实际长度
    private Integer length;

    //链表头节点
    private Node<T> head;

    //链表有参构造
    public LRUBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = new Node<>();
    }


    //链表无参构造
    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    //节点
    public  class Node<T> {
        private Node<T> next;
        private T data;

        public Node() {
            this.next=null;
            this.data=null;
        }

        public Node(Node<T> next, T data) {
            this.next = next;
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


    //添加一个元素
    public void add(T element){
        //查询链表是否存在该元素，返回该元素的上一个元素
        Node preNode =findPreByEle(element);
        //存在
        if(preNode!=null){
            //删除该元素
            remove(preNode);
            //把该元素加到链表头部【在head之后插入element节点】
            addEleNodeToHead(element);
        }else{
            //不存在
            //判断链表是否已经装满
            //满
            //删除链表最尾部
            if(length>=this.capacity){
                //删除尾节点
                removeLast();
            }

            //未满
            //把该元素加到链表头部【在head之后插入element节点】
            addEleNodeToHead(element);
        }





    }

    private void removeLast() {
        Node p=head;
       //空链表直接返回
        if(head.getNext()==null)return;

        //倒数第二个
        while(p.getNext().getNext()!=null){
            p=p.next;
        }
        Node tmp=p.getNext();
        p.setNext(null);
        tmp=null;
        length--;


    }

    //在head之后插入element节点
    private void addEleNodeToHead(T element) {
        Node next=head.getNext();
        head.setNext(new Node(next,element));
        length++;
    }

    //删除该元素
    private void remove(Node preNode) {
        //该元素的node
        Node tmp=preNode.getNext();
        preNode.next=tmp.next;
        tmp=null;
        length--;
    }

    private Node findPreByEle(T element) {
        Node p=head;
        while(p.next!=null){
            if(  p.next.data.equals(element)){
                return p;
            }else{
                p=p.next;
            }
        }
        return null;
    }

    private void printAll() {
        Node node = head.getNext();
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }


}
