package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button botao;
    TextView textView;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.botao);
        textView = findViewById(R.id.textView);

        botao.setText("Clique aqui");
        textView.setText("Contador: " + contador);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++; // Incrementa o valor
                textView.setText("Você clicou " + contador + " vezes");
            }
        });
    }
}