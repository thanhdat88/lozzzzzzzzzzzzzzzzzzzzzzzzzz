package com.example.quanlydiemsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnQLSV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQLSV = findViewById(R.id.btnQLSV);
        btnQLSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.add_sinhvien);
                Intent i = new Intent(MainActivity.this,TODO_QLSV.class);
                startActivity(i);

            }
        });

    }


}
