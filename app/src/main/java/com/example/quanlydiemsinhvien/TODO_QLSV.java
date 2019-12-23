package com.example.quanlydiemsinhvien;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlydiemsinhvien.adapter.AdapterSinhVien;
import com.example.quanlydiemsinhvien.config.ApiManager;
import com.example.quanlydiemsinhvien.config.NetworkProvider;
import com.example.quanlydiemsinhvien.model.StudentDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TODO_QLSV extends AppCompatActivity {
    private Button btnSave;
    private Button btnClear;
    private Button btnSearch;
    private EditText edtTen, edtQuequan, edtNamsinh, edtMaSV;
    private static ArrayList<StudentDTO> listResult = new ArrayList<>();
    ProgressDialog progressDoalog;
    private Button btnXoa;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sinhvien);

        //anh xa
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        edtMaSV = findViewById(R.id.edtMaSV);
        btnXoa = findViewById(R.id.btnXoa);
        edtTen = findViewById(R.id.edtTen);
        edtNamsinh = findViewById(R.id.edtNamsinh);
        edtQuequan = findViewById(R.id.edtQuequan);
        ArrayList<StudentDTO> list = doSearch();
        ListView listView = findViewById(R.id.listView);
        AdapterSinhVien adapterSinhVien = new AdapterSinhVien(this, list);
        listView.setAdapter(adapterSinhVien);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetView();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Xác nhân thêm mới", "Bạn có muốn thêm mới không?").show();
            }
        });


    }


    public void resetView() {
        edtTen.setText("");
        edtQuequan.setText("");
        edtNamsinh.setText("");
    }

    public ArrayList<StudentDTO> doSearch() {
        StudentDTO objj = new StudentDTO();
        if(null!=edtQuequan){
            objj.setStudentAdress(edtQuequan.getText().toString());
        }
        ApiManager apiService = NetworkProvider.getClient().create(ApiManager.class);
        apiService.doSearch(objj)
                .enqueue(new Callback<ArrayList<StudentDTO>>() {
                    @Override
                    public void onResponse(Call<ArrayList<StudentDTO>> call, Response<ArrayList<StudentDTO>> response) {
                        listResult = response.body();

                    }

                    @Override
                    public void onFailure(Call<ArrayList<StudentDTO>> call, Throwable t) {
                        listResult = null;
                    }
                });
        return listResult;
    }

    public AlertDialog dialog(String title, String message) {
        return new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StudentDTO obj = new StudentDTO("D15CQAT03", edtQuequan.getText().toString(), edtNamsinh.getText().toString(), edtMaSV.getText().toString(), "longlkjr977@gmail.com", edtTen.getText().toString());
                        ApiManager apiService = NetworkProvider.getClient().create(ApiManager.class);
                        apiService.save(obj).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                ArrayList<StudentDTO> list = doSearch();
                                ListView listView = findViewById(R.id.listView);
                                AdapterSinhVien adapterSinhVien = new AdapterSinhVien(TODO_QLSV.this, list);
                                listView.setAdapter(adapterSinhVien);
                                Toast.makeText(TODO_QLSV.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Toast.makeText(TODO_QLSV.this, "Thêm mới có lỗi", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }).setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(TODO_QLSV.this, "Hủy", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
    }

}
