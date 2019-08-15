package test_12_sorts;

import java.util.Arrays;

/**
 * 快速排序
 * author:DriveMan
 */
public class QuickSort {
    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        //获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int i=p;
        int pivot=a[r];
        for(int j=p;j<=r;j++){
            if(a[j]<pivot){
                if(i==j){
                    i++;
                }else{
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                    i++;
                }
            }
        }
        int temp=a[r];
        a[r]=a[i];
        a[i]=temp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        quickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
