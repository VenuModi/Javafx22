package iths.se.tt.javafx.lab3.labbration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public Circle(double x, double y, Color color, Double sizeOfShape) {

        super(x,y, color, sizeOfShape);
    }
    @Override
    public void draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(getColor());
        graphicsContext.fillOval(
                getX()-getSizeOfShape()-5,
                getY()-getSizeOfShape()-5,
                2*getSizeOfShape()+5,
                2*getSizeOfShape()+5);

    }
}
