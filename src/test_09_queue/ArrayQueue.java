package test_09_queue;

/**
 * 用数组实现非常基础的队列
 * 缺点：没有对内存碎片进行处理
 *
 * @author DriveMan
 */
@SuppressWarnings("all")
public class ArrayQueue {
    //容量
    private int n=0;
    //数组
    private String[] items;

    // head表示队头下标，tail表示队尾下标
    private int head=0;
    private int tail=0;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.n=capacity;
        this.items=new String[capacity];
    }

    //入队
    public boolean enqueue(String item){
        if(tail==n)return false;
        items[tail++]=item;
        return true;
    }

    //出队
    public String dequeue(){
        if(head==tail)return null;
        String ret=items[head++];
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayQueue aq=new ArrayQueue();
        aq.enqueue("世");
        aq.enqueue("界");
        aq.enqueue("你");
        aq.enqueue("好");
        aq.enqueue("吗");
        aq.enqueue("！");
        aq.enqueue("世");
        aq.enqueue("界");
        aq.enqueue("你");
        aq.enqueue("好");
        aq.dequeue();
        aq.enqueue("吗");
        aq.printAll();
    }
}
