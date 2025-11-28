import java.io.*;
public class test20 {
    public  static void main(String[] args){
        try(FileReader reader = new FileReader("D:\\ideacode\\idea\\src\\单词.txt");
            BufferedReader Re = new BufferedReader(reader)){
            int count=0;
            String line;
            while((line=Re.readLine())!=null){
                if(line.trim().isEmpty()) continue;
                String[] words=line.trim().split("[^a-zA-Z]+");
                for(String word: words){
                    if(!word.isEmpty()){
                        count++;
                    }
                }
            }
            System.out.println(("文件中的单词数为："+count));
        }catch(FileNotFoundException e) {
            System.out.println("文件未找到 "+e.getMessage());
        }catch(IOException e){
            System.err.println("文件读取失败："+e.getMessage());
        }
    }

}
