public class RadixSort {
    /**
     * 基数排序(考虑待排序数字的元素中包含负数)
     * @param number 待排序数组
     * @param d 数组元素中最大位数
     */
    public void radixSort(int [] number , int d){
        int k = 0; //重新组织桶中数据的索引值
        int n = 1; //数据取余/除的权值
        int m = 1; //记录已排序位数的个数
        /*temp数组，分为十个桶，每个桶最大容量是number的长度（待排序数字的个数）*/
        int [][]temp = new int[19][number.length];
        /*order用于记录每个桶中一共有多少个数字*/
        int [] order = new int [19];
        while(m < d){
            /*装桶过程*/
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10)+9;
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            /*桶中的数字重新组织*/
            for(int i = 0; i < order.length; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            m ++;
            k = 0;
        }
    }
}
