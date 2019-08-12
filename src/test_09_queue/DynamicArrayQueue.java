package test_09_queue;

/**
 * 用数组实现队列
 * 优点：对内存碎片进行处理
 *
 * @author DriveMan
 */
public class DynamicArrayQueue {
    // 数组：items，数组大小：n
    private int n = 0;
    private String[] items;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue() {
        this(10);
    }

    public DynamicArrayQueue(int capacity) {
        this.n = capacity;
        this.items = new String[10];
    }

    //入队
    public boolean enqueue(String item) {
        // tail == n表示队列末尾没有空间了
        if (tail == n) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0)return false;
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head=0;
        }
        items[tail++]=item;
        return true;
    }

    //出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        return items[head++];
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArrayQueue aq=new DynamicArrayQueue();
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
