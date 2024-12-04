package com.example.campusexpensese06205;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.campusexpensese06205.database.UserDb;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class RegisterActivity extends AppCompatActivity {
    TextView tvLogin;
    EditText edtUser, edtPass, edtEmail, edtPhone, edtAddress;
    Button btnSignup;
    UserDb userDb;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_register);
        tvLogin = findViewById(R.id.tvLogin);
        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone= findViewById(R.id.edtPhone);
        edtAddress= findViewById(R.id.edtAddress);
        btnSignup = findViewById(R.id.btnRegister);
        userDb = new UserDb(RegisterActivity.this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupWithDatabase();
            }
        });


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }

        });

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void signupWithDatabase(){
        String user = edtUser.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        if(TextUtils.isEmpty(user)){
            edtUser.setError("Username not empty");
            return;
        }
        if(TextUtils.isEmpty(pass)){
            edtPass.setError("Password not empty");
            return;
        }
        if(TextUtils.isEmpty(email)){
            edtEmail.setError("Email not empty");
            return;
        }
        if(TextUtils.isEmpty(phone)){
            edtPhone.setError("Phone not empty");
            return;
        }
        long insert = userDb.addNewAccountUser(user, pass, email, phone, address);
        if(insert == -1){
            //loi khong insert duoc
            Toast.makeText(RegisterActivity.this, "Create Failure", Toast.LENGTH_SHORT).show();
        }else{
            //thanh cong
            Toast.makeText(RegisterActivity.this, "Create Successfully", Toast.LENGTH_SHORT).show();
            Intent intentLogin = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intentLogin);
        }
    }
    private void signupWithDataFile(){
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if(TextUtils.isEmpty(user)){
                    edtUser.setError("Username can be not empty");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    edtPass.setError("Password can be not empty");
                    return;
                }
                //Tiến hành lưu data vào local stroge
                //

                FileOutputStream fileOutputStream = null;
                try {
                    user = user + "|"; // ngan cach user vaf pass
                    fileOutputStream = openFileOutput("account.txt", Context.MODE_APPEND);
                    fileOutputStream.write(user.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write(pass.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write('\n');
                    fileOutputStream.close();
                    edtPass.setText("");
                    edtUser.setText("");
                    Toast.makeText(RegisterActivity.this,"Successfully",Toast.LENGTH_LONG).show();


                }catch ( Exception exception){
                    exception.printStackTrace();
                }

            }
        });
    }
}
