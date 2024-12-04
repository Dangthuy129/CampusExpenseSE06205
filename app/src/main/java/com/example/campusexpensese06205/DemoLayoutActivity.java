package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoLayoutActivity extends AppCompatActivity {
    Button buttonLogin;
    Button buttonCancel;
    EditText edtUser,edtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_demo);
        //anh xa view
        buttonLogin = findViewById(R.id.btnLogin);
        edtUser = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoLayoutActivity.this, "Click me, done",
                        Toast.LENGTH_LONG).show();
                // lay du lieu ng dùng
                String username = edtUser.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    edtUser.setError("Username can be not emty");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    edtUser.setError("Password can be not emty");
                    return;
                }
                if (username.equals("hgvu") && password.equals("123")){
                    Intent intent = new Intent(DemoLayoutActivity.this,MainActivity.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(DemoLayoutActivity.this, "Account Invalid",
                            Toast.LENGTH_LONG).show();

                }
            }
        });
        buttonCancel = findViewById(R.id.btnCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoLayoutActivity.this,"Goodbye",
                        Toast.LENGTH_LONG).show();


    }
});
    }
}
