package test_09_queue;

/**
 * 用数组实现循环队列
 *
 * @author DriveMan
 */
public class CircularQueue {
    private int n = 0;
    private String[] items;

    private int head = 0;
    private int tail = 0;

    public CircularQueue() {
        this(10);
    }

    public CircularQueue(int capacity) {
        this.n = capacity;
        this.items = new String[10];
    }

    //入队
    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue(){
        if(head==tail)return null;
        String ret=items[head];
        head=(head+1)%n;
        return ret;
    }
    public void printAll() {
        if (0 == n) return;
        for (int i = head; i % n != tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue aq=new CircularQueue();
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
        aq.enqueue("吗");
        aq.printAll();
    }

}
