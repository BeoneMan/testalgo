package test_06_linkedlist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 * <p>
 * Author：DriveMan
 */
public class SinglyLinkedList {
    private Node head;

    public static class Node {
        private Node next;
        private int data;

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node:" + data;
        }
    }

    //根据value寻找Node节点
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;

    }

    //根据index寻找Node节点
    public Node findByIndex(int index) {
        int pos = 0;
        Node p = head;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }


    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }


    //顺序插入
    //链表尾部插入
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p != null && p.next != null) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }


    //把value插入在指定Node节点之后
    public void insertAfterByNode(Node node, int value) {
        Node newNode = new Node(value, null);
        if (node == null) return;
        newNode.next = node.next;
        node.next = newNode;
    }


    //把value插入在指定Node节点之前
    public void insertBeforeByNode(Node node, int value) {
        Node newNode = new Node(value, null);
        if (node == null) return;
        if (head == node) {
            insertToHead(value);
            return;
        }
        Node p = head;

        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) return;
        newNode.next = node;
        p.next = newNode;


    }


    //删除指定Node节点
    public void deleteByNode(Node node) {
        if (node == null || head == null) return;
        if (node == head) {
            head = head.next;
            return;
        }
        Node p = head;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) return;
        p.next = p.next.next;
    }

    //根据value删除Node节点
    public void deleteByValue(int value) {
        if (head == null) return;
        Node newNode = new Node(value, null);
        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) return;
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }


    }

    //判断链表是否为回文链表
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            //寻找中间点
            System.out.println("开始寻找中间点");
            if (head.next == null) {
                System.out.println("此链表只有一个元素");
                return true;
            }
            Node p = head;
            Node q = head;
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            Node left = null;
            Node right = null;
            if (q.next == null) {
                //链表是奇数，p刚好是中间节点
                System.out.println("链表是奇数，中间元素刚好为p=" + p.data);
                left = inverseLinkedList(p).next;
                right= p.next;

                System.out.println("左边第一个节点" + left.data);
                System.out.println("右边第一个节点" + right.data);
            } else {
                System.out.println("链表是偶数");
                right = p.next;
                left = inverseLinkedList(p);
            }
            return tfResult(left, right);


        }

    }

    private Node inverseLinkedList(Node end) {
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;
        while (p1!=end) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
        return head;
    }

    //判断两条链表是否相同
    // true or false
    //第一条假设为left，第二条假设为right
    public boolean tfResult(Node left, Node right) {
        Node l = left;
        Node r = right;
        while (l != null && r != null) {
            if (left.data == right.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                break;
            }
        }
        if (l == null && r == null) {
            return true;
        }
        return false;
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

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        // int data[] = {1,2,5,2,1};
        int data[] = {1, 2,  3, 2, 1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
     /*    link.printAll();
        System.out.println(link.findByValue(2));
        System.out.println(link.findByIndex(2));

        link.insertToHead(11);
        link.printAll();
        link.insertTail(500);
        link.printAll();
        link.insertAfterByNode(link.findByValue(2),4);
        link.printAll();
        link.insertBeforeByNode(link.findByValue(2),33);
        link.printAll();
        link.deleteByValue(2);
        link.printAll();

        boolean a = link.tfResult(link.findByValue(2), link.findByValue(2));
        System.out.println(a);
        boolean b = link.tfResult(link.findByValue(2), link.findByValue(3));
        System.out.println(b);*/
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
