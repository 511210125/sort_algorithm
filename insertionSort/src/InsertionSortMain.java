import java.util.Arrays;

/**
 * message 插入排序和希尔排序
 * 希尔排序 是 插入排序的一种优化排序
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/8/12
 */
public class InsertionSortMain {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        long startTime = System.currentTimeMillis();
//        insertSort(arr);//直接插入 消耗时间:578
//        changeShellSort(arr);//交换 消耗时间:6780
        insertShellSort(arr);//移位 消耗时间:15
        long endTime = System.currentTimeMillis();

        System.out.println("消耗时间:" + (endTime - startTime));

    }


    /**
     * 普通插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int currentIndex = i - 1;
            while (currentIndex >= 0 && currentValue < arr[currentIndex]) {
                arr[currentIndex + 1] = arr[currentIndex];
                currentIndex--;
            }
            arr[currentIndex + 1] = currentValue;
        }
    }

    /**
     * 交换版shell排序
     *
     * @param arr
     */
    private static void changeShellSort(int[] arr) {
        int step = arr.length / 2;
        int temp;
        while (step > 0) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j = j - step) {
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
            step /= 2;
//            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 移位版shell排序
     *
     * @param arr
     */
    private static void insertShellSort(int[] arr) {
        int step = arr.length / 2;
        while (step > 0) {
            for (int i = step; i < arr.length; i++) {
                int currentIndex = i;
                int currentValue = arr[i];
                while (currentIndex - step >= 0 && currentValue < arr[currentIndex - step]) {
                    arr[currentIndex] = arr[currentIndex - step];
                    currentIndex = currentIndex - step;
                }
                arr[currentIndex] = currentValue;
            }
            step /= 2;
        }
    }


}
