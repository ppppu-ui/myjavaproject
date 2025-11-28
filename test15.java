import java.util.ArrayList;
import java.util.Scanner;
public class test15 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("请输入一组数字：(用空格隔开，回车结束)");
        String in = scanner.nextLine();
        String[] numStr = in.split(" ");
        try{
        for (String str : numStr) {
            int num = Integer.parseInt(str);
            list.add(num);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        ArrayList<Integer> uniqueList;
        uniqueList = distinct(list);
        System.out.println("去重前：" + list);
        System.out.println("去重后：" + uniqueList);
    }
        public static ArrayList<Integer> distinct (ArrayList < Integer > list) {
            ArrayList<Integer> uniqueList = new ArrayList<>();
            for (int num : list) {
                if (!uniqueList.contains(num)) {
                    uniqueList.add(num);
                }
            }
            return uniqueList;
        }
}
