package com.example.hoduchieu.sqlite_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    Mydatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = new Mydatabase(getApplication());
        Intent intent = getIntent();
       final int id = intent.getIntExtra("ID",1);
        final  String ten = intent.getStringExtra("TEN");
        final String email = intent.getStringExtra("EMAIL");

        EditText edtid = (EditText) findViewById(R.id.editText);
        final EditText edtTen = (EditText) findViewById(R.id.editText2);
        final EditText edtEmail = (EditText) findViewById(R.id.editText3);

        edtid.setText(id+"");
        edtTen.setText(ten);
        edtEmail.setText(email);
        edtid.setEnabled(false);

        Button btnupdate = (Button) findViewById(R.id.btnUpdate);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String newTen = edtTen.getText().toString();
                String newEmail = edtEmail.getText().toString();
                db.UpdateData(id,newTen,newEmail);

            }
        });
    }
}
