package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleSecondActivity extends AppCompatActivity {
    Button btnFirstLifeCycle;
    Button btnExit; // Declare the exit button
    TextView tvYourPhone, tvEmail;



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activitylifecyclesecond);

        // Initialize buttons
        btnFirstLifeCycle = findViewById(R.id.btnFirstLifeCylce);
        tvYourPhone = findViewById(R.id.tvYourPhone);
        tvEmail = findViewById(R.id.tvEmail);

        //lấy dữ liệu từ activity khác
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            String phone =  bundle.getString("MY_PHONE","");
            tvYourPhone.setText(phone);
            String email = bundle.getString("MY_EMAIL","");
            tvEmail.setText(email);
        }

        //btnExit = findViewById(R.id.btnExit); // Initialize the exit button

        // Set click listener for the first button
        btnFirstLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifeCycleSecondActivity.this, LifeCycleSecondActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the exit button
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Close the app completely
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Custom logic or cleanup code here
        Log.d("LifeCycleSecondActivity", "onDestroy called - Activity is being destroyed.");
    }
}
