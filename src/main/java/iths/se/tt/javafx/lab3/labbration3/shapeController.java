package iths.se.tt.javafx.lab3.labbration3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class shapeController {

    @FXML
    private Canvas canvas;
    @FXML
    private ChoiceBox<ShapeType> shapes;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Button undoButton;
    @FXML
    private Button redoButton;

    @FXML
    private ChoiceBox chooseSize;

    private GraphicsContext graphicsContext;

    private Model model = new Model();
    ObservableList<ShapeType>shapeTypesList = FXCollections.observableArrayList(ShapeType.values());

//    When the application starts
    public void initialize(){
        shapes.setItems(shapeTypesList);
        shapes.valueProperty().bindBidirectional(model.currentShapeTypeProperty());
        model.getShapes().addListener(this::listChanged);
        chooseSize.setValue("80");

        colorPicker.valueProperty().bindBidirectional(model.colorPickerProperty());

    }

    private void listChanged(Observable observable) {
        var graphicsContext = canvas.getGraphicsContext2D();
        for (Shape s : model.getShapes()) {
            s.draw(graphicsContext);
        }
    }

    public void onCanvasClicked(MouseEvent mouseEvent) {
        if (mouseEvent.isPrimaryButtonDown()){
              model.getShapes().stream().sorted().reduce((first, second) -> second).ifPresent(shape -> shape.setColor(model.getCurrentColor()));
        }

        //Create shape
        Shape shape = Shape.createShape(model.getCurrentShape(), mouseEvent.getX(), mouseEvent.getY(),model.getCurrentColor());
        model.addShape(shape); //add shape
        
    }
}