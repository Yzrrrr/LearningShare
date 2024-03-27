import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//
public class ReadFile {
    public static boolean isLegalMagicSquare(String filePath) {
        int rows = getRowCount(filePath);
        int cols = getColumnCount(filePath);
        System.out.println("这个矩阵行数："+rows+"这个矩阵列数:"+cols);
        if(rows!=cols)
        {
            System.out.println("行列数不同，无法成为MagicSquare");
            return false;
        }
        else if(rows%2==0)
        {
            System.out.println("行列数为偶数，无法成为MagicSquare");
            return false;
        }
        int[][] array = new int[rows][cols];
        if (DetectData(filePath, array, cols)) {
            int flag;
            flag = DetectWeatherOrNot(array,cols,rows);
            if (flag==0)
            {
                System.out.println("是MagicSquare");
            }else
            {
                System.out.println("不是MagicSquare");
            }
        }
        return true;
    }
//检测是否为MagicSquare
    public static int DetectWeatherOrNot (int[][] array,int cols,int rows)
    {
        int AddNumber = 0;
        for (int i=0;i<rows;i++)
        {
            int ADD = 0;
            for(int j=0;j<cols;j++)
            {
                ADD = ADD +array[i][j];
            }
            if(i==0)
            {
                AddNumber=ADD;
                System.out.println("和:"+ADD);
            }else {
                if (ADD!=AddNumber)
                {
                    System.out.println("第"+(i+1)+"行和数不同，无法成为MagicSquare:"+ADD);
                    return 1;
                }
            }
        }
        for (int i=0;i<rows;i++)
        {
            int ADD = 0;
            for(int j=0;j<cols;j++)
            {
                ADD = ADD +array[j][i];
            }
            if (ADD!=AddNumber)
                {
                    System.out.println("第"+(i+1)+"列和数不同，无法成为MagicSquare:"+ADD);
                    return 1;
                }
        }
        int ADD1 =0;
        for (int i=0;i<rows;i++)
        {
            ADD1 = ADD1 +array[i][i];
        }
        if (ADD1!=AddNumber)
        {
            System.out.println("正对角线和数不同，无法成为MagicSquare:"+ADD1);
            return 1;
        }
        int ADD2 =0;
        for (int i=0;i<rows;i++)
        {
            ADD2 = ADD2 +array[rows-1][i];
        }
        if (ADD2!=AddNumber)
        {
            System.out.println("反对角线和数不同，无法成为MagicSquare:"+ADD2);
            return 1;
        }
        return 0;
    }

//检测输入数据是否正确
    public static boolean DetectData(String filePath,int[][] array,int cols)
{
    try {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int row = 0;
        int n=0;
        int CountNumber =0;
        int Flag=0;
        while ((line = bufferedReader.readLine()) != null) {
            n++;
            String[] tokens = line.split("\t");
            if (tokens.length != cols)
            {
                System.out.println("文件格式错误：第"+n+"行列数不对，总共有"+tokens.length+"列,应该是有"+cols+"列,不是矩阵");
                return false;
            }
            for (int col = 0; col < tokens.length; col++) {
                int value=0;
                try
                {
                    value = Integer.parseInt(tokens[col]);
                    if(value <=0)
                    {
                        System.out.println("文件格式错误：行 " + (row + 1) + " 列 " + (col + 1) + " 的数字不是正整数。\n是一个负数:"+tokens[col]);
                        Flag++;
                    }
                }catch (NumberFormatException e)
                {
                    System.out.println("文件格式错误：行 " + (row + 1) + " 列 " + (col + 1) + " 的数字不是整数。");
                    if (tokens[col].matches("-?\\d*\\.\\d+")) {
                        System.out.println("是一个小数：" + tokens[col]);
                    }else{
                        System.out.println("数据是："+tokens[col]);
                    }
                    Flag++;
                }
                array[row][col] = value;
            }
            char[] chars = line.toCharArray();
            // 计数器，用于统计 \t 的个数
            int tabCount = 0;
            // 遍历字符数组
            for (char c : chars) {
                // 判断当前字符是否是制表符 \t
                if (c == '\t') {
                    tabCount++; // 如果是，将 \t 的个数加一
                }
            }
            if(n==1)
            {
                CountNumber = tabCount;
            }
            else {
                if (tabCount != CountNumber) {
                    System.out.println("第" + n + "行字符串中 \\t 的个数为：" + tabCount + " 应该为" + CountNumber + "个 存在不是\\t的分隔符号");
                    return false;
                }
            }
            row++;
        }
        if(Flag!=0)
        {
            return false;
        }
        bufferedReader.close();
    } catch (IOException e) {
        System.out.println("读取文件时发生错误：" + e.getMessage());
    }
    return true;
}
    //获取矩阵的行数
    public static int getRowCount(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("读取文件时发生错误：" + e.getMessage());
        }
        return count;
    }

    //获得矩阵的列数
    public static int getColumnCount(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            String[] tokens = firstLine.split("\t");
            return tokens.length;
        } catch (IOException e) {
            System.out.println("读取文件时发生错误：" + e.getMessage());
        }
        return 0;
    }

    public static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println(); // 换行
        }
    }
}
