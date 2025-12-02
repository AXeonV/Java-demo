package lab12.exercise1;

import java.awt.*;

public class Circle extends Shape implements Comparable<Circle> {
    private int radius = 30;

    public Circle() {
        super();
        this.color = Color.GRAY;
    }

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.GRAY;
    }

    public int getRadius(){
        return radius;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillOval(x, y, radius * 2, radius * 2);
    }

    public String getShapeName() {
        return "Circle";
    }

    public int getSize(){
        return radius * 2;
    }

    @Override
    public int compareTo(Circle o) {
        if (radius > o.radius) return -1;
        return (radius == o.radius) ? 0 : 1;
    }
}