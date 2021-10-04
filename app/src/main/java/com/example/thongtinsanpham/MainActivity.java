package com.example.thongtinsanpham;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.model.SanPham;

public class MainActivity extends AppCompatActivity {
    TextView txtTitle;
    Button btnThem;
    ListView lvSanPham;
    ArrayAdapter<SanPham> sanPhamArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hamDieuKhien();
        hamSuKien();
    }

    private void hamSuKien() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamArrayAdapter.getItem(i);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("a",sp);
                startActivityForResult(intent, 1);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivityForResult(intent, 8);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            boolean isXoa = data.getBooleanExtra("xoa", false);
            SanPham spXoa = (SanPham) data.getSerializableExtra("sp");
            for (int i = 0; i < sanPhamArrayAdapter.getCount(); i++){
                SanPham sp = sanPhamArrayAdapter.getItem(i);
                if (sp.getTen().equals(spXoa.getTen())){
                    sanPhamArrayAdapter.remove(sp);
                    break;
                }
            }
        }
    }

    private void hamDieuKhien() {
        lvSanPham = findViewById(R.id.lvSanPham);
        btnThem = findViewById(R.id.btnThem);
        txtTitle = findViewById(R.id.txtTitle);
        sanPhamArrayAdapter = new ArrayAdapter<SanPham>(
                MainActivity.this, android.R.layout.simple_list_item_1);
        lvSanPham.setAdapter(sanPhamArrayAdapter);
        sanPhamArrayAdapter.add(new SanPham(101, "iPhone", "40.000.000đ"));
        sanPhamArrayAdapter.add(new SanPham(102, "Sting (chai)", "10.000đ"));
        sanPhamArrayAdapter.add(new SanPham(103, "Samsung", "30.000.000đ"));
        sanPhamArrayAdapter.add(new SanPham(104, "Sting (lon)", "10.000đ"));
        sanPhamArrayAdapter.add(new SanPham(105, "Coca Cola", "10.500đ"));
        sanPhamArrayAdapter.add(new SanPham(106, "Vertu", "215.000.000đ"));

    }
}