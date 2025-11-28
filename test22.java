import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class test22 {
    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一串字符：");
        String str=scanner.nextLine();
        Map<Character,Integer> ch = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(ch.containsKey(c)){
                int count = ch.get(c);
                ch.put(c,count+1);
            }else{
                ch.put(c,1);
            }
        }
        for(Map.Entry<Character,Integer> entry : ch.entrySet()){
            System.out.println(entry.getKey()+" 出现次数："+entry.getValue());
        }
    }
}
