package HN_JV240617_HoangThiHaiYen_CoBan.ra.run;

import HN_JV240617_HoangThiHaiYen_CoBan.ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static int bookIndex = 0;
    public static Book[] books = new Book[100];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            try {
                System.out.print("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU*************** \n" +
                        "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                        "2. Hiển thị thông tin tất cả sách trong thư viện \n" +
                        "3. Sắp xếp sách theo lợi nhuận tăng dần \n" +
                        "4. Xóa sách theo mã sách \n" +
                        "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n" +
                        "6. Thay đổi thông tin sách theo mã sách \n" +
                        "7. Thoát");
                System.out.print("Nhập lựa chọn (1 - 7): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Console.message("(1). Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n");
                        int quantity = inputPositiveInt(scanner, "Nhập số lượng sách thêm mới");
                        scanner.nextLine();
                        for (int i = 0; i < quantity; i++) {
                            Book book = new Book();
                            Console.message("Nhập số lượng sách thứ " + bookIndex + "\n");
                            book.inputData(scanner);
                            books[bookIndex] = book;
                            Console.message("Nhập xong sách thứ "+ bookIndex + "\n");
                            bookIndex++;
                        }
                        break;
                    case 2:
                        Console.message("(2). Hiển thị thông tin tất cả sách trong thư viện \n");
                        System.out.printf("| %-10s | %-20s | %-20s | %-25s | %-10s | %-10s |%-10s |%-10s |\n",
                                "bookId", "bookName", "author", "descriptions","importPrice","exportPrice" ,"interest", "bookStatus" );
                        for(int i = 0; i < bookIndex; i++) {
                            books[i].displayData();
                        }
                        break;
                    case 3:
                        Console.message("(3). Sắp xếp sách theo lợi nhuận tăng dần \n");
                        Book[] sortedbooks2=new Book[bookIndex+1];
                        for(int i = 0; i < bookIndex; i++) {
                            sortedbooks2[i]=books[i];
                        }
                        for(int i = 0; i < bookIndex; i++) {
                            int minIndex=i;
                            for(int j = i+1; j < bookIndex; j++) {
                                if((sortedbooks2[j].getInterest()- sortedbooks2[minIndex].getInterest())<0) {
                                    minIndex=j;
                                }
                            }
                            Book temp=sortedbooks2[minIndex];
                            sortedbooks2[minIndex]=sortedbooks2[i];
                            sortedbooks2[i]=temp;
                        }
                        System.out.printf("| %-10s | %-20s | %-20s | %-25s | %-10s | %-10s |%-10s |%-10s |\n",
                                "bookId", "bookName", "author", "descriptions","importPrice","exportPrice" ,"interest", "bookStatus" );
                        for(Book book : sortedbooks2) {
                            if(book!=null){
                                book.displayData();
                            }
                        }
                        break;
                    case 4:
                        Console.message("(4). Xóa sách theo mã sách");
                        int idDelete = inputPositiveInt(scanner, "Nhập ID sách cần xóa: ");

                        int indexDelete=-1;
                        for(int i = 0; i < bookIndex; i++) {
                            if(books[i].getBookId()==idDelete){
                                indexDelete=i;
                                break;
                            }
                        }
                        if(indexDelete==-1){
                            Console.message("Không tìm thấy ID sách");
                        }else {
                            for(int i=indexDelete;i<bookIndex;i++) {
                                books[i]=books[i+1];
                            }
                            books[bookIndex]=null;
                            bookIndex--;
                            Console.message("Đã xóa xong \n");
                        }
                        break;
                    case 5:
                        Console.message("(5). Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
                        System.out.print("Nhập tên sách hoặc mô tả");
                        scanner.nextLine();
                        String textSearchBook = scanner.nextLine().trim().toLowerCase();
                        System.out.printf("| %-10s | %-20s | %-20s | %-25s | %-10s | %-10s |%-10s |%-10s |\n",
                                "bookId", "bookName", "author", "descriptions","importPrice","exportPrice" ,"interest", "bookStatus" );
                        for(Book b : books) {
                            if(b!=null){
                                if(b.getBookName().toLowerCase().contains(textSearchBook)||
                                b.getDescriptions().toLowerCase().contains(textSearchBook)){
                                    b.displayData();
                                }
                            }
                        }
                        break;
                    case 6:
                        Console.message("(6). Thay đổi thông tin sách theo mã sách");
                        int idUpdate = inputPositiveInt(scanner,"Nhập Id của sách mà bạn muốn thay đổi");
                        int indexUpdate=-1;
                        for(int i = 0; i < bookIndex; i++) {
                            if(books[i].getBookId()==idUpdate){
                                indexUpdate=i;
                                break;
                            }
                        }
                        if(indexUpdate==-1){
                            Console.message("Không tim thấy sách có id="+idUpdate);
                        }else {
                            Book book=new Book();
                            scanner.nextLine();
                            Console.message("Nhập lại thông tin cho cuống sách\n");
                            book.inputData(scanner);
                            book.setBookId(idUpdate);
                            books[indexUpdate]=book;
                            Console.message(" Cập nhật xong");
                        }

                        break;
                    case 7:
                        Console.exit("Thoát");
                        scanner.close();
                        return;
                    default:
                        Console.message("Lựa chọn chỉ từ 1 đến 7 \n");

                }
            } catch (Exception e) {
                Console.error("Hãy nhập lựa chọn" + e.getMessage());
                System.out.println();
                scanner.nextLine();
            }
        }
    }

    public static int inputPositiveInt(Scanner scanner, String msg) {
        System.out.print(msg);
        int number;

        while (true) {
            try {
                number = scanner.nextInt();
                if (number > 0) {
                    return number;
                }
                Console.message(msg);
            } catch (Exception e) {
                scanner.nextLine();
                Console.message(msg);
            }
        }
    }
}
