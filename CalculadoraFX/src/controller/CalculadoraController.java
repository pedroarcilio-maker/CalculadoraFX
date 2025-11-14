package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CalculadoraController {
	//controle da calculadora
    @FXML
    private TextField display;

    private double num1 = 0;
    private String operador = "";
    private boolean limpar = false;
    
   //método dos botões 
    @FXML
    private void onNumberClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String value = btn.getText();

        if (limpar) {
            display.clear();
            limpar = false;
        }

        display.appendText(value);
    }

  //método dos botões 
    @FXML
    private void onOperatorClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        operador = btn.getText();
        try {

            num1 = Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            display.setText("Erro");
            return;
        }

        limpar = true;
    }
    
   //método dos botões 
    @FXML
    private void onEqualsClick(ActionEvent event) {
        try {
            double num2 = Double.parseDouble(display.getText());
            double resultado = 0;

            switch (operador) {
                case "+": resultado = soma(num1, num2); break;
                case "-": resultado = subtracao(num1, num2); break;
                case "*": resultado = multiplicacao(num1, num2); break;
                case "/": resultado = divisao(num1, num2); break;
                default: display.setText("Erro"); return;
            }

            display.setText(String.valueOf(resultado));
            limpar = true;

        } catch (NumberFormatException e) {
            display.setText("Erro");
        } catch (IllegalArgumentException e) {
            display.setText("Div/0");
        }
    }

  //método dos botões 
    @FXML
    private void onClearClick(ActionEvent event) {
        display.clear();
        num1 = 0;
        operador = "";
        limpar = false;
    }
    
    //métodos matemáticos
    private double soma(double a, double b) {
        return a + b;
    }

    private double subtracao(double a, double b) {
        return a - b;
    }

    private double multiplicacao(double a, double b) {
        return a * b;
    }

    private double divisao(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}

