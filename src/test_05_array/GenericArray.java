package test_05_array;
/**
 * 1)  伪ArrayList
 * <p>
 * Author: BeoneMan
 * modify: 2019/8/5
 */
@SuppressWarnings("All")
public class GenericArray<T> {
    private T [] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity){
        this.data=(T[]) new Object[capacity];
        this.size=0;
    }

    // 无参构造方法，默认数组容量为10
    public GenericArray(){
        this(10);
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 获取当前元素个数
    public int getSize(){
        return this.size;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 修改 index 位置的元素
    public boolean set(int index,T element){
        checkIndexByUpdateAndQuery(index);
        data[index]=element;
        return true;
    }



    // 获取对应 index 位置的元素
    public T getElementByIndex(int index){
        checkIndexByUpdateAndQuery(index);

        return data[index];
    }


    // 查看数组是否包含元素e
    public boolean contains(T element){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }


    // 获取对应元素的下标, 未找到，返回 -1
    public int getIndex(T element){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index,T element){
        checkIndexByAdd(index);
        //数组已满
        if(size==data.length){
            //扩容2倍
            resize(data.length*2);
        }
        //数组未满
        for (int i = size-1; i >=index ; i--) {
            data[i+1]=data[i];
        }
        data[index]=element;
        size++;
    }



    // 向数组头插入元素
    public void addFirst(T element){
       add(0,element);
    }

    // 向数组尾插入元素
    public void addLast(T element){
        add(size,element);
    }


    // 删除 index 位置的元素，并返回
    public T removeByIndex(int index){
        checkIndexByUpdateAndQuery(index);
        T ret=data[index];
        for (int i = index+1; i <size ; i++) {
            data[i-1]=data[i];
        }
        size--;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }



    // 删除第一个元素
    public T removeFirst(){
        return removeByIndex(0);
    }

    // 删除末尾元素
    public T removeLast(){
        return removeByIndex(size-1);
    }

    // 从数组中删除指定元素
    public T removeByElement(T element){
        int index = getIndex(element);
        return removeByIndex(index);
    }

    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData=(T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        this.data=newData;
    }

    //查询Index是否越界
    private void checkIndexByUpdateAndQuery(int index) {
        if(index<0||index>=size){
            throw new IllegalArgumentException("Query Or Update failed! Require index >=0 and index < size.");
        }
    }
    //查询Index插入是否越界
    private void checkIndexByAdd(int index) {
        if(index<0||index>size){
            throw new IllegalArgumentException("Query Or Update failed! Require index >=0 and index < =size.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    public static void main(String[] args) {
        GenericArray array = new GenericArray<Integer>(5);
        System.out.println(array.toString());
        array.add(0, 3);
        array.add(0, 4);
        array.add(1, 5);
        array.add(3, 9);
        array.add(4, 10);
        array.add(5, 12);
        System.out.println(array.toString());
        array.set(2,18);
        System.out.println(array.toString());
    }
}