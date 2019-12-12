package test_06_linkedlist.test01;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 * <p>
 * Author：driveman
 */

public class SinglyLinkedList {
    private Node head;

    //通过value寻找并返回Node
    public Node findByValue(int value) {
        if (head == null) return null;
        Node next = head.next;
        while (next != null && next.data != value) {
            next = next.next;
        }
        if (next == null) return null;
        return next;
    }

    //通过index寻找并返回Node
    public Node findByIndex(int index) {
        if (head == null) return null;
        if (index == 0) return head;
        int pos = 0;
        Node p = head;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    //表头部插入
    public void insertHead(int value) {
        insertHead(new Node(value, null));
    }

    private void insertHead(Node newNode) {
        if (head == null) head = newNode;
        Node p = head;
        newNode.next = p;
        head = newNode;
    }

    //尾部插入
    public void insertTail(int value) {
        insertTail(new Node(value, null));
    }

    private void insertTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next=q.next;
            q.next = newNode;
        }

    }

    //在哪个节点前插入
    public void insertBefore(Node node ,int value){
        if(head==null||node==null)return;
        Node newNode=new Node(value,null);
        
    }

    //在哪个节点后插入

    //通过value删除Node节点
    //通过index删除Node节点


    public static class Node {
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
