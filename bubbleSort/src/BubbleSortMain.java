import java.util.Arrays;

/**
 * message 冒泡排序
 * 时间复杂度O(N*N)
 * 空间复杂度O(1)
 * 普通版冒泡排序 排序80000条 消耗时间:11576 比较次数:3199960000
 * 加强版冒泡排序 排序80000条 消耗时间:11514 比较次数:3199940694
 * 总结每次有一个数据到达目标位置
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/6/4
 */
public class BubbleSortMain {
    public static void main(String[] args) {
        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size);
        }
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
        long startTime = System.currentTimeMillis();
        smartBubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间:" + (endTime - startTime));

//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原版
     *
     * @param arr 要排序的数组
     */
    private static void bubbleSort(int[] arr) {
        long exe = 0;//记录执行次数
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) { //为什么要-i:冒泡排序排一次就会有一个最大的数移到最右边，范围逐渐缩小。
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                exe++;
            }
        }
        System.out.println("比较次数:" + exe);
    }

    /**
     * 加强版,如果有一次排序已经未发生交换,则排序完成
     *
     * @param arr 要排序的数组
     */
    private static void smartBubbleSort(int[] arr) {
        long exe = 0;
        boolean flag;
        for (int i = 1; i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
                exe++;
            }
            if (!flag) {
                break;
            }
        }
        System.out.println("比较次数:" + exe);
    }
}
