class Thread01 extends java.lang.Thread{
    public void run(){
        int i=1;
        while(i<=10){
            System.out.println("Thread01的run方法在运行: "+i);
            i++;
        }
    }
}
class Thread02 extends java.lang.Thread{
    public void run(){
        char i='A';
        while(i<='J'){
        System.out.println("Thread02的run方法在运行: "+i);
        i++;
        }
    }
}
public class test12 {
    public static void main(String args[]){
        Thread01 thread01= new Thread01();
        Thread02 thread02= new Thread02();
        thread01.start();
        thread02.start();
    }
}
