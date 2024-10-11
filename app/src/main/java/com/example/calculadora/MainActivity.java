package com.example.calculadora;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultadoText;
    private double valor1 = 0, valor2 = 0;
    private String operador = "";
    private boolean esNuevoOperador = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultadoText = findViewById(R.id.resultadoText);

        configurarBotones();
    }

    private void configurarBotones() {
        findViewById(R.id.button0).setOnClickListener(v -> agregarNumero("0"));
        findViewById(R.id.button1).setOnClickListener(v -> agregarNumero("1"));
        findViewById(R.id.button2).setOnClickListener(v -> agregarNumero("2"));
        findViewById(R.id.button3).setOnClickListener(v -> agregarNumero("3"));
        findViewById(R.id.button4).setOnClickListener(v -> agregarNumero("4"));
        findViewById(R.id.button5).setOnClickListener(v -> agregarNumero("5"));
        findViewById(R.id.button6).setOnClickListener(v -> agregarNumero("6"));
        findViewById(R.id.button7).setOnClickListener(v -> agregarNumero("7"));
        findViewById(R.id.button8).setOnClickListener(v -> agregarNumero("8"));
        findViewById(R.id.button9).setOnClickListener(v -> agregarNumero("9"));
        findViewById(R.id.buttonDecimal).setOnClickListener(v -> agregarNumero("."));

        findViewById(R.id.buttonMas).setOnClickListener(v -> seleccionarOperacion("+"));
        findViewById(R.id.buttonMenos).setOnClickListener(v -> seleccionarOperacion("-"));
        findViewById(R.id.buttonMultiplicacion).setOnClickListener(v -> seleccionarOperacion("×"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> seleccionarOperacion("÷"));
        findViewById(R.id.buttonIgual).setOnClickListener(v -> realizarOperacion());
        findViewById(R.id.buttonAC).setOnClickListener(v -> limpiar());
    }

    private void agregarNumero(String numero) {
        if (esNuevoOperador) {
            resultadoText.setText(numero);
            esNuevoOperador = false;
        } else {
            resultadoText.append(numero);
        }
    }

    private void seleccionarOperacion(String operador) {
        valor1 = Double.parseDouble(resultadoText.getText().toString());
        this.operador = operador;
        esNuevoOperador = true;
    }

    private void realizarOperacion() {
        valor2 = Double.parseDouble(resultadoText.getText().toString());
        CalculadoraBase operacion = null;

        switch (operador) {
            case "+":
                operacion = new Suma();
                break;
            case "-":
                operacion = new Resta();
                break;
            case "×":
                operacion = new Multiplicacion();
                break;
            case "÷":
                operacion = new Division();
                break;
        }

        if (operacion != null) {
            double resultado = operacion.calcular(valor1, valor2);
            resultadoText.setText(String.valueOf(resultado));
        }
    }

    private void limpiar() {
        valor1 = 0;
        valor2 = 0;
        operador = "";
        resultadoText.setText("0");
        esNuevoOperador = true;
    }
}
