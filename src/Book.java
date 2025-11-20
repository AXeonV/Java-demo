public class Book extends Product {
  public Book(String name, int price, int stockQuantity) {
    super(name, price, stockQuantity, ProductType.BOOK);
  }
}
