public class Product {
  private String name;
  private int price;
  private int stockQuantity;
  private ProductType type;

  public Product(String name, int price, int stockQuantity, ProductType type) {
    this.name = name;
    this.price = price;
    this.stockQuantity = stockQuantity;
    this.type = type;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getStockQuantity() {
    return stockQuantity;
  }
  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
  public ProductType getType() {
    return type;
  }
  public void setType(ProductType type) {
    this.type = type;
  }

  public void addStock(int qty) {
    this.stockQuantity += qty;
  }
  public void reduceStock(int qty) {
    this.stockQuantity = Math.max(0, this.stockQuantity - qty);
  }

  @Override
  public String toString() {
    return String.format("%s - %s: $%d, Stock: %d", type, name, price, stockQuantity);
  }
}
