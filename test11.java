import java.io.*;
import java.util.Scanner;
public class test11 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        try{
            FileWriter writer = new FileWriter("example.txt");
            System.out.println("请输入内容：");
            String str = scanner.nextLine();
            writer.write(str);
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        try{
            FileReader reader = new FileReader("example.txt");
            int ch;
            System.out.println("输出为：");
            while( (ch = reader.read()) != -1){
                System.out.print((char)ch);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
