package com.example.thongtinsanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.model.SanPham;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    EditText edtMaSP, edtTenSP, edtGiaSp;
    Button btnThemSp;
//    ArrayList<String> arrayCoure = new ArrayList<>();
//    ArrayAdapter adapter = new ArrayAdapter(MainActivity3.this,
//            android.R.layout.simple_list_item_1, arrayCoure);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dieuKhien();
        suKien();
    }

    private void suKien() {
        btnThemSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String n = edtTenSP.getText().toString();
////                Intent intent = null;
////                ArrayList<String> listName = new ArrayList<>();
//                arrayCoure.add(n);
//                adapter.notifyDataSetChanged();
                //intent.putExtra(" ", listName);
                //setResult(9, intent);
                finish();
            }
        });
    }

    private void dieuKhien() {
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSp = findViewById(R.id.edtGiaSP);
        btnThemSp = findViewById(R.id.btnThemSP);
    }
}