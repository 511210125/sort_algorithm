import java.util.Arrays;

/**
 * message 快速排序
 * 80000 消耗时间在 15-40ms之间,排序速度不稳定
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/8/13
 */
public class QuickSortMain {
    public static void main(String[] args) {
//        int arr[] = {1,3,2,4,5};
        int size = 8000000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        long startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间:" + (endTime - startTime));
//        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        int pivot = arr[(l + r) / 2];
        while (l < r) {
            //左边用一个下标找,当找到一个比基值大的,停止
            while (arr[l] < pivot) {
                l++;
            }

            //右边用一个下标找,当找到一个比基值小的,停止
            while (arr[r] > pivot) {
                r--;
            }

            //左边的指针和右边的指针重合,表示找完了
            if (l == r) {
                break;
            }

            //交换位置
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //防止左右两个值与中间值相等一直执行
            if (arr[l] == arr[r]) {
                r--;
                l++;
            }

        }

        //如果该数值被两个指针同时指向时,为了避免无限递归,需要缩小递归范围,该数值不参与递归
        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort(arr,left,r);
        }

        if (right > l) {
            quickSort(arr,l,right);
        }

    }
}
