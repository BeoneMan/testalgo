package test_08_stack;

import java.time.temporal.ChronoUnit;

/**
 * 使用前后栈实现浏览器的前进后退。
 *
 * @author DriveMan
 */
public class SampleBrowser {
    private String currentPage;
    private LinkedListBasedStack forwardStack;
    private LinkedListBasedStack backStack;

    //无参构造
    public SampleBrowser(){
        this.forwardStack=new LinkedListBasedStack();
        this.backStack=new LinkedListBasedStack();
        this.currentPage=null;
    }
    //查询当前页面
    public String checkCurrentPage(){
        return this.currentPage;
    }

    //能否前进
    public Boolean IsCanForward(){
        return forwardStack.getSize()>0;
    }
    //能否后退
    public Boolean IsCanBack(){
        return backStack.getSize()>0;
    }
    //打开新页面
    public void open(String url){
        if(currentPage!=null){
            this.backStack.push(url);
            this.forwardStack.clear();
        }
        showUrl(url,"open");

    }

    private void showUrl(String url, String prefix) {
        this.currentPage=url;
        System.out.println("prefix:"+prefix+"  +url:"+url);
    }

    //前进

    //后退




    //基于链表实现的栈
    public static class LinkedListBasedStack {
        private int size;
        private Node top;

        //进栈
        public void push(String str) {
            Node newNode = createNode(str, this.top);
            this.top = newNode;
            ++size;
        }

        //出栈
        public String pop(){
            if(top==null)return null;
            String topString = top.getData();
            top=top.next;
            if(getSize()>0){
                size--;
            }
            return topString;
        }
        //实际个数
        public int getSize(){
            return this.size;
        }
        //获取top数据
        public String getTopData(){
            if(top==null)return null;
            return top.getData();
        }

        //清除链表
        public void clear(){
            this.top=null;
            this.size=0;
        }

        //创建节点
        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        //节点对象
        public static class Node {
            private String data;
            private Node next;

            public Node() {
                this(null, null);
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

        public void print() {
            System.out.println("Print stack:");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.print(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

    }


}
