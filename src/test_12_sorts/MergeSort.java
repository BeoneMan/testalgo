package test_12_sorts;

import java.util.Arrays;

/**
 * 归并排序
 *
 * author:DriveMan
 */
public class MergeSort {

    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if(p>=r)return;
        //中间点
        int q=p+(r-p)/2;
        //分支递归
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        //将两个有序数组合并成一个有序数组
        merge(a,p,q,r);

    }
    //将两个有序数组合并成一个有序数组
    private static void merge(int[] a, int p, int q, int r) {
        int i=p;
        int j=q+1;
        int k=0;
        int[] temp=new int[r-p+1];
        while(i<=q&&j<=r){
            if(a[i]<a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        while(true){
            if(i<=q){
                temp[k++]=a[i++];
            }else if(j<=r){
                temp[k++]=a[j++];
            }else{
                break;
            }
        }

        for(int t=0;t<temp.length;t++){
           a[p++]=temp[t];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
