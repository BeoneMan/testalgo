package test_07_linkedList;

import test_06_linkedlist.SinglyLinkedList;

import java.util.LinkedList;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: DriveMan
 */
public class LinkedListAlgo {
    //1) 单链表反转
    public static Node reverse(Node list){
        Node p1=list;
        Node p2=p1.next;
        Node p3=null;
        while(p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        list.next=null;
        list=p1;

        return list;
    }




    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node =new Node(1,new Node(2,new Node(3,new Node(4,null))));
        printAll(node);
        Node reverseNode = LinkedListAlgo.reverse(node);
        printAll(reverseNode);
    }
}
