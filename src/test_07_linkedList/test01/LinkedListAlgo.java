package test_07_linkedList.test01;


/**
 * 1.单链表反转
 * 2.链表环中检测
 * 3.两个有序的链表合并
 * 4.删除链表倒数第k个节点
 * 5.求链表中间节点
 */
public class LinkedListAlgo {

    //1.单链表反转
    public static Node reverse(Node list) {
        Node curr = list;
        Node pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //2.链表环中检测
    public static boolean checkCircle(Node list) {
        if (list == null) return false;
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    //3.两个有序的链表合并
    public static Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node solder = new Node(null, null);
        Node p = solder;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                solder.next = l2;
                l2 = l2.next;
            }
            p = p.next;

        }

        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;
        return solder.next;

    }


    public static void printAll(Node list) {
        if (list == null) return;
        while (list.next != null) {
            System.out.print(list.getData() + " ");
            list = list.next;
        }
    }


    public static class Node {
        private Integer data;
        private Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


}
