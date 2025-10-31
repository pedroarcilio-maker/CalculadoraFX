package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CalculadoraController {

    @FXML
    private TextField display;

    private double num1 = 0;
    private String operador = "";
    private boolean limpar = false;

    // Método para os botões numéricos (0 a 9)
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

    // Método para os botões de operação (+, -, *, /)
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

    // Método para o botão "="
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

    // Método para o botão "C"
    @FXML
    private void onClearClick(ActionEvent event) {
        display.clear();
        num1 = 0;
        operador = "";
        limpar = false;
    }

    // Métodos matemáticos
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

