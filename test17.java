import java.util.ArrayList;
import java.util.List;
public class test17 {
    private static final List<Integer> buffer = new ArrayList<>();
    private static final int size = 3;

    public static void main(String[] args){
        Producer producer=new Producer();
        Thread pro= new Thread(producer);
        pro.start();
        Consumer consumer = new Consumer();
        Thread con = new Thread(consumer);
        con.start();
    }

    static class Producer implements Runnable{
        int data=0;
        public void run(){
            while(true){
                synchronized (buffer){
                    while(buffer.size()==size){
                        System.out.println("缓冲区已满，生产者等待……");
                        try{
                            buffer.wait();
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    data++;
                    buffer.add(data);
                    System.out.println("生产者生产了数据："+data+"当前缓冲区："+buffer);
                    buffer.notify();
                }
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
    static class Consumer implements Runnable{
        public void run(){
            while(true){
                synchronized (buffer){
                    while(buffer.isEmpty()){
                        System.out.println("缓冲区为空，消费者请等待……");
                        try{
                            buffer.wait();
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    int data = buffer.remove(0);
                    System.out.println("消费者消费了数据："+data+",当前缓冲区："+buffer);
                    buffer.notify();
                }
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}
