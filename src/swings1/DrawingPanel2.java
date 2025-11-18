package swings1;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel2 extends JPanel {
  private final Diamond diamond;
  private final Triangle triangle;
  private final Rectangle rectangle;
  private final Circle circle;
  public DrawingPanel2() {
    setPreferredSize(new Dimension(400, 400));
    diamond = new Diamond();
    triangle = new Triangle();
    rectangle = new Rectangle();
    circle = new Circle();
    diamond.setPosition(randomCoord(), randomCoord());
    triangle.setPosition(randomCoord(), randomCoord());
    rectangle.setPosition(randomCoord(), randomCoord());
    circle.setPosition(randomCoord(), randomCoord());
    diamond.checkPosition();
    triangle.checkPosition();
    rectangle.checkPosition();
    circle.checkPosition();
  }
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    // Draw all shapes
    diamond.draw(g2d);
    triangle.draw(g2d);
    rectangle.draw(g2d);
    circle.draw(g2d);

  }
  // Generate random coordinate between -10 and 400
  private int randomCoord() {
    return (int)(Math.random() * 410) - 10;
  }
}