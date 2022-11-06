package iths.se.tt.javafx.lab3.labbration3;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collection;

public class Model {
    ObjectProperty<ShapeType>currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);
    ObjectProperty<Color>currentColorType = new SimpleObjectProperty<>(Color.BLACK);
    ObservableList<observableShape> shapes = FXCollections.observableArrayList(execute -> new Observable[]{execute.colorProperty()});
    public ObservableList<? extends Shape> getShapes() {
        return shapes;
    }

    public ShapeType getCurrentShape(){
        return currentShapeType.get();
    }

    public ObjectProperty<ShapeType> currentShapeTypeProperty(){
        return currentShapeType;
    }

    public void setCurrentShapeType(ShapeType currentShapeType){
        this.currentShapeType.set(currentShapeType);
    }

    public Shape addShape(Shape shape){
        var oShape = new observableShape(shape);
        shapes.add(oShape);
        return oShape;
    }

    public ObjectProperty<Color> colorPickerProperty() {
        return currentColorType;
    }
    public Color getCurrentColor(){
        return currentColorType.get();
    }
    public void setCurrentColorType(Color currentColorType){
        this.currentColorType.set(currentColorType);
    }
}
