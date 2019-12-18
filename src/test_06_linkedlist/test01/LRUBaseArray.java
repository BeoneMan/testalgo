package test_06_linkedlist.test01;

import java.util.HashMap;

/**
 * 使用数组底层实现LRU功能
 * 使用map将时间复杂度降为1
 */
public class LRUBaseArray<T> {
    //初始默认容量
    private static final int DEFAULT_CAPACITY=1<<3;
    //容量
    private int capacity;
    //数组长度
    private int length;
    //数组
    private T[]array;
    //HashMap集合
    private HashMap<T,Integer> holder;

    public LRUBaseArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        this.length=0;
        this.holder=new HashMap<>(capacity);
        this.array=(T[])new Object[capacity];
    }

    //模拟访问某个值
    public void offer(T object){
        if(object==null)return;
        if(length==0){
            holder.put(object,0);
            array[0]=object;
            length++;
            return;
        }
        Integer index = holder.get(object);
        if(index==null){
            if(isFull()){
                deleteObjAtEnd();
            }
            rightShift(length);
        }else{
            deleteObj(object);
            rightShift(index);

        }
        addObjAtHead(object);
    }

    private void addObjAtHead(T object) {
        array[0]=object;
        holder.put(object,0);
        length++;
    }

    private void rightShift(int index) {
        for (int i=index-1;i>=0;i--){
            array[i+1]=array[i];
            holder.put(array[i],i+1);
        }
    }

    private void deleteObj(T object) {
        holder.remove(object);
        length--;
    }

    private void deleteObjAtEnd() {
         T obj = array[--length];
         holder.remove(obj);
         length--;
    }

    private boolean isFull() {
        return this.length>=this.capacity;
    }

    public void printAll(){
        for(int i=0;i<length;i++){
            System.out.println("数组"+array[i]+"  ");
            System.out.println("map"+array[i]+","+holder.get(array[i]));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUBaseArray<Integer> lruBaseArray=new LRUBaseArray<>(5);
        lruBaseArray.offer(10);
        lruBaseArray.offer(20);
        lruBaseArray.offer(30);
        lruBaseArray.offer(40);
        lruBaseArray.offer(50);
        lruBaseArray.offer(30);
        lruBaseArray.printAll();
    }

}
