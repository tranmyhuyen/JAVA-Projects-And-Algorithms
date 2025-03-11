package BOOKSMANAGEMENT;

public class Main {
    public static void main(String[] args) {
        BOOKS library = new BOOKS();

        // Thêm sách vào hệ thống
        library.addBook();
        library.addBook();

        // Hiển thị danh sách sách
        library.displayAllBook();
    }
}
