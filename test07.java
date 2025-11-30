import java.util.Scanner;
class BankAccount{
    private String accountNumber;
    private String accountHolder;
    private double balance;
    public BankAccount(){

    }
    public BankAccount(String accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("存款成功！存入金额："+amount+"元");
            return true;
        }else{
            System.out.println("存入失败！存款金额必须大于0");
            return false;
        }
    }

    public boolean withdraw(double amount){
        if(amount <= 0){
            System.out.println("取款失败！取款金额必须大于0");
            return false;
        }else if(amount > balance){
            System.out.println("取款失败！余额不足！当前余额："+balance+"元");
            return false;
        }
        balance -= amount;
        System.out.println("取款成功！取出金额："+amount+"元，当前余额："+balance+"元");
        return true;
    }

    public void checkBalance(){
        System.out.println("当前余额："+balance+"元");
    }
}

public class test7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入银行账户号码：");
        String number = scanner.nextLine();
        System.out.println("请输入账户名：");
        String holder = scanner.nextLine();
        System.out.println("请输入初始余额：");
        double balance = scanner.nextDouble();
        BankAccount account = new BankAccount(number,holder,balance);
        System.out.println("创建账户成功！");
        System.out.println("请输入存款金额:");
        double amount1 = scanner.nextDouble();
        account.deposit(amount1);
        System.out.println("请输入取款金额:");
        double amount2 = scanner.nextDouble();
<<<<<<< HEAD
        account.withdraw(amount2);
        System.out.println("查询余额：");
=======
        System.out.println("查询余额：");
        account.withdraw(amount2);
>>>>>>> cb367699a10742b048d6c24efa60674b85251d37
        account.checkBalance();
    }
}
