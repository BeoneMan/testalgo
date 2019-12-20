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
        Node fast = list.next;
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
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;

        }

        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;
        return solder.next;

    }

    //4.删除链表倒数第k个节点
    public static Node removeLastAtK(Node listNode, int k) throws Exception {

        if (k <= 0) return listNode;
        Node p = listNode;
        Node head = listNode;

        //计算链表是否有k个节点
        int pos = 1;
        while (p.next != null) {
            p = p.next;
            pos++;
        }
        if (pos < k) throw new Exception("k值错误，链表并没有这么长");

        p = listNode;
        int i = 1;
        while (i < k) {
            p = p.next;
            i++;
        }

        Node pre = null;
        while (p.next != null) {
            p = p.next;
            pre = head;
            head = head.next;
        }

        //删除倒数最后一个，也就是删除链表第一个
        if (pre == null) {
            Node ret = listNode.next;
            listNode = null;
            return ret;
        }

        pre.next = pre.next.next;
        head = null;
        return listNode;
    }

    //5.求链表中间节点
    public static Node selectMiddleNode(Node listNode) {
        if (listNode == null || listNode.next == null) return listNode;
        Node fast = listNode.next;
        Node slow = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            System.out.println("中间节点有两个：" + slow.data + "和" + slow.next.data);
        }
        return slow;
    }


    public static void printAll(Node list) {
        if (list == null) return;
        while (list != null) {
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

    public static void main(String[] args) throws Exception {
        //把链表反转
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        System.out.println("反转前");
        printAll(node);
        System.out.println();
        System.out.println("反转后");
        Node reverseNode = LinkedListAlgo.reverse(node);
        printAll(reverseNode);
        System.out.println();

        //链表环中检测

/*        Node node2 =new Node(1,new Node(2,new Node(3,new Node(4,null))));

        System.out.println("有环的链表");
        boolean b = checkCircle(node2);
        System.out.println(b);*/

        Node node2 = new Node(0, null);
        Node node3 = new Node(1, new Node(2, new Node(3, new Node(4, node2))));
        node2.next = node3;
        System.out.println("有环的链表");
        boolean b = checkCircle(node2);
        System.out.println(b);

        //有序链表合并
        System.out.println("有序链表合并");
        Node node4 = new Node(1, new Node(2, new Node(4, new Node(5, null))));
        Node node5 = new Node(0, new Node(3, new Node(5, new Node(7, null))));
        Node mergeNode = mergeTwoLists(node4, node5);
        printAll(mergeNode);

        //删除倒数第k个节点
        System.out.println("删除倒数第k个节点");
        Node node6 = new Node(1, new Node(2, new Node(4, new Node(5, null))));
        System.out.println("删除前");
        printAll(node6);
        System.out.println();
        Node nodeList = removeLastAtK(node6, 2);
        System.out.println("删除后");
        printAll(nodeList);
        System.out.println();

        //求链表中间节点
//        Node node7 = new Node(1, new Node(2, new Node(4, new Node(5, null))));
        Node node7 = new Node(1, new Node(2, new Node(4, new Node(5, new Node(6, null)))));
        System.out.print("链表");
        printAll(node7);
        Node node8 = selectMiddleNode(node7);
        System.out.println("中间节点为：" + node8.data);
    }
}
