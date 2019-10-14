/**
 * 选择排序
 */

public class SelectionSort {
    /**
     * 选择排序的思想：将i-n的最小值交换到i的位置，i逐渐递增直到为数组的长度减一排序完成
     * @param arr 待排序数字
     */
    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            //记录最小元素下标
            int  min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

    }
}
