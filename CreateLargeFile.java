import java.io.*;

/**
 * 该类为了创建一个大容量的数据文件
 */
public class CreateLargeFile {
    public static void main(String[] args) throws Exception{
        DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("largedata.bat")));

        for (int i = 0; i < 2000000; i++) {
            //注意，先乘以1000000在进行强制类型转换，否则所有的数字都是0
            output.writeInt((int)(Math.random()*1000000));
        }
        output.close();
        DataInputStream input = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("largedata.bat")
                ));
        for (int i = 0; i < 100; i++) {
            System.out.print(input.readInt() + " ");
        }
        input.close();
    }
}
