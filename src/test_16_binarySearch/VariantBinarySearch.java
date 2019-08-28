package test_16_binarySearch;

/**
 * 二分查找变形问题
 * author:DriveMan
 */
public class VariantBinarySearch {
    //1.查找第一个值等于给定值的元素
    public static int findFirstIndexByValue(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + (hight - low >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                hight = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) return mid;
                else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

    //2.查找最后一个值等于给定值的元素
    public static int findLastIndexByValue(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + (hight - low >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                hight = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != value) return mid;
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //3.查找第一个大于等于给定值的元素
    public static int findGreaterAndEqualByValue(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + (hight - low >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] >= value) {
                if (arr[mid - 1] < value) return mid;
                else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

    //4.查找最后一个小于等于给定值的元素
    public static int findLessAndEqualByValue(int[] arr, int n, int value) {
        if (n <= 0) return -1;
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + (hight - low >> 1);
            if (arr[mid] > value) {
                hight = mid - 1;
            } else if (arr[mid] <= value) {
                if (arr[mid + 1] > value) return mid;
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 5;
        arr[5] = 5;
        arr[6] = 6;
        arr[7] = 7;

        int firstIndexByValue = VariantBinarySearch.findFirstIndexByValue(arr, arr.length, 5);
        System.out.println("查找第一个值等于5的索引值是:     " + firstIndexByValue);

        int findLastIndexByValue = VariantBinarySearch.findLastIndexByValue(arr, arr.length, 5);
        System.out.println("查找最后一个值等于5的索引值是:     " + findLastIndexByValue);

        int findGreaterAndEqualByValue = VariantBinarySearch.findGreaterAndEqualByValue(arr, arr.length, 6);
        System.out.println("查找第一个大于等于6的索引值是:     " + findGreaterAndEqualByValue);

        int findLessAndEqualByValue = VariantBinarySearch.findLessAndEqualByValue(arr, arr.length, 5);
        System.out.println("查找最后一个小于等于给定元素值的索引值是:     " + findLessAndEqualByValue);
    }

}
