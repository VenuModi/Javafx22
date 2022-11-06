package iths.se.tt.javafx.lab3.labbration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public Circle(double x, double y, Color color) {

        super(x,y, color);
    }
    @Override
    public void draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(getColor());
        graphicsContext.fillOval(getX()-10, getY()-10,20,20);

    }
}
