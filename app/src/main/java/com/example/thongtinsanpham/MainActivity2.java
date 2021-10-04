package com.example.thongtinsanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.SanPham;

public class MainActivity2 extends AppCompatActivity {
    Button btnXoa, btnTroVe, btnXemAnh;
    TextView txtMa, txtTen, txtGia;
    Intent intent;
    SanPham sp;
    ImageView imgAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        hamDieuKhien();
        hamSuKien();
    }

    private void hamSuKien() {
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("xoa", true);
                intent.putExtra("sp",sp);
                setResult(2, intent);
                finish();
            }
        });
        btnXemAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable img;
                if (sp.getMa() == 101){
                    img = AppCompatResources.getDrawable(MainActivity2.this, R.drawable.iphone);
                    imgAnh.setImageDrawable(img);
                } else if (sp.getMa() == 102){
                    img = AppCompatResources.getDrawable(MainActivity2.this, R.drawable.sting);
                    imgAnh.setImageDrawable(img);
                } else if (sp.getMa() == 103){
                    img = AppCompatResources.getDrawable(MainActivity2.this, R.drawable.samsung);
                    imgAnh.setImageDrawable(img);
                } else if (sp.getMa() == 104){
                    img = AppCompatResources.getDrawable(MainActivity2.this, R.drawable.stinglon);
                    imgAnh.setImageDrawable(img);
                } else if (sp.getMa() == 105){
                    img = AppCompatResources.getDrawable(MainActivity2.this, R.drawable.coca);
                    imgAnh.setImageDrawable(img);
                } else /*if (sp.getMa() == 106)*/{
                    img = AppCompatResources.getDrawable(MainActivity2.this, R.drawable.vertu);
                    imgAnh.setImageDrawable(img);
                }
            }
        });
    }

    private void hamDieuKhien() {
        txtMa = findViewById(R.id.txtMa);
        txtTen = findViewById(R.id.txtTen);
        txtGia = findViewById(R.id.txtGia);
        btnXemAnh = findViewById(R.id.btnXemAnh);
        btnTroVe = findViewById(R.id.btnTroVe);
        btnXoa = findViewById(R.id.btnXoa);
        imgAnh = findViewById(R.id.imgAnh);
        intent = getIntent();
        sp = (SanPham) intent.getSerializableExtra("a");
        txtMa.setText(sp.getMa()+"");
        txtTen.setText(sp.getTen());
        txtGia.setText(sp.getGia());

    }
}