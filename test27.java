import java.util.Scanner;
import java.util.TreeSet;
public class test27 {
    public static void main(String [] args){
        TreeSet <Integer> numbers = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组整数：(输入非数字字符结束)");
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            numbers.add(num);
        }
        System.out.println("排序后的数："+numbers);
    }
}
