import java.util.Scanner;
public class test03 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入圆的半径");
        double r = scanner.nextInt();
        double s = 3.14 * r * r ;
        System.out.println("圆的面积为:"+s);
    }
}

