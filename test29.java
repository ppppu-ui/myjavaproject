interface Shape{
    double caculateArea();
    double caculatePerimeter();
    String getShapeName();
    void displayInfo();
}
class Circle implements Shape{
    private double r;
    public Circle(double r){
        this.r = r;
    }
    public double caculateArea(){
        return Math.round(3.14*r*r * 100) / 100.0;
    }
    public double caculatePerimeter(){
        return Math.round(2*3.14*r * 100) / 100.0;
    }
    public String getShapeName(){
        return "圆形";
    }
    public void displayInfo(){
        System.out.println("这是一个圆，半径为："+r+" 面积为："+caculateArea()+" 周长为"+caculatePerimeter());
    }
}
class Rectangle implements Shape{
    private double a;
    private double b;
    public Rectangle(double a,double b){
        this.a = a;
        this.b = b;
    }
    public double caculateArea(){
        return Math.round(a*b * 100) / 100.0;
    }
    public double caculatePerimeter(){
        return Math.round(2*(a+b) * 100) / 100.0;
    }
    public String getShapeName(){
        return "矩形";
    }
    public void displayInfo(){
        System.out.println("这是一个矩形，长为："+a+" 宽为："+b+" 面积为："+caculateArea()+" 周长为"+caculatePerimeter());
    }
}
class Triangle implements Shape{
    private double a,b,c;
    public Triangle(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        if (!(a + b > c && a + c > b && b + c > a)) {
            throw new IllegalArgumentException("输入的三边不能构成三角形");
        }
    }
    public double caculateArea(){
        double s = (a+b+c)/2;
        double n = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return Math.round(n * 100) / 100.0;
    }
    public double caculatePerimeter(){
        return a+b+c;
    }
    public String getShapeName(){
        return "三角形";
    }
    public void displayInfo(){
        System.out.println("这是一个三角形，三边分别为：" + a + "、" + b + "、" + c + ",面积" + caculateArea() + "，周长为：" + caculatePerimeter());
    }
}
public class test29 {
    public static void main(String [] args){
        Circle c= new Circle(3);
        c.displayInfo();
        Rectangle r = new Rectangle(2,3);
        r.displayInfo();
        Triangle t = new Triangle(2,3,2);
        t.displayInfo();
    }
}
