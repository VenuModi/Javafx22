package iths.se.tt.javafx.lab3.labbration3;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class observableShape extends Shape{
    Shape shape;
    ObjectProperty<Color> color = new SimpleObjectProperty<>();

    public observableShape(Shape shape){
        super(shape.getX (), shape.getY(), shape.getColor());
        this.shape = shape;
    }

    public ObjectProperty<Color>colorProperty(){
        return color;
    }

    @Override
    public void setColor (Color color){
        shape.setColor(color);
        this.color.set(color);
    }

    @Override
    public void draw (GraphicsContext graphicsContext){
        this.shape.draw(graphicsContext);
    }
}
