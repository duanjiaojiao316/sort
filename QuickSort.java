/**
 * 快速排序，在数组中选择一个基准，将数组分成两个部分，使得第一部分的所有元素小于这个基准，
 * 第二部分的所有元素大于这个基准，分别对第一部分以及第二部递归的进行快速排序
 */
public class QuickSort {
    /**
     * quick方法用于对数组进行分区
     * @param list
     */
    public void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);

        }
    }

    /**
     * 特定范围子数组进行排序
     * @param list 数组
     * @param first 子数组起始索引
     * @param last 子数组终止索引
     * @return
     */
    public int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && list[low] < pivot) {
                low++;
            }
            while (low <= high && list[high] > pivot) {
                high--;
            }
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot) {
            high--;
        }
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}
