package swings1;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

  public Shape[] shapes;

  public DrawingPanel() {
    setPreferredSize(new Dimension(400, 400));

    shapes = new Shape[]{
        new Diamond(),
        new Triangle(),
        new Rectangle(),
        new Circle()
    };

    for (Shape shape : shapes) {
      shape.setPosition(randomCoord(), randomCoord());
      shape.checkPosition();
    }
  }
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Shape shape : shapes)
      shape.draw(g2d);
  }
  // Generate random coordinate between -10 and 400
  private int randomCoord() {
    return (int)(Math.random() * 410) - 10;
  }
}