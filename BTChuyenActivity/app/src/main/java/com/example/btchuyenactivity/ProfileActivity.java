package com.example.btchuyenactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    TextView edtUsername, edtPassword, edtName, edtEmail, edtPhone;
    ImageView btnSetting;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profileLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtUsername = findViewById(R.id.edtTenDangNhap);
        edtPassword = findViewById(R.id.edtMatKhau);
        edtName = findViewById(R.id.edtTen);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtSoDienThoai);
        btnSetting = findViewById(R.id.btnSetting);

        // Nhận dữ liệu bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String username = bundle.getString("username");
            String password = bundle.getString("password");

            edtUsername.setText(username);
            edtPassword.setText(password);
        }

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}