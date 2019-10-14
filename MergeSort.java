/**
 * 归并排序
 */

public class MergeSort {
    public void mergeSort(int [] list){
        if(list.length>1){
            /**
             * 划分数组
             */
            int[] firstHalf = new int[list.length/2];
            System.arraycopy(list,0,firstHalf,0,list.length/2);
            mergeSort(firstHalf);
            int secondHalfLength = list.length - list.length/2;
            int [] secondHalf = new int[secondHalfLength];
            System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
            mergeSort(secondHalf);
            /**
             * 合并数组
             */
            merge(firstHalf,secondHalf,list);
        }
    }
    public void merge(int [] list1, int [] list2, int [] temp){
        int current1 = 0;
        int current2 = 0;
        //current3记录最终合并数组的索引
        int current3 = 0;
        while(current1 < list1.length && current2 < list2.length){
            if (list1[current1] < list2[current2]){
                temp[current3++] = list1[current1++];
            }else {
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length ){
            temp[current3++] = list1[current1++];
        }
        while (current2 < list2.length){
            temp[current3++] = list2[current2++];
        }
    }
}
