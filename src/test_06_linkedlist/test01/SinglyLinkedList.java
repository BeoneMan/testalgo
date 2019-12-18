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
        if (value == head.data) return head;
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        if (p == null) return null;
        return p;
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
            newNode.next = q.next;
            q.next = newNode;
        }

    }

    //在哪个节点前插入
    public void insertBefore(Node node, int value) {
        if (head == null || node == null) return;
        Node newNode = new Node(value, null);
        Node p = head;
        if (node == head) {
            insertHead(newNode);
            return;
        }
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) return;
        newNode.next = node;
        p.next = newNode;
    }

    //在哪个节点后插入
    public void insertAfter(Node node, int value) {
        if (head == null || node == null) return;
        Node p = head;
        Node newNode = new Node(value, null);
        while (p != null && p != node) {
            p = p.next;
        }
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;

    }

    //通过value删除Node节点
    public void deleteByValue(int value) {
        Node deleNode = findByValue(value);
        if (deleNode == null) return;
        if (head == deleNode) {
            head = head.next;
            return;
        }
        Node pre = head;
        while (pre != null && pre.next != deleNode) {
            pre = pre.next;
        }
        pre.next = deleNode.next;
        deleNode=null;
    }

    //通过index删除Node节点
    public void deleteByIndex(int index) {
        if (index == 0) head = head.next;
        Node pre = head;
        int bos = 0;
        while (pre != null && bos != index - 1) {
            pre = pre.next;
            bos++;
        }
        if (pre == null) return;
        pre.next = pre.next.next;
    }

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

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertTail(2);
//        list.printAll();

        list.insertTail(new Node(3, null));
//        list.printAll();
        list.insertHead(10);
//        list.printAll();
        list.insertHead(new Node(5, null));
        list.printAll();
        Node byValue = list.findByValue(10);
        System.out.println("寻找的值为：" + byValue.data);

        Node byIndex = list.findByIndex(0);
        System.out.println("根据索引寻找的值为" + byIndex.data);

        list.insertBefore(byIndex, 1);
        list.printAll();
        Node index2 = list.findByIndex(4);
        list.insertAfter(index2, 90);
        list.printAll();

        list.deleteByValue(5);
        list.deleteByValue(90);
        list.deleteByValue(1);
        list.printAll();

        list.deleteByIndex(0);
        list.deleteByIndex(1);
        list.printAll();

    }
}
