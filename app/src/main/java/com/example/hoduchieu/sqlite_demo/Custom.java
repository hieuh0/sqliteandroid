package com.example.hoduchieu.sqlite_demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hoduchieu on 11/25/16.
 */

public class Custom extends BaseAdapter {
    Context context;
    ArrayList<SinhVien> list;
    public Custom(Context context,ArrayList<SinhVien> list){
        this.context=context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final LayoutInflater inflater = LayoutInflater.from(context);
       final Mydatabase db = new Mydatabase(context);
        view = inflater.inflate(R.layout.layout,null);
        TextView id,ten,email;
        id = (TextView) view.findViewById(R.id.textView);
        ten = (TextView) view.findViewById(R.id.textView2);
        email = (TextView) view.findViewById(R.id.textView3);
        final SinhVien s = list.get(i);
        id.setText(s.getID()+"");
        ten.setText(s.getTen());
        email.setText(s.getEmail());
        Button btnXoa = (Button) view.findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            db.DeleteStudent(s.ID);
                notifyDataSetChanged();
                list.remove(i);
            }
        });

        Button btnsua = (Button) view.findViewById(R.id.btnSua);
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Update.class);
                intent.putExtra("ID",s.ID);
                intent.putExtra("TEN",s.Ten);
                intent.putExtra("EMAIL",s.Email);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
            }
        });

        return view;
    }
}
