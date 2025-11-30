import java.io.*;
import java.util.*;
class BankAccount2 {
    private String id;
    private String name;
    private double balance;
    public BankAccount2(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public synchronized void deposit(double amount) {
        balance += amount;
    }
    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public String toFileString() {
        return id + "," + name + "," + balance;
    }
    public String toString() {
        return "账户ID："+id + ", 账户名：" + name + ", 余额：" + balance;
    }
    public static BankAccount2 fromFileString(String line) {
        String[] parts = line.split(",");
        return new BankAccount2(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
}
class BankSystem {
    private HashMap<String, BankAccount2> accounts = new HashMap<>();
    private final String fileName = "accounts.txt";
    public BankSystem() {
        loadFromFile();
    }
    public synchronized void createAccount(String id, String name, double balance) {
        if (!accounts.containsKey(id)) {
            accounts.put(id, new BankAccount2(id, name, balance));
            saveToFile();
        }else{
            System.out.println("创建失败，账户已存在！");
            BankAccount2 acc = accounts.get(id);
            System.out.println(acc);
        }
    }
    public synchronized boolean deposit(String id, double amount) {
        BankAccount2 acc = accounts.get(id);
        if (acc != null) {
            acc.deposit(amount);
            saveToFile();
            return true;
        }
        return false;
    }
    public synchronized boolean withdraw(String id, double amount) {
        BankAccount2 acc = accounts.get(id);
        if (acc != null && acc.withdraw(amount)) {
            saveToFile();
            return true;
        }
        return false;
    }
    public synchronized double getBalance(String id) {
        BankAccount2 acc = accounts.get(id);
        return acc == null ? -1 : acc.getBalance();
    }
    private void saveToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (BankAccount2 acc : accounts.values()) {
                out.println(acc.toFileString());
            }
        } catch (IOException e) {
            System.out.println("保存失败");
        }
    }
    private void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                BankAccount2 acc = BankAccount2.fromFileString(line);
                accounts.put(acc.getId(), acc);
            }
        } catch (IOException e) {
            System.out.println("读取失败");
        }
    }
}
public class test32 {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        bank.createAccount("1001", "Alice", 1000);

        new Thread(() -> {
            bank.deposit("1001", 200);
            System.out.println("线程1存款后余额: " + bank.getBalance("1001"));
        }).start();

        new Thread(() -> {
            bank.withdraw("1001", 300);
            System.out.println("线程2取款后余额: " + bank.getBalance("1001"));
        }).start();
    }
}
