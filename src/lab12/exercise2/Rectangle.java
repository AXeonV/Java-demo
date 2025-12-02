package lab12.exercise2;


import java.awt.*;

public class Rectangle extends Shape implements Comparable<Rectangle> {

    // TODO implement Colorable and Comparable<Rectangle>

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width = width;
        if(width != height){
            this.color = Color.GREEN;
        }

    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.GRAY;

    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
    }

    @Override
    public String getShapeName() {
        return width == height? "Square":"Rectangle";
    }

    @Override
    public int getSize(){
        return width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

//    @Override
//    public int compareTo(Rectangle o) {
//        if (width * height == o.width * o.height) {
//            if (x == o.x) return 0;
//            return (x < o.x) ? -1 : 1;
//        }
//        return (width * height < o.width * o.height) ? 1 : -1;
//    }

    @Override
    public int compareTo(Rectangle o) {
        if (width * height == o.width * o.height) {
            if (y == o.y) return 0;
            return (y < o.y) ? -1 : 1;
        }
        return (width * height < o.width * o.height) ? -1 : 1;
    }
}