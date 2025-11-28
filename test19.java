import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getname(){
        return this.name;
    }
    public void setname(String name){
        this.name=name;
    }
    public int getage(){
        return this.age;
    }
    public void setname(){
        this.age=age;
    }
    public String tostring(){
        return "姓名："+this.name+",年龄："+"this.age";
    }
}
public class test19 {
     public static void main(String args[]){
         Class<?> c = null;
         try{
             c = Class.forName("Person");
         }catch(ClassNotFoundException e){
             e.printStackTrace();
         }
         Method m[] = c.getMethods();
         for(int i=0;i< m.length;i++){
             Class<?> r = m[i].getReturnType();
             Class<?> p[]= m[i].getParameterTypes();
             int xx = m[i].getModifiers();
             System.out.print(Modifier.toString(xx)+" ");
             System.out.print(r.getName()+" ");
             System.out.print(m[i].getName()+" ");
             System.out.print("(");
             for(int t=0;t<p.length;t++){
                 System.out.print(p[t].getName()+" "+"arg"+t);
                 if(t<p.length-1){
                     System.out.print(",");
                 }
             }
             Class<?> ex[]= m[i].getExceptionTypes();
             if(ex.length>0){
                 System.out.print(") throws ");
             }else{
                 System.out.print(")");
             }
             for(int j=0;j<ex.length;j++){
                 System.out.print(ex[j].getName());
                 if(j<ex.length-1){
                     System.out.print(",");
                 }
             }
             System.out.println();
         }
         Field f[]= c.getDeclaredFields();
         for(int i=0;i<f.length;i++){
             Class<?> r=f[i].getType();
             int mo = f[i].getModifiers();
             String priv = Modifier.toString(mo);
             System.out.println("本类属性："+priv+r.getName()+" "+f[i].getName()+";");
         }
     }
}
