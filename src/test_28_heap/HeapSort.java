package test_28_heap;

import java.util.Arrays;

/**
 * 堆排序
 * author:DriveMan
 */
public class HeapSort {
    public static void sort(int[] arr) {
        if (arr.length - 1 <= 0) return;
        //1:建堆
        buildHeap(arr);

        //2:排序
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, k, 0);
            heapify(arr, --k, 0);
        }

    }

    private static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点

        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    //堆化
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            //最大值
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if ((i * 2 + 1) <= n && arr[i * 2 + 1] > arr[i]) maxPos = i * 2 + 1;
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if ((i * 2 + 2) <= n && arr[i * 2 + 2] > arr[maxPos]) maxPos = i * 2 + 2;
            // 最大值是当前位置结束循环
            if (maxPos == i) break;

            //与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }

    }

    private static void swap(int[] arr, int i, int maxPos) {
        int temp = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 43, 65, 4, 7, 8, 745, 0};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
