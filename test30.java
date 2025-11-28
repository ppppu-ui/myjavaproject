import java.util.*;
abstract class Employee{
    private int id;
    private String name;
    private double baseSalary;
    public Employee(int id,String name,double baseSalary){
        this.id = id;
        this.baseSalary = baseSalary;
        this.name =name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public abstract double calculateSalary();
    public String getEmployeeInfo(){
        return "ID:" + id +" ,姓名 :" + name +", 基础工资: " + baseSalary;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.baseSalary, baseSalary) == 0 &&
                Objects.equals(name, employee.name);
    }
    public int hashCode() {
        return Objects.hash(id, name, baseSalary);
    }
}

class FullTimeEmployee extends Employee{
    private double performanceBonus;
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double performanceBonus) {
        super(employeeId, name, baseSalary);
        this.performanceBonus = performanceBonus;
    }
    public double calculateSalary(){
        return getBaseSalary()+performanceBonus;
    }
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + ", 绩效奖金: " + performanceBonus + ", 总工资: " + calculateSalary();
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int workingHours;
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workingHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.workingHours = workingHours;
    }
    public double calculateSalary() {
        return hourlyRate * workingHours;
    }
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + ", 时薪: " + hourlyRate + ", 工作小时: " + workingHours + ", 总工资: " + calculateSalary();
    }
}

class SalesEmployee extends Employee {
    private double salesAmount;
    public SalesEmployee(int employeeId, String name, double baseSalary, double salesAmount) {
        super(employeeId, name, baseSalary);
        this.salesAmount = salesAmount;
    }
    public double calculateSalary() {
        return getBaseSalary() + salesAmount * 0.05;
    }
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + ", 销售提成: " + salesAmount + ", 总工资: " + calculateSalary();
    }
}

class Company{
    private List<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
     public void removeEmployee(Employee employee){
        employees.remove(employee);
     }

     public double calculateTotalSalary(){
        double total =0 ;
        for (Employee employee : employees){
            total += employee.calculateSalary();
        }
        return total;
     }
     public void displayEmployee(){
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.calculateSalary(),o2.calculateSalary());
            }
        });
        for(Employee employee: employees){
            System.out.println(employee.getEmployeeInfo());
        }
     }
     public void findHighestAndLowestSalaryEmployees(){
         if (employees.isEmpty()) {
             return;
         }
         Employee highest = employees.get(0);
         Employee lowest = employees.get(0);
         for (Employee employee : employees){
             double salary = employee.calculateSalary();
             if (salary > highest.calculateSalary()) {
                 highest = employee;
             }
             if (salary < lowest.calculateSalary()) {
                 lowest = employee;
             }
         }
         System.out.println("工资最高的员工: " + highest.getEmployeeInfo());
         System.out.println("工资最低的员工： " + lowest.getEmployeeInfo());
     }
}
public class test30 {
    public static void main(String[] args) {
        Company company = new Company();
        FullTimeEmployee fullTime = new FullTimeEmployee(1, "小米", 5000, 1000);
        PartTimeEmployee partTime = new PartTimeEmployee(2, "小明", 20, 160);
        SalesEmployee sales1 = new SalesEmployee(3, "小美", 3000, 10000);
        SalesEmployee sales2 = new SalesEmployee(3, "小丽", 3000, 10000);
        company.addEmployee(fullTime);
        company.addEmployee(partTime);
        company.addEmployee(sales1);
        company.addEmployee(sales2);
        company.removeEmployee(sales2);
        company.displayEmployee();
        company.findHighestAndLowestSalaryEmployees();

    }
}
