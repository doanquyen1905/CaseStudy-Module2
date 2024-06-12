package CaseStudyModule2.View;

import CaseStudyModule2.Model.Book;
import CaseStudyModule2.Model.Order;

import java.util.Map;
import java.util.Scanner;

public class MenuView {
    public int viewEmployment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Menu Quản Lý Nhà Sách (Nhân Viên) ===");
        System.out.println("1. Thêm Sách");
        System.out.println("2. Xóa sách trong kho");
        System.out.println("3. Hiển Thị Thông Tin Kho hàng");
        System.out.println("4. Tìm thông tin sách");
        System.out.println("5. Order Book");
        System.out.println("6. Exit Program");

        int choice = -1;
        do {
            try {
                System.out.println("Input Your Choice");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("choice is a number");
            } catch (Exception e) {
                System.out.println("chưa tìm ra nguyên nhân");
            }

        } while (choice < 0 || choice > 5);
        return choice;
    }

    public Book viewAddBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input IdBook");
        String idBook = validateInput(scanner.nextLine());
        System.out.println("Input Name Book");
        String nameBook = validateInput(scanner.nextLine());
        System.out.println("Input author");
        String authorBook = validateInput(scanner.nextLine());
        System.out.println("Input price");
        Double priceBook = Double.parseDouble(String.valueOf(validateNumber(scanner.nextLine())));
        System.out.println("Input quantity");
        int quantity = validateNumber(scanner.nextLine());
        return new Book(idBook, nameBook, authorBook, priceBook, quantity);
    }

    public String inputIdBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input IdBook");
        return validateInput(scanner.nextLine());
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("successful task");
        } else {
            System.out.println("task failed");
        }
    }

    public boolean confirm() {
        System.out.println("do you want to continue");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if (confirm.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void displayAllBooks(Map<String, Book> books) {
        if (books.isEmpty()) {
            System.out.println("Kho hàng trống.");
        } else {
            System.out.println("Thông tin kho hàng:");
            for (Book book : books.values()) {
                System.out.println("ID: " + book.getIdImportBook());
                System.out.println("Tên sách: " + book.getNameImportBook());
                System.out.println("Tác giả: " + book.getAuthorImportBook());
                System.out.println("Giá: " + book.getPriceImportBook());
                System.out.println("Số lượng: " + book.getQuantity());
                System.out.println("-----------------------");
            }
        }
    }

    public void displayBookById(Book book) {
        if (book != null) {
            System.out.println("Thông tin sách:");
            System.out.println("ID: " + book.getIdImportBook());
            System.out.println("Tên sách: " + book.getNameImportBook());
            System.out.println("Tác giả: " + book.getAuthorImportBook());
            System.out.println("Giá: " + book.getPriceImportBook());
            System.out.println("Số lượng: " + book.getQuantity());
        } else {
            System.out.println("Không tìm thấy sách với ID được cung cấp.");
        }
    }

    public Order viewOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----View Order-----");
        System.out.println("Input IDBook");
        String inputIdBook = validateInput(scanner.nextLine());
        System.out.println("Input Quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        return new Order(inputIdBook, quantity);
    }

    private static String validateInput(String input) {
        Scanner scanner = new Scanner(System.in);
        while (!input.matches("^[a-zA-Z]{1,30}$")) {
            System.out.println("Input không hợp lệ");
            System.out.println("Input Again: ");
            input = scanner.nextLine();
        }
        return input;
    }
    private static int validateNumber(String inputNumber) {
        Scanner scanner = new Scanner(System.in);
        while (!inputNumber.matches("\\d")|| Integer.parseInt(inputNumber) <= 0) {
            System.out.println("Input không hợp lệ");
            System.out.println("Input Again: ");
            inputNumber = scanner.nextLine();
        }
        return Integer.parseInt(inputNumber);
    }
}

