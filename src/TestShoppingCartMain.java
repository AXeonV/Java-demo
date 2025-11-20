public class TestShoppingCartMain {
  public static void main(String[] args) {
    Supermarket s = new Supermarket();
    Member m = new Member("Grace");
    Product p1 = new Book("Test Book", 50, 10);
    Product p2 = new Food("Test Food", 5, 20);
    s.addProduct(p1);
    s.addProduct(p2);

    ShoppingCart cart = new ShoppingCart(m, s);
    cart.add("Test Book", 2); // $100
    cart.add("Test Food", 5); // $25
    System.out.println("Cart size before checkout: " + cart.getItems().size());
    int initialPoints = m.getPoints();
    int initialStock1 = s.getStock("Test Book");
    cart.checkout();
    System.out.println("Member points after checkout: " + m.getPoints() + " (expected " + (initialPoints + 125) + ")");
    System.out.println("Cart size after checkout: " + cart.getItems().size());
    System.out.println("Stock Test Book after checkout: " + s.getStock("Test Book") + " (expected " + (initialStock1 - 2) + ")");
  }
}

