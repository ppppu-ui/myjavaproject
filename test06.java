import java.util.Scanner;
public class test06 {
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("请输入第一个数字: ");
        double num1 = scanner.nextDouble();
        System.out.println("请输入运算符 (+, -, *, /): ");
        char op= scanner.next().charAt(0);
        System.out.println("请输入第二个数字: ");
        double num2= scanner.nextDouble();
        double result;
        switch (op) {
            case '+':
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                } else {
                    System.out.println("错误：除数不能为0");
                }
                break;
            default:
                System.out.println("错误：不支持的运算符");
        }
    }
}
