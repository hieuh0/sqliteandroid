package com.example.hoduchieu.sqlite_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Mydatabase mydatabase;
    ArrayList<SinhVien> list = new ArrayList<>();
    Custom adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabase = new Mydatabase(getApplication());
        final EditText edtTen = (EditText) findViewById(R.id.edtName);
        final EditText edtMail = (EditText) findViewById(R.id.edtEmail);
        ListView listView = (ListView) findViewById(R.id.listview);
        Button btnThem = (Button) findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString().trim();
                String mail = edtMail.getText().toString().trim();

                mydatabase.InsertStudent(ten,mail);
                finish();
                startActivity(getIntent());
                overridePendingTransition(0,0);

            }
        });
        list = mydatabase.getAllStudent();
        adapter = new Custom(getApplication(),list);
        listView.setAdapter(adapter);
    }
}
