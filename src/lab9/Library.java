package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  public static void main(String[] args) {
    Library library = new Library();
    library.addBook(new Book("Java"));
    library.addBook(new Book("C++"));
    library.addBook(new Book("Python"));
    library.addBook(new Book("Javascript"));
    library.addBook(new Book("C#"));
    Scanner in = new Scanner(System.in);
    while(true){
      System.out.println("Please select operation: " +
          "1. Borrow. 2. Return. 3. Overdue. 0. To Stop the process");
      int op = in.nextInt();
      if (op == 0)
        break;
      int id;
      switch (op) {
        case 1:
          library.displayAvailableBooks();
          System.out.println("Please input the book id:");
          id = in.nextInt();
          library.borrowBook(id);
          break;
        case 2:
          library.displayBorrowedBooks();
          System.out.println("Please input the book id:");
          id = in.nextInt();
          library.returnBook(id);
          break;
        case 3:
          System.out.println("Setting all borrowed books to overdue.");
          library.overdueAll();
          break;
      }
    }
  }
  private final ArrayList<Book> books;
  public Library() {
    this.books = new ArrayList<>();
  }
  public void addBook(Book book) {
    this.books.add(book);
  }
  public void borrowBook(int bookId) {
    for (Book book : books) {
      if (book.getId() == bookId) {
        if (book.getStatus() == BookStatus.IDLE) {
          book.setStatus(BookStatus.BORROWED);
          System.out.printf("borrow %s successfully\n", book.getName());
        } else {
          System.out.printf("%s is not available.\n", book.getName());
        }
        return;
      }
    }
  }
  public void returnBook(int bookId) {
    for (Book book : books) {
      if (book.getId() == bookId) {
        if (book.getStatus() == BookStatus.BORROWED || book.getStatus() == BookStatus.OVERDUE) {
          book.setStatus(BookStatus.IDLE);
          System.out.printf("return %s successfully\n", book);
        } else {
          System.out.printf("%s is not available.\n", book);
        }
        return;
      }
    }
  }
  public void overdueBook(int bookId) {
    for (Book book : books) {
      if (book.getId() == bookId) {
        if (book.getStatus() == BookStatus.BORROWED) {
          book.setStatus(BookStatus.OVERDUE);
          System.out.println(book);
        }
        return;
      }
    }
  }
  public void overdueAll() {
    for (Book book : books)
      if (book.getStatus() == BookStatus.BORROWED)
        overdueBook(book.getId());
  }
  public void displayAvailableBooks() {
    for (Book book : books)
      if (book.getStatus() == BookStatus.IDLE)
        System.out.println(book);
  }
  public void displayBorrowedBooks() {
    for (Book book : books)
      if (book.getStatus() == BookStatus.BORROWED || book.getStatus() == BookStatus.OVERDUE)
        System.out.println(book);
  }
}