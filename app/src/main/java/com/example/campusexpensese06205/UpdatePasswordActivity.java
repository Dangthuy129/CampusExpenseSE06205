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

import com.example.campusexpensese06205.database.UserDb;

public class UpdatePasswordActivity extends AppCompatActivity {

    EditText edtNewPassword, edtConfirmPassword;
    Button btnUpdatePassword;
    UserDb userDb;
    Intent intent;
    Bundle bundle;
    private String username;
    private String email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        edtNewPassword = findViewById(R.id.edtNewpassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnUpdatePassword = findViewById(R.id.btnUpdate);
        userDb = new UserDb(UpdatePasswordActivity.this);
        intent = getIntent();
        bundle = intent.getExtras();

        if (bundle != null){
            username = bundle.getString("USERNAME_ACCOUNT", "");
            email = bundle.getString("EMAIL_ACCOUNT", "");
        }
        updatePassword();
    }
    private void updatePassword(){
        btnUpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = edtNewPassword.getText().toString().trim();
                String confirmPassword = edtConfirmPassword.getText().toString().trim();
                if(TextUtils.isEmpty(newPassword)){
                    edtNewPassword.setError("Password is not empty");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    edtConfirmPassword.setError("Confirm password is not empty");
                    return;
                }
                if(!confirmPassword.equals(newPassword)){
                    edtConfirmPassword.setError("Confirm password not equals new password");
                    return;
                }
                int update = userDb.updatePassword(newPassword, username, email);
                if(update == -1){
                    //loi khong update duoc
                    Toast.makeText(UpdatePasswordActivity.this, "Update Failure!!!", Toast.LENGTH_SHORT).show();
                }else{
                    //thanh cong
                    Toast.makeText(UpdatePasswordActivity.this, "Update Successfully!!!", Toast.LENGTH_SHORT).show();
                    // chuyen ve trang dang nhap
                    Intent intentLogin = new Intent(UpdatePasswordActivity.this, LoginActivity.class);
                    startActivity(intentLogin);
                    finish();
                }
            }
        });
    }
}
