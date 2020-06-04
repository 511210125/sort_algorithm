import java.util.Arrays;

/**
 * message 冒泡排序
 * 时间复杂度O(N*N)
 * 空间复杂度O(1)
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/6/4
 */
public class BubbleSortMain {
    public static void main(String[] args) {
        int[] arr = {10,9,4,0,7,2,5,8,3,6,1};
        bubbleSort(arr);
        System.out.println("最终结果:" + Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j<arr.length - i; j++){ //为什么要-i:冒泡排序排一次就会有一个最大的数移到最右边，范围逐渐缩小。
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第" + i + "次排序结果:"+Arrays.toString(arr));
        }
    }
}
