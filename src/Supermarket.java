import java.util.ArrayList;

public class Supermarket {
  private ArrayList<Product> inventory;

  public Supermarket() {
    inventory = new ArrayList<>();
  }

  public ArrayList<Product> getInventory() {
    return inventory;
  }
  public void addProduct(Product p) {
    for (Product product : inventory) {
      if (product.getName().equals(p.getName())) {
        product.addStock(p.getStockQuantity());
        return;
      }
    }
    inventory.add(p);
  }
  public void reduceStock(String name, int qty) {
    for (Product product : inventory)
      if (product.getName().equals(name)) {
        product.reduceStock(qty);
        if (product.getStockQuantity() == 0)
          inventory.remove(product);
        return;
      }
  }
  public int getStock(String name) {
    for (Product product : inventory)
      if (product.getName().equals(name))
        return product.getStockQuantity();
    return 0;
  }
  public Product getProduct(String name) {
    for (Product product : inventory)
      if (product.getName().equals(name))
        return product;
    return null;
  }
  public void showInventory() {
    for (Product product : inventory)
      System.out.println(product);
    System.out.println("Total products: " + inventory.size());
  }
}
