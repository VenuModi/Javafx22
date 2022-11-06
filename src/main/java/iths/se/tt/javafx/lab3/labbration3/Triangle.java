package iths.se.tt.javafx.lab3.labbration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public Triangle(double x, double y, Color color) {

        super(x,y, color);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        //GetColor default is black if nothing else is chosen.
        graphicsContext.setFill(getColor());
//        graphicsContext.fillRect(getX()-10, getY()-10,20,20);
        graphicsContext.fillPolygon(
                new double[]{getX()-20,getX()+40,getX()+60},
                new double[]{getY()-0, getY()+100,getY()+0},
                3);
    }
}
