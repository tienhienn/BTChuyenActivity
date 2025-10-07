package com.example.btchuyenactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    Button btnDangNhap;
    EditText edtTaiKhoan, edtMatKhau;

    private final String userNameDefault = "tienhien2410";
    private final String passwordDefault = "huynhletienhien";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        btnDangNhap = findViewById(R.id.btnDangNhap);
        edtMatKhau = findViewById(R.id.edtPassword);
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edtTaiKhoan.getText().toString().trim();
                String password = edtMatKhau.getText().toString().trim();

                if(userName.equals(userNameDefault) && password.equals(passwordDefault)){

                    Bundle bundle = new Bundle();
                    bundle.putString("username", userName);
                    bundle.putString("password",password);

                    Intent intent = new Intent(LoginActivity.this,ProfileActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}