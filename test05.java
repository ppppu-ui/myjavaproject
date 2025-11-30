import java.util.Scanner;
public class test05 {
    public static void main(String [] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("请输入年份");
        int year = scanner.nextInt();
        if( (year % 4 ==0 && year % 100 != 0 )||(year % 400 == 0) )
            System.out.println("是闰年");
        else  System.out.println("不是闰年");
    }
}
