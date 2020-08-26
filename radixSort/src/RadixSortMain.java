import java.util.Arrays;

/**
 * message 基数排序
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/8/25
 */
public class RadixSortMain {
    public static void main(String[] args) {
        int size = 8000000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size);
        }
//        int[] arr = {99,5,8,2,4,1,3,121,11,7};
        long start = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //多少进制建立多少库
        int binary = 10;
        //建立基数存储空间
        int[][] bucket = new int[binary][arr.length];
        int[] bucketIndex = new int[binary];
        int bit = 0;
        int max = getMax(arr);
        while (max != 0) {
            max /= 10;
            //将数据放在对应的桶中
            for (int k : arr) {
                int index = k / ((int) Math.pow(10, bit)) % 10;
                bucket[index][bucketIndex[index]++] = k;
            }

            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucketIndex[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                bucketIndex[i] = 0;
            }
            bit++;
        }
    }

    /**
     * 拿到最大的数
     * @param arr 数组
     * @return 数组中最大的数
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
