import java.util.Scanner;
class NegativeNumException extends Exception{
    public NegativeNumException(){
        super();
    };
    public NegativeNumException(String message){
        super(message);
    }
}
public class test9 {
    public static void main(String[] args){
        try {
            function();
        }catch(NegativeNumException e){
            System.out.println(e.getMessage());
        }
    }
    public static void function()throws NegativeNumException{
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入一个数");
        int num=scanner.nextInt();
        if(num < 0){
            throw new NegativeNumException("输入的数为负数");
        }
    }
}
