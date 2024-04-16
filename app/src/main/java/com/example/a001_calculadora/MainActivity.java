package com.example.a001_calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number_1;
    EditText number_2;
    Button btn_suma, btn_resta, btn_multiplicacion, btn_division, btn_calcular, btn_reset;
    TextView txt_resultado;
    String operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_1 = findViewById(R.id.number_1);
        number_2 = findViewById(R.id.number_2);
        btn_suma = findViewById(R.id.btn_suma);
        btn_resta = findViewById(R.id.btn_resta);
        btn_multiplicacion = findViewById(R.id.btn_multiplicacion);
        btn_division = findViewById(R.id.btn_division);
        btn_calcular = findViewById(R.id.btn_calcular);
        txt_resultado = findViewById(R.id.txt_resultado);
        btn_reset = findViewById(R.id.btn_reset);

        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "+";
            }
        });

        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "-";
            }
        });

        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "*";
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "/";
            }
        });

        // Configurar el manejo de eventos de clic para el botón "Calcular"
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si se ha seleccionado una operación y si los campos de entrada no están vacíos
                if (operacion != null && validarEntrada()) {
                    // Realizar el cálculo
                    calcular();
                }
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método para restablecer los valores
                resetearValores();
            }
        });
    }
    private boolean validarEntrada() {
        String num1Str = number_1.getText().toString();
        String num2Str = number_2.getText().toString();
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(MainActivity.this, "Ingrese los dos dígitos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // Método para realizar el cálculo
    private void calcular() {
        double num1 = Double.parseDouble(number_1.getText().toString());
        double num2 = Double.parseDouble(number_2.getText().toString());
        double resultado = 0;

        // Realizar la operación seleccionada
        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    Toast.makeText(MainActivity.this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        // Mostrar el resultado en el TextView
        txt_resultado.setText("Resultado: " + resultado);
    }

    private void resetearValores() {
        number_1.setText(""); // Limpiar el campo de número 1
        number_2.setText(""); // Limpiar el campo de número 2
        txt_resultado.setText(""); // Limpiar el resultado
        operacion = null; // Restablecer la operación seleccionada
    }
}