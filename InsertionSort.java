public class InsertionSort {
    /**
     * 插入排序
     * @param list
     */
    public void insertionSort(int [] list){
        for (int i = 0; i < list.length; i++) {
            //currentElement记录当前需要插入到已排好序的数组中的元素
            int currentElement = list[i];
            int j ;
            //相较于选择排序，插入排序比较其与前一个元素的大小，然后判断是否交换
            // 而选择排序是直接将最小的放置在开头
            for (j = i - 1; j >= 0 && list[j] > currentElement ; j--) {
                    list[j + 1] = list[j];
            }
            //注意在退出循环的时候j--所以此处为j+1
            list[j + 1] = currentElement;
        }
    }
}
