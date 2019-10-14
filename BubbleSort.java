public class BubbleSort {
    /**
     * 冒泡排序中最先排好序的部分在数组后方
     * @param list
     */
    public void bubbleSort (int [] list){
        boolean needNextPass = true;
        for (int k = 1; k < list.length&&needNextPass; k++){
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if(list[i] > list [i+1]){
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    //如果有交换，needNextPass就需要再次循环
                    needNextPass = true;
                }
            }
        }
    }

}
