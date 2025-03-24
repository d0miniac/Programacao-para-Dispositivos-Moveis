package com.ifsc.imc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int i=0;

    EditText edpeso, edaltura;

    TextView tvresultado;

    Button botaocalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edpeso = findViewById(R.id.edpeso);
        edaltura = findViewById(R.id.edaltura);
        tvresultado = findViewById(R.id.tvresultado);
        botaocalcular = findViewById(R.id.botaocalcular);
        botaocalcular.setOnClickListener(v ->{

            double peso, altura, imc;
            peso=Double.parseDouble(edpeso.getText().toString());
            altura=Double.parseDouble(edaltura.getText().toString());
            imc=peso/(altura*altura);

            tvresultado.setText(Double.toString(imc));

        });
        };
    }
