package test_11_sorts;

import java.util.Arrays;

/**
 * 冒泡排序、插入排序、选择排序
 * <p>
 * Author: DriveMan
 */

//arr是数组,n是数组的个数
public class Sorts {
    //冒泡排序
    public static void bubbleSort(int[] arr ,int n){
        if(n<=1)return;
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag)break;
        }
    }



    //优化冒泡排序
    public static void bubbleSort2(int[] a ,int n){

        if (n <= 1) return;

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) break;    // 没有数据交换，提前退出
        }
    }

    //左神冒泡排序
    public static void bubbleSort3(int[]a,int n){
        if(n<=0)return;
        for(int i=n-1;n>0;n--){
            boolean flag=false;
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag)break;
        }
    }

    //插入排序
    public static void insertSort(int[] a,int n){
        if(n<=0)return;
        for(int i=1;i<n;i++){
           int value=a[i];
           int j=i-1;
           for(;j>=0;j--){
               if(a[j]>value){
                   a[j+1]=a[j];
               }else{
                   break;
               }
           }
           a[j+1]=value;
        }
    }

    //选择排序
    public static void selectionSort(int[] a,int n){
        if(n<=0)return;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n-1;j++){
                if(a[j]>a[j+1]){
                    minIndex=j+1;
                }
            }
            int temp=a[i];
            a[i]=a[minIndex];
            a[minIndex]=temp;
        }
    }


    public static void main(String[] args) {
        //冒泡排序测试
        /*int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));*/
        //优化后冒泡排序测试
        /*int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort2(array, array.length);
        System.out.println(Arrays.toString(array)); */
        //左神冒泡排序
       /* int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort3(array, array.length);
        System.out.println(Arrays.toString(array));*/

        //插入排序
        /*int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        insertSort(array, array.length);
        System.out.println(Arrays.toString(array));  */

        //选择排序
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
