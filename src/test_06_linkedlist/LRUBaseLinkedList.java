package test_06_linkedlist;

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

    //链表头部
    private Node<T> head;

    //链表有参构造
    public LRUBaseLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = new Node<>(null, null);
    }


    //链表无参构造
    public LRUBaseLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    //节点
    public static class Node<T> {
        private Node<T> next;
        private T data;

        public Node() {
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
        //查询链表是否存在该元素，返回该元素的上一个元素
            //存在
                //删除该元素
                //把该元素加到链表头部
            //不存在
                //判断链表是否已经装满
                        //满
                            //删除链表最尾部
                        //未满
                            //然后添加到链表头部
}
