import java.util.ArrayList;

public class ShoppingCart {
  private Member member;
  private Supermarket supermarket;
  private ArrayList<CartItem> items;

  public ShoppingCart(Member m, Supermarket s) {
    this.member = m;
    this.supermarket = s;
    this.items = new ArrayList<>();
  }

  public ArrayList<CartItem> getItems() {
    return items;
  }

  public void add(String productName, int qty) {
    Product p = supermarket.getProduct(productName);
    if (p == null) return;
    for (CartItem item : items)
      if (item.getProduct().getName().equals(productName)) {
        int requiredQty = item.getQuantity() + qty;
        if (requiredQty > p.getStockQuantity()) return;
        item.addQuantity(qty);
        return;
      }
    if (qty > p.getStockQuantity()) return;
    items.add(new CartItem(p, qty));
  }

  public void show() {
    int totalPrice = 0;
    for (CartItem item : items) {
      System.out.println(item);
      totalPrice += item.getSubtotal();
    }
    System.out.println("Total: $" + totalPrice);
  }

  public void checkout(boolean usePoints) {
    int rawTotal = 0;
    for (CartItem item : items)
      rawTotal += item.getSubtotal();
    int maxSafeDeduction = 0;
    if (usePoints) maxSafeDeduction = member.usePoints(rawTotal);
    for (CartItem item : items)
      supermarket.reduceStock(item.getProduct().getName(), item.getQuantity());
    int finalTotal = rawTotal - maxSafeDeduction;
    member.addPoints(finalTotal);
    System.out.println("=== Checkout Receipt ===");
    show();
    System.out.printf("Point used: $%d (%d points)\n", maxSafeDeduction, maxSafeDeduction);
    System.out.printf("Final Total: $%d\n", finalTotal);
    System.out.printf("Points earned: %d\n", finalTotal);
    System.out.println("===");
    items.clear();
  }

  public void checkout() {
    checkout(false);
  }
}
