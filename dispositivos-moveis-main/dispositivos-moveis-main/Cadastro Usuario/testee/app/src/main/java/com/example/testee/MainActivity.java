package com.example.testee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextDtnsc;
    private Button button;
    private SQLiteDatabase database;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextDtnsc = findViewById(R.id.editTextDtnsc);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String dtnsc = editTextDtnsc.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);
                cv.put("dtnsc", dtnsc);

                long status = database.insert("pessoas", null, cv);

                if (status > 0) {
                    Toast.makeText(getApplicationContext(), "Usuário inserido com sucesso!", Toast.LENGTH_LONG).show();
                }
                carregarListagem();
            }
        });

        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT, dtnsc DATE)");
        carregarListagem();
    }
    public void carregarListagem(){
        Cursor cursor=database.rawQuery("select * from pessoas" ,null);
        cursor.moveToFirst();

        ArrayList<String> nomes= new ArrayList<>();
        while(!cursor.isAfterLast()){
            nomes.add(cursor.getString(1));
            cursor.moveToNext();

        }
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,nomes);
        listView.setAdapter(adapter);
    }

}
