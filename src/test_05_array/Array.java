package test_05_array;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * <p>
 * Author: BeoneMan
 * modify: 2019/7/31
 */
public class Array {
    //int数组
    private int[] data;
    //数组容量
    private int capacity;
    //实际存储个数
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    //按照下标随机访问操作
    public int findByIndex(int index) {
        //判断索引是否合法
        boolean IsSuccess = indexIsSucceed(index);
        if (IsSuccess) return data[index];
        return -1;

    }
    //数组的插入
    public boolean insert(int index,int value){
        //判断索引是否合法
        if(index<0&&index>count){
            return false;
        }
        //数组内存满
        if(count==capacity){
            return false;
        }
        //数组内存未满

        for(int i=count-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=value;
        count++;
        return true;

    }

    //数组的删除
    public boolean remove(int index){
        //判断索引是否合法
        if(index<0&&index>=count){
            return false;
        }
        for(int i=index+1;i<count;i++){
            data[i-1]=data[i];
        }
        //删除数组末尾元素

        /*int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;*/
        count--;
        return true;
    }

    //判断索引是否合法
    public boolean indexIsSucceed(int index) {
        return index >= 0 && index < count;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(4, 10);
        array.remove(0);
//       array.insert(0, 11);
        array.printAll();
    }

}
