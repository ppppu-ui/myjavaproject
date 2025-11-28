import java.util.*;

class Person01{
    private String name;
    private int age;
    public Person01(String name,int age){
        this.name=name;
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        return "Person{name="+name+",age"+age+"}";
    }
}
public class test28 {
    public static void main(String[] args){
        List<Person01>  people = new ArrayList<>();
        people.add(new Person01("小明",12));
        people.add(new Person01("小米",14));
        people.add(new Person01("小红",13));
        Collections.sort(people, new Comparator<Person01>(){
            public int compare(Person01 p1,Person01 p2){
                return p1.getAge() - p2.getAge();
            }
        });
        System.out.println("按年龄进行排序后：");
        for(Person01 s:people){
            System.out.println(s);
        }
    }
}
