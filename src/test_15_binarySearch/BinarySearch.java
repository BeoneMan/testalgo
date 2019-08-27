package test_15_binarySearch;

import java.util.Arrays;

/**
 * 简化版的二分查找
 * author:DriveMan
 */
public class BinarySearch {
    /**
     * 非递归
     *
     * @param arr   数组
     * @param n     数组长度
     * @param value 要查找的值
     * @return -1 则代表没有找到
     */
    public static int search(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + (hight - low >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    public static int searchByRecursion(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        return searchByRecursion(arr, 0, n - 1, value);
    }

    private static int searchByRecursion(int[] arr, int low, int hight, int value) {
        if (low > hight) return -1;
        int mid = low + (hight - low >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            searchByRecursion(arr, mid + 1, hight);
        } else {
            searchByRecursion(arr, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("arr的数组是" + Arrays.toString(arr));

        int searchIndex = BinarySearch.search(arr, arr.length, 3);
        System.out.println("非递归：查找的值所在数组的索引值是" + searchIndex);
        int searchIndex2 = BinarySearch.searchByRecursion(arr, arr.length, 3);
        System.out.println("递归：查找的值所在数组的索引值是" + searchIndex2);

    }
}
