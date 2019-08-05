package test_06_linkedlist;
/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * Author：DriveMan
 */
public class SinglyLinkedList {
    private Node head;
    public static class Node{
        private Node next;
        private int data;
        public Node(int data,Node next){
            this.next=next;
            this.data=data;
        }

        @Override
        public String toString() {
            return "Node:"+data;
        }
    }

    //根据value寻找Node节点
    public Node findByValue(int value){
        Node p=head;
        while(p!=null&&p.data!=value){
            p=p.next;
        }
        return p;

    }

    //根据index寻找Node节点
    public Node findByIndex(int index){
        int pos=0;
        Node p=head;
        while(p!=null&&pos!=index){
            p=p.next;
            pos++;
        }
        return p;
    }


    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value){
        Node newNode=new Node(value,null);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    }


    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode=new Node(value,null);
        if(head==null){
            head=newNode;
        }else{
            Node p=head;
            while(p!=null&&p.next!=null){
                p=p.next;
            }
            newNode.next=p.next;
            p.next=newNode;
        }
    }


    //把value插入在指定Node节点之后
    public void insertAfterByNode(Node node,int value){
        Node newNode=new Node(value,null);
        if(node==null)return;
        newNode.next=node.next;
        node.next=newNode;
    }



    //把value插入在指定Node节点之前
    public void insertBeforeByNode(Node node ,int value){
        Node newNode=new Node(value,null);
        if(node==null)return;
        if(head==node){
            insertToHead(value);
            return;
        }
        Node p=head;

        while(p!=null&&p.next!=node){
            p=p.next;
        }
        if(p==null)return;
        newNode.next=node;
        p.next=newNode;


    }


    //删除指定Node节点
    public void deleteByNode(Node node){
        if(node==null||head==null)return;
        if(node==head){
            head=head.next;
            return;
        }
        Node p=head;
        while(p!=null&&p.next!=node){
            p=p.next;
        }
        if(p==null)return;
        p.next=p.next.next;
    }

    //根据value删除Node节点
    public void deleteByValue(int value){
        if(head==null)return;
        Node newNode=new Node(value,null);
        Node p=head;
        Node q=null;
        while(p!=null&&p.data!=value){
            q=p;
            p=p.next;
        }
        if(p==null)return;
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
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


    public static void main(String[]args){

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        // int data[] = {1,2,5,2,1};
        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
         link.printAll();
        System.out.println(link.findByValue(2));
        System.out.println(link.findByIndex(2));

        link.insertToHead(11);
        link.printAll();
        link.insertTail(500);
        link.printAll();
        link.insertAfterByNode(link.findByValue(2),4);
        link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

      /*  System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }*/
    }
}
