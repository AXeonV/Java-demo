package swings1;

import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape() {
        // Default color is black
        this.color = Color.BLACK;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Base method for drawing
    public abstract void draw(Graphics2D g2d);

    // Base method for getting shape name
    public abstract String getShapeName();

    public boolean checkdot(int x, int y) {
        return (x >= 0 && x <= 400 && y >= 0 && y <= 400);
    }

    public abstract void checkPosition();
}