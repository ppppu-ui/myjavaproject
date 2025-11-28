import java.util.Scanner;
import java.util.Arrays;
public class test13{
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入元素个数：");
        int size = scanner.nextInt();
        int[] array=new int[size];
        System.out.println("请输入"+size+"个数：");
        for(int i=0;i<size;i++) {
            array[i]=scanner.nextInt();
        }
        System.out.println("原始数组：\n"+Arrays.toString(array));

        System.out.println();
        Reverse(array);
    }
    public static void Reverse(int[] array){
        System.out.println("逆序数组:");
        System.out.print("[");
        for(int i=array.length-1;i>=0;i--) {
            System.out.print(array[i]);
            if(i>0)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
