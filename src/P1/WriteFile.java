import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile{
    public static void WriteFileInTxt(int[][] array) {
        String fileName = "/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/6.txt"; // 定义要写入的文件名
        try {
            // 创建 FileWriter 对象，并指定要写入的文件名
            FileWriter fileWriter = new FileWriter(fileName);

            // 创建 BufferedWriter 对象，并包装 FileWriter，提高写入效率
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // 将数组逐行写入文件
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    bufferedWriter.write(Integer.toString(array[i][j]));
                    bufferedWriter.write("\t"); // 写入制表符作为列之间的分隔符
                }
                bufferedWriter.newLine(); // 写入换行符，表示下一行数据
            }

            // 关闭 BufferedWriter（关闭时会自动关闭 FileWriter）
            bufferedWriter.close();

            System.out.println("数组成功写入到文件 " + fileName);
        } catch (IOException e) {
            System.out.println("写入文件时发生错误：" + e.getMessage());
        }
    }
}
