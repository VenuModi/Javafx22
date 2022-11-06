package iths.se.tt.javafx.lab3.labbration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    private final double x;
    private final double y;
    private Color color;

    public Shape(double x, double y, Color color) {

        this.x = x;
        this.y = y;
        this.color = color;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }
    public abstract void draw(GraphicsContext graphicsContext);
    public static Shape createShape(ShapeType type, double x, double y, Color color){
        return switch (type){
            case CIRCLE -> new Circle(x,y, color);
            case TRIANGLE -> new Triangle(x,y, color);
        };
    }
}
