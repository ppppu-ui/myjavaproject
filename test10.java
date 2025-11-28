import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Scanner;
public class test10 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Class<?> c=null;
        try{
            c=Class.forName("BankAccount");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
//            Method met = c.getMethod("deposit",double.class);
//            met.invoke(c.newInstance());
            Method met = c.getMethod("deposit",double.class);
            Constructor<?> constructor = c.getConstructor();
            Object bankAccountOBj = constructor.newInstance();
            System.out.println("请输入存款金额：");
            double n = scanner.nextDouble();
            met.invoke(bankAccountOBj,n);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
