import java.util.Scanner;
import java.util.ArrayList;
class product{
    private int id;
    private String name;
    private double price;

    public product(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public int getId(){
        return id;
    };
    public void setId(int  id){
        this.id=id;
    };
    public String getName(){
        return name;
    };
    public void setName(String name){
        this.name=name;
    };
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    };
    public void display(){
        System.out.println("商品id："+id+"商品品名："+name+"商品价格："+price);
    }
    @Override
    public String toString(){
        return String.format("商品id："+id+"商品品名："+name+"商品价格："+price);
    }
}
public class test8 {
    Scanner scanner = new Scanner(System.in);
    ArrayList<product> productList = new ArrayList<>();
    public void addProduct(){
            System.out.println("请输入商品id：");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("请输入商品名称：");
            String name = scanner.nextLine();
            System.out.println("请输入商品价格：");
            double price = scanner.nextDouble();
            product product= new product(id,name,price);
            productList.add(product);
            System.out.println("商品添加成功！");
    }
    public void findProductById(){
        System.out.println("请要查询的商品id：");
        int id = scanner.nextInt();
        for(product item:productList){
            if(item.getId() == id){
                System.out.println("找到商品：");
                item.display();
                return;
            }
        }
        System.out.println("未找到商品");
    }
    public void findProductByName(){
        System.out.println("请要查询的商品名称：");
        scanner.nextLine();
        String name = scanner.nextLine();
        for(product item:productList){
            if(item.getName().equals(name)){
                System.out.println("找到商品：");
                item.display();
                return;
            }
        }
        System.out.println("未找到商品");
    }
    public static void main(String[] args){
        test8 ProductManage = new test8();
        ProductManage.addProduct();
        ProductManage.addProduct();
        ProductManage.addProduct();
        ProductManage.findProductById();
        ProductManage.findProductByName();
    }
}
