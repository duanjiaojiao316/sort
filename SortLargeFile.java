import java.io.*;
import java.util.Arrays;

public class SortLargeFile {
    public final int MAX_ARRAY_SIZE = 100000;
    public final int BUFFER_SIZE = 100000;
    /**
     *  从文件中读取每个数据段，进行排序之后存储在一个新的文件中
     * @param segmentSize 分段的打下
     * @param originalFile 存储大容量数据的文件
     * @param f1 一个新的文件名
     * @return 返回大容量数据分段的个数
     * @throws IOException 文件写入和读出抛出的异常
     */
    public int initializeSegment(int segmentSize,String originalFile,String f1) throws IOException {
        int [] list = new int [segmentSize];//用于存储一个分段的数据
        DataInputStream input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(originalFile)//在此处可能会抛出FileNotFountException异常
                ));
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(f1)
                )
        );

        int numberOfSegments = 0;
        while (input.available() > 0){//IOException异常
            numberOfSegments++;
            int i = 0;
            for ( ;input.available() > 0 && i < segmentSize; i++){
                list [i] = input.readInt();
            }
            Arrays.sort(list, 0 ,i);
            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);
            }
        }
        input.close();
        output.close();
        return numberOfSegments;

    }

    /**
     * 将文件f1的一半复制到f2的文件中
     * @param numberOfSegments 分段数目
     * @param segmentSize 每个数据段大小
     * @param f1 文件f1
     * @param f2 文件f2
     * @throws IOException readInt()抛出
     */

    public void copyHalfToF2(int numberOfSegments, int segmentSize,DataInputStream f1,
                             DataOutputStream f2) throws IOException {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());//此处抛出IOException异常
        }
    }

    public void mergeSegment(int numberOfSegments, int segmentSize, DataInputStream f1,
                             DataInputStream f2, DataOutputStream f3) throws IOException {
        for (int i = 0; i < numberOfSegments; i++) {
            mergeTwoSegment(segmentSize, f1, f2, f3);
        }
        //由于f1文件分段个数可能比f2多一个
        while (f1.available() > 0){
            f3.writeInt(f1.readInt());
        }
    }

    public void mergeTwoSegment(int segmentSize, DataInputStream f1,
                                DataInputStream f2, DataOutputStream f3) throws IOException {
        int intFormF1 = f1.readInt();
        int intFormF2 = f2.readInt();
        int f1Count = 1;
        int f2Count = 1;

        while (true){
            if (intFormF1 < intFormF2){
                f3.writeInt(intFormF1);
                if (f1.available() == 0 || f1Count++ >= segmentSize){
                    f3.writeInt(intFormF2);
                    break;
                }else{
                    intFormF1 = f1.readInt();
                }
            }else{
                f3.writeInt(intFormF2);
                if(f2.available() == 0 || f2Count++ >= segmentSize){
                    f3.writeInt(intFormF1);
                    break;
                }else{
                    intFormF2 = f2.readInt();
                }
            }
        }
        while (f1.available() > 0 && f1Count++ < segmentSize){
            f3.writeInt(f1.readInt());
        }
        while (f2.available() > 0 && f2Count++ < segmentSize){
            f3.writeInt(f2.readInt());
        }
    }

    public void sort(String sourceFile, String targetFile) throws IOException {
        int numberOfSegments = initializeSegment(MAX_ARRAY_SIZE,sourceFile,"f1.bat");
        merge(numberOfSegments,MAX_ARRAY_SIZE,"f1.bat", "f2.bat", "f3.bat",targetFile);
    }

    private void merge(int numberOfSegments, int segmentSize,
                       String f1, String f2, String f3, String targetFile) throws IOException {
        if (numberOfSegments > 1){
            mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
            merge((numberOfSegments + 1)/2, segmentSize *2, f3, f1, f2, targetFile);
        }else {
            File sortedFile = new File(targetFile);
            if (sortedFile.exists()){
                sortedFile.delete();
            }
            new File(f1).renameTo(sortedFile);
        }
    }

    private void mergeOneStep(int numberOfSegments, int segmentSize,
                              String f1, String f2, String f3) throws IOException {
        DataInputStream f1Input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(f1),BUFFER_SIZE
                )
        );
        DataOutputStream f2Output = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(f2),BUFFER_SIZE
                )
        );

        copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
        f2Output.close();

        DataInputStream f2Input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(f2), BUFFER_SIZE
                )
        );
        DataOutputStream f3Output = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(f3),BUFFER_SIZE
                )
        );
        mergeSegment(numberOfSegments / 2, segmentSize, f1Input, f2Input,f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();

    }

    public void displayFile(String filename){
        try{
            DataInputStream input = new DataInputStream(
                    new FileInputStream(filename)
            );
            for (int i = 0; i < 100; i++) {
                System.out.print(input.readInt() + " " ) ;
            }
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
