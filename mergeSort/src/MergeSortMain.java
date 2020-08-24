import java.util.Arrays;

/**
 * message 归并排序
 * 时间复杂度 O(n*logn))
 * 空间复杂度 O(n)
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/8/24
 */
public class MergeSortMain {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        long start = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间:" + (end - start));
//        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        split(arr,0,arr.length - 1);
    }

    private static void split(int[] arr,int left,int right) {
        if (left >= right) {
            return;
        }
        //分组中介点下标
        int mid = left + ((right - left) >> 1);
        //继续分左边
        split(arr, left, mid);
        //继续分右边
        split(arr, mid + 1,right);
        //治
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //排序时会将排序结果存放到该临时数组
        int[] temp = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            temp[tempIndex++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }
        while (leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = arr[rightIndex++];
        }
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
