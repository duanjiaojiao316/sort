import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InsertionSort insertionSort = new InsertionSort();
        int [] n1 = {2,3,2,5,6,1,-2,3,14,12};
        insertionSort.insertionSort(n1);
        System.out.println("插入排序：");
        for (int n:n1
             ) {
            System.out.print(n + " ");
        }
        System.out.println();
        int [] n2 = {2,3,2,5,6,1,-2,3,14,12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(n2);
        System.out.println("冒泡排序：");
        for (int n:n2
        ) {
            System.out.print(n + " ");
        }
        System.out.println();
        int [] n3 = {2,3,2,5,6,1,-2,3,14,12};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(n3);
        System.out.println("归并排序：");
        for (int n:n3
        ) {
            System.out.print(n + " ");
        }
        System.out.println();
        int [] n4 = {2,3,2,5,6,1,-2,3,14,12};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(n4);
        System.out.println("快速排序：");
        for (int n:n4
        ) {
            System.out.print(n + " ");
        }
        System.out.println();
        Integer [] n5 = {2,3,2,5,6,1,-2,3,14,12};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(n5);
        System.out.println("堆排序：");
        for (int n:n5
        ) {
            System.out.print(n + " ");
        }
        System.out.println();
        int [] n6 = {42,13,2,-95,65,-41,82,1143,149,182};
        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(n6,4);
        System.out.println("基数排序：");
        for (int n:n6
        ) {
            System.out.print(n + " ");
        }
        System.out.println();

        SortLargeFile sortLargeFile = new SortLargeFile();
        sortLargeFile.sort("largedata.bat","sortedfile.bat");
        sortLargeFile.displayFile("sortedfile.bat");


    }
}
