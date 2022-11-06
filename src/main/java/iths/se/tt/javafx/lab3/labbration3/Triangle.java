package iths.se.tt.javafx.lab3.labbration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(double x, double y, Color color, Double sizeOfShape) {

        super(x,y, color, sizeOfShape);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        //GetColor default is black if nothing else is chosen.
        graphicsContext.setFill(getColor());
//        graphicsContext.fillRect(getX()-10, getY()-10,20,20);
        graphicsContext.fillPolygon(
                new double[]{
                        getX()-70+getSizeOfShape(),
                        getX()+95-getSizeOfShape(),
                        getX()+120-getSizeOfShape()
                },
                new double[]{
                        getY()-60+getSizeOfShape(),
                        getY()+10-getSizeOfShape(),
                        getY()+60-getSizeOfShape()
                },
                3);
    }
}
