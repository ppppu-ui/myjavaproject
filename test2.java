import java.util.Scanner;
public class test2{
    public static int add(int x,int y){
        return x+y;
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个数");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum=add(a,b);
        System.out.println(sum);
    }
}
