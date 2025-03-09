package edu.farmingdale.csc325_module05_lab_part2;

// Controller for the ColorChooser app
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    // instance variables for interacting with GUI components
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() {
        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), java.text.NumberFormat.getIntegerInstance());
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), java.text.NumberFormat.getIntegerInstance());
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), java.text.NumberFormat.getIntegerInstance());
        Bindings.bindBidirectional(alphaTextField.textProperty(), alphaSlider.valueProperty(), java.text.NumberFormat.getNumberInstance());

        // listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        updateColor();
                    }
                }
        );
        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        updateColor();
                    }
                }
        );
        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        updateColor();
                    }
                }
        );
        alphaSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        alpha = newValue.doubleValue();
                        updateColor();
                    }
                }
        );
    }
    private void updateColor() {
        try{
            red = Integer.parseInt(redTextField.getText());
            green = Integer.parseInt(greenTextField.getText());
            blue = Integer.parseInt(blueTextField.getText());
        }catch(Exception e){

        }
        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
    }
}