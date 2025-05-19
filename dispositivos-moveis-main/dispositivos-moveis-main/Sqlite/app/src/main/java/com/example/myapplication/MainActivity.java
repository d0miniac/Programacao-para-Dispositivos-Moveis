package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase banco;
    EditText txtNome, txtDataNsc, txtEmail;
    Button bt;
    Button limpar;
    ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtnome);
        txtEmail = findViewById(R.id.txtemail);
        txtDataNsc = findViewById(R.id.txtdata);
        bt=findViewById(R.id.button);
        limpar = findViewById(R.id.btlimpar);
        list = findViewById(R.id.listview);

        banco = openOrCreateDatabase("banco",MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE if not exists pessoas (id  INTEGER PRIMARY KEY autoincrement,nome varchar, email varchar, dtnsc date)");

        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            String nome = txtNome.getText().toString();
            String email = txtEmail.getText().toString();
            String data = txtDataNsc.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("nome",nome);
            cv.put("email",email);

            long status =banco.insert("pessoas",null,cv);

            if(status>0){
                Toast.makeText(MainActivity.this, "Deu boa", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(MainActivity.this, "Garr", Toast.LENGTH_SHORT).show();
            }
                carregarlist();
            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                txtNome.setText("");
                txtDataNsc.setText("");
                txtEmail.setText("");
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String pos = String.valueOf(i);
//                Cursor cursor =banco.rawQuery("SELECT * FROM pessoas where id == ?",);
//                txtNome.setText("");
//                txtDataNsc.setText("");
//                txtEmail.setText("");
            }
        });
        carregarlist();
    }

    public void carregarlist(){
        Cursor cursor =banco.rawQuery("SELECT * FROM pessoas",null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>();
        while(!cursor.isAfterLast())
        {
            nomes.add(cursor.getString(1));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,nomes);
        list.setAdapter(adap);
    }

}