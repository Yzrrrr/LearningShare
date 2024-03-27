import java.util.Scanner;
public class MagicSquare {
    public static void main(String[] args) {
        ReadFile fileReader = new ReadFile();
        System.out.println("第一个矩阵:");
        fileReader.isLegalMagicSquare("/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/1.txt");
        System.out.println("第二个矩阵:");
        fileReader.isLegalMagicSquare("/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/2.txt");
        System.out.println("第三个矩阵:");
        fileReader.isLegalMagicSquare("/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/3.txt");
        System.out.println("第四个矩阵:");
        fileReader.isLegalMagicSquare("/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/4.txt");
        System.out.println("第五个矩阵:");
        fileReader.isLegalMagicSquare("/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/5.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入生成矩阵的行列数：");
        int num = scanner.nextInt(); // 读取整数
        if(num%2!=0) {
            generateMagicSquare generate = new generateMagicSquare();
            generate.generateMagicSquare1(num);
        }else {
            System.out.print("请输入奇数");
        }
        System.out.println("第六个矩阵:");
        fileReader.isLegalMagicSquare("/Users/yizeren/HIT-Lab1-2022112535/src/P1/txt/6.txt");
    }



}