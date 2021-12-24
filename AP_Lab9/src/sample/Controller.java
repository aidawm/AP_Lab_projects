package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {
    private String currentFunc=null;
    private float result;
    private String number1="";
    private String number2="";

    @FXML
    private TextField screen;

    @FXML
    void functionPressed(ActionEvent event) {
        String function = getButtonValue(event);
        if (number1.length()==0){
            number1=number2;
            number2="";
            currentFunc=function;
        }
        else {
            calculateResult();
            currentFunc=function;
            number1=String.valueOf(result);
            number2="";
        }
    }

    @FXML
    void numberPressed(ActionEvent event) {
        number2+=getButtonValue(event);
    }

    @FXML
    void resultPressed(ActionEvent event) {
        calculateResult();
        screen.setText(String.valueOf(result));
    }

    private String getButtonValue(ActionEvent event){
        Button button = (Button) event.getSource();
        String key =button.getText();
        screen.setText(screen.getText()+key);
        return key;

    }
    private void calculateResult(){

        if(currentFunc.equals("+")){
            result=(Float.parseFloat(number1)+Float.parseFloat(number2));
        }
        else if(currentFunc.equals("-")){
            result=(Float.parseFloat(number1)-Float.parseFloat(number2));
        }
        else if(currentFunc.equals("*")){
            result=(Float.parseFloat(number1)*Float.parseFloat(number2));
        }
        else if(currentFunc.equals("/")){
            result=(Float.parseFloat(number1)/Float.parseFloat(number2));
        }
    }
}
