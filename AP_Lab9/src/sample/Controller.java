package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * this class control fxml
 */
public class Controller {
    /////final result of inputs
    private float result;
    /////current number
    private String number="";
    ////input history while client click on result button
    private ArrayList<String> inputs = new ArrayList<>();
    ////current index of input history list
    private int currentIndex=0;

    /////object of TextField in calculator
    @FXML
    private TextField screen;

    /**
     * if client press '*','+','-','/','sin','cos','tan','^','√' this method will be called
     * @param event
     */
    @FXML
    void functionPressed(ActionEvent event) {
        if(number.length()!=0)
            inputs.add(number);
        number="";
        String function = getButtonValue(event);
        currentIndex++;
        inputs.add(function);
        currentIndex++;
    }

    /**
     * if client press a number or press '.' this method will be called
     * @param event
     */
    @FXML
    void numberPressed(ActionEvent event) {
        number+=getButtonValue(event);
    }

    /**
     * if client press '=' , program calculate inputs and show it on screen
     * @param event
     */
    @FXML
    void resultPressed(ActionEvent event) {
        inputs.add(number);
        calculateResult();
        result = Float.parseFloat(inputs.get(0));
        screen.setText(String.valueOf(result));
        setCalculator();
    }

    /**
     * clean the screen if "AC" is called
     * @param event
     */
    @FXML
    void cleanScreenFunc(ActionEvent event) {
        screen.setText("");
        inputs.clear();
        setCalculator();
    }

    /**
     * turn off the calculator
     * @param event
     */
    @FXML
    void offCalculator(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    /**
     * find the value of the button
     * @param event
     * @return
     */
    private String getButtonValue(ActionEvent event) {
        Button button = (Button) event.getSource();
        String key = button.getText();
        screen.setText(screen.getText() + key);
        return key;
    }

    /**
     * calculate the inputs
     */
    private void calculateResult() {
        print();
        try {
            while (inputs.contains("√")||inputs.contains("sin")||inputs.contains("cos")||inputs.contains("tan")) {
                int index;
                float result;
                if(inputs.contains("√")){
                    index = inputs.indexOf("√");
                    result= (float) Math.sqrt(Float.parseFloat(inputs.get(index + 1)));
                }
                else if(inputs.contains("sin")){
                    index = inputs.indexOf("sin");
                    double inRadian = Math.toRadians(Float.parseFloat(inputs.get(index + 1)));
                    result= (float) Math.sin(inRadian);
                }
                else if(inputs.contains("cos")){
                    index = inputs.indexOf("cos");
                    double inRadian = Math.toRadians(Float.parseFloat(inputs.get(index + 1)));
                    result= (float) Math.cos(inRadian);
                }
                else {
                    index = inputs.indexOf("tan");
                    double inRadian = Math.toRadians(Float.parseFloat(inputs.get(index + 1)));
                    result= (float) Math.tan(inRadian);
                }
                inputs.set(index, String.valueOf(result));
                inputs.remove(index + 1);
            }
            while (inputs.contains("*") || inputs.contains("/") || inputs.contains("+") || inputs.contains("-")||inputs.contains("^")) {
                print();
                int index;
                float result;
                if(inputs.contains("^")){
                    index = inputs.indexOf("^");
                    result = (float) Math.pow(Float.parseFloat(inputs.get(index - 1)) , Float.parseFloat(inputs.get(index + 1)));
                }
                else if (inputs.contains("*")) {
                    index = inputs.indexOf("*");
                    result = Float.parseFloat(inputs.get(index - 1)) * Float.parseFloat(inputs.get(index + 1));
                } else if (inputs.contains("/")) {
                    index = inputs.indexOf("/");
                    result = Float.parseFloat(inputs.get(index - 1)) / Float.parseFloat(inputs.get(index + 1));
                } else if (inputs.contains("-")) {
                    index = inputs.indexOf("-");
                    result = Float.parseFloat(inputs.get(index - 1)) -Float.parseFloat(inputs.get(index + 1));
                } else {
                    index = inputs.indexOf("+");
                    result = Float.parseFloat(inputs.get(index - 1)) + Float.parseFloat(inputs.get(index + 1));
                }
                inputs.set(index - 1, String.valueOf(result));
                inputs.remove(index);
                inputs.remove(index);
            }
        }catch (Exception e){
            screen.setText("ERROR!");
            inputs.clear();
            setCalculator();
        }
        print();
    }
    private void print(){
        System.out.println("size ="+inputs.size());
        for (String str : inputs){
            System.out.println(str);
        }
        System.out.println("-----------------------");
    }

    /**
     * set calculate to default values
     */
    private void setCalculator(){
        number="";
        currentIndex=inputs.size();
    }

}
