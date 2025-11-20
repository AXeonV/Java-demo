public class CartItem {
  private Product product;
  private int quantity;
  public CartItem(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }
  public int getQuantity() {
    return quantity;
  }

  public int getSubtotal() {
    return product.getPrice() * quantity;
  }

  @Override
  public String toString() {
    return String.format("%s x%d - $%d/ea = $%d", product.getName(), quantity, product.getPrice(), getSubtotal());
  }

  public void addQuantity(int qty) {
    this.quantity = Math.min(quantity + qty, product.getStockQuantity());
  }
  public void reduceQuantity(int qty) {
    this.quantity = Math.max(quantity - qty, 0);
  }
}
