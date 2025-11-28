import java.util.*;
import java.io.*;
class Book{
    private String isbn;
    private String title;
    private String author;
    private int stock;
    public Book(String isbn, String title, String author, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }
    public String getIsbn()
    { return isbn; }
    public String getTitle()
    { return title; }
    public String getAuthor()
    { return author; }
    public int getStock()
    { return stock; }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String toString() {
        return "编号：" + isbn + " | 书名：" + title + " | 库存：" + stock;
    }
}
class LibrarySystem{
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("暂无图书信息！");
            return;
        }
        System.out.println("\n=== 所有图书 ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public boolean borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.getStock() > 0) {
                    book.setStock(book.getStock() - 1);
                    return true;
                } else {
                    System.out.println("库存不足，无法借书。");
                    return false;
                }
            }
        }
        System.out.println("未找到该ISBN的图书。");
        return false;
    }
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setStock(book.getStock() + 1);
                return true;
            }
        }
        System.out.println("未找到该ISBN的图书。");
        return false;
    }
    public void saveBooks() {
        try (Writer writer = new FileWriter("books.txt")) {
            for (Book book : books) {
                writer.write(book.getIsbn() + "," + book.getTitle() + ","+book.getAuthor()+"," + book.getStock() + "\n");
            }
            System.out.println("图书信息已保存到文件！");
        } catch (IOException e) {
            System.out.println("保存失败：" + e.getMessage());
        }
    }
    public void loadBooks() {
        File file = new File("books.txt");
        if (!file.exists()) {
            System.out.println("首次使用，文件不存在，已创建空列表");
            return;
        }
        try (Reader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    books.add(new Book(parts[0], parts[1], parts[2],Integer.parseInt(parts[3])));
                }
            }
            System.out.println("已加载 " + books.size() + " 本图书");
        } catch (IOException e) {
            System.out.println("加载失败：" + e.getMessage());
        }
    }
}

public class test31{
    public static void main(String[] args){
        LibrarySystem library = new LibrarySystem();
            library.loadBooks();
        Scanner scanner = new Scanner(System.in);
            while (true) {
            System.out.println("\n===== 简易图书管理 =====");
            System.out.println("1. 添加图书");
            System.out.println("2. 查看所有图书");
            System.out.println("3. 借书");
            System.out.println("4. 还书");
            System.out.println("5. 保存并退出");
            System.out.print("请选择功能（1-5）：");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("输入图书编号：");
                    String isbn = scanner.nextLine();
                    System.out.print("输入书名：");
                    String tittle = scanner.nextLine();
                    System.out.print("输入作者：");
                    String author = scanner.nextLine();
                    System.out.print("输入库存数量：");
                    int stock = scanner.nextInt();
                    library.addBook(new Book(isbn, tittle,author, stock));
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    System.out.print("请输入要借阅的书籍ISBN：");
                    String isbn1 = scanner.nextLine();
                    library.borrowBook(isbn1);
                    break;
                case 4:
                    System.out.print("请输入要归还的书籍ISBN：");
                    String isbn2 = scanner.nextLine();
                    library.returnBook(isbn2);
                    break;
                case 5:
                    library.saveBooks();
                    System.out.println("程序已退出！");
                    return;
                default:
                    System.out.println("输入错误，请重试！");
            }
        }
    }
}