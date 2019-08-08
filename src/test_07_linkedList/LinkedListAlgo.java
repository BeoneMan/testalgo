package test_07_linkedList;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * <p>
 * Author: DriveMan
 */
public class LinkedListAlgo {
    //1) 单链表反转
    public static Node reverse(Node list) {
        Node p1 = list;
        Node p2 = p1.next;
        Node p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        list.next = null;
        list = p1;

        return list;
    }

    //2) 链表中环的检测
    public static Boolean checkCircle(Node list) {
        if (list == null || list.next == null) return false;
        Node head = list;
        Node p1 = head.next;
        Node p2 = head.next.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return false;
    }

    //3) 两个有序的链表合并
    public static Node mergeSortedLists(Node node1,Node node2){
        Node a=node1;
        Node b=node2;
        Node head =null;
        if(a.getData()<b.getData()){
            head=a;
            a=a.next;
        }else{
            head=b;
            b=b.next;
        }
        Node p=head;
        while(a!=null&&b!=null){
            if(a.getData()<b.getData()){
                p.next=a;
                a=a.next;

            }else{
                p.next=b;
                b=b.next;

            }
            p=p.next;
        }
        if(a!=null){
            p.next=a;
        }else{
            p.next=b;
        }
        return head;

    }

    public static class Node {
        private Integer data;
        private Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }


        public Integer  getData() {
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
        //把链表反转
       /* Node node =new Node(1,new Node(2,new Node(3,new Node(4,null))));
        printAll(node);
        Node reverseNode = LinkedListAlgo.reverse(node);
        printAll(reverseNode);*/

        //判断是否链表有环
     /*   Node node = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        Node head = new Node(0, node);
        node.next.next.next.next = head;
        if (checkCircle(node)) {
            System.out.println("有环");
        } else {
            System.out.println("无环");
        }*/

        //3) 两个有序的链表合并
        Node node1 = new Node(1, new Node(6, new Node(11, new Node(19, null))));
        Node node2 = new Node(2, new Node(3, new Node(8, new Node(20, new Node(25,new Node(30,null))))));
        Node node = mergeSortedLists(node1, node2);
        printAll(node);

    }
}
