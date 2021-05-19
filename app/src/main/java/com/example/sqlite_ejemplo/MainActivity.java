package com.example.sqlite_ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtCodigo,edtCarrera,edtCurso;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCodigo=(EditText)findViewById(R.id.edtCodigo);
        edtCarrera=(EditText)findViewById(R.id.edtCarrera);
        edtCurso=(EditText)findViewById(R.id.edtCurso);
        btnAgregar=(Button)findViewById(R.id.btnAgregar);
        final  DeveloperuBD developeruBD=new DeveloperuBD(getApplicationContext());
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                developeruBD.agregarCursos(edtCodigo.getText().toString(),edtCurso.getText().toString(),edtCarrera.getText().toString());

                Toast.makeText(getApplicationContext(),"SE AGREGO CORRECTAMENTE",Toast.LENGTH_LONG).show();

            }
        });

    }
}

