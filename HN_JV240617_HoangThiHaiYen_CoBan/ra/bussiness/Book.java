package HN_JV240617_HoangThiHaiYen_CoBan.ra.bussiness;



import HN_JV240617_HoangThiHaiYen_CoBan.ra.run.Console;

import java.util.Scanner;

public class Book {
    public static int idCounter = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private Boolean bookStatus;


    public Book() {

    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner){
        bookId = idCounter++;
        bookName = inputBookName(scanner);
        author = inputAuthor(scanner);
        descriptions = inputDescriptions(scanner);
        importPrice = inputImportPrice(scanner);
        exportPrice = inputExportPrice(scanner);
        System.out.println("Lợi nhuận");
        interest = (float) exportPrice-(float) importPrice;
        System.out.println(interest);
        bookStatus = inputBookStatus(scanner);
    }


    public String inputBookName(Scanner scanner) {
        //bookName – tên sách – String (Không được để trống)
        System.out.print("Nhập tên sách");
        String bookName ;

        while (true){
            try{
                bookName = scanner.nextLine().trim();
                if(!bookName.isEmpty()){
                    return bookName;
                }
                System.out.println("Không để trống!!");
                Console.message("Nhập tên sách");
            }catch (Exception e){
                Console.error(e.getMessage());
                System.out.println("Không hợp lệ!!");
                scanner.nextLine();
            }
        }
    }

    public String inputAuthor(Scanner scanner) {
        //author – tác giả – String (Không được để trống)
        System.out.print("Nhập tên tác giả");
        String authorName ;
        while (true){
            try{
                authorName = scanner.nextLine().trim();
                if(!authorName.isEmpty()){
                    return authorName;
                }
                System.out.println("Không để trống!!");
                Console.message("Nhập tên tác giả");
            }catch (Exception e){
                Console.error(e.getMessage());
                System.out.println("Không hợp lệ!!");
                scanner.nextLine();
            }
        }

    }

    public String inputDescriptions(Scanner scanner) {
        //descriptions – mô tả về sách – String (Không được để trống, ít nhất 10 ký tự)
        System.out.print("Nhập mô tả về sách");
        String descriptions ;
        while (true){
            try{
                descriptions = scanner.nextLine().trim();
                if(!descriptions.isEmpty()){
                    if(descriptions.length()<10){
                        System.out.println("Không được để trống, ít nhất 10 ký tự");
                        Console.message("Nhập mô tả về sách");
                    }else {
                        return descriptions;
                    }
                }
                System.out.println("Không để trống!!");
                Console.message("Nhập mô tả về sách");
            }catch (Exception e){
                Console.error(e.getMessage());
                System.out.println("Không hợp lệ!!");
                scanner.nextLine();
            }
        }
    }

    public double inputImportPrice(Scanner scanner) {
        //importPrice – giá nhập – double (phải lớn hơn 0)
        System.out.print("Nhập giá nhập vào: ");
        double importPrice;

        while (true) {
            try {
                importPrice = scanner.nextDouble();
                if (importPrice > 0 ) {
                    return importPrice;
                }
                Console.message("Nhập giá nhập vào >0: ");
            }
            catch (Exception e) {
                Console.message("Nhập lại giá nhập vào: ");
                scanner.nextLine();
            }
        }
    }

    public double inputExportPrice(Scanner scanner) {
        //exportPrice – giá xuất – double (phải lớn hơn 1.2 lần giá nhập)
        System.out.print("Nhập giá xuất: ");
        double exportPrice;

        while (true) {
            try {
                exportPrice = scanner.nextDouble();
                if (exportPrice > this.importPrice*120/100 ) {
                    return exportPrice;
                }else {
                    System.out.println("giá xuất phải lớn hơn 1.2 lần giá nhập");
                    Console.message("Nhập giá xuất: ");
                }
            }
            catch (Exception e) {
                Console.message("Nhập giá xuất: ");
                scanner.nextLine();
            }
        }
    }



    public Boolean inputBookStatus(Scanner scanner) {
        //bookStatus – trạng thái – Boolean (mặc định là true)
        System.out.print("Trạng thái mặc định là true ");
        return true;
    }

    public  void  displayData() {
        System.out.printf("| %-10d | %-20s | %-20s | %-25s | %-10f | %-10f |%-10f |%-10s |\n",
                bookId, bookName, author, descriptions,importPrice,exportPrice ,interest, bookStatus ? "Vẫn còn" : "Đã hết" );
    }




}
