package com.example.campusexpensese06205;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DemoIntentActivity extends AppCompatActivity {
    EditText edtUrl, edtPhone;
    Button btnUrl,btnPhone;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent);
        edtUrl = findViewById(R.id.edtUrl);
        btnUrl = findViewById(R.id.btnUrl);
        btnPhone = findViewById(R.id.btnPhone);
        edtPhone = findViewById(R.id.edtPhone);

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    edtPhone.setError("Phone number can not empty");
                    return;
                }
                Intent intent = new Intent( Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+phone));
                if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }else {
                    requestPermissions(new String[]{CALL_PHONE},1);
                }
            }
        });
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtUrl.getText().toString().trim();
                if (TextUtils.isEmpty(url)) {
                    edtUrl.setError("URL can be not empty");
                    return;

                }
                // xử lý load noi dung trang
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
