import java.util.Arrays;

/**
 * message 选择排序
 * 排序 80000 消耗时间 消耗时间:3019 3秒,快于冒泡排序
 * 时间复杂度O(N*N)
 * 空间复杂度O(1)
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/8/11
 */
public class SelectionSortMain {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        long startTime = System.currentTimeMillis();
        selectionSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间:" + (endTime - startTime));

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (arr[minIndex] != arr[i]) {//已经再是第一位置,说明发生了交换
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
