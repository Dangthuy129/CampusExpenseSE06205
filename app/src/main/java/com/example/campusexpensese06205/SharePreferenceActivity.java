package com.example.campusexpensese06205;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharePreferenceActivity extends AppCompatActivity {
    EditText edtNumber1, edtNumber2,edtResult;
    Button btnCaculate, btnClear;
    TextView tvHistory;
    private String history =" ";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);
        edtNumber1=findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        edtResult = findViewById(R.id.edtResult);
        btnCaculate= findViewById(R.id.btnCaculate);
        btnClear= findViewById(R.id.btnClear);
        tvHistory=findViewById(R.id.tvHistory);
        edtResult.setEnabled(false);

        //lay du lieu tue SHAREPREFERENCE
        SharedPreferences shares = getSharedPreferences("CaculateMath",MODE_PRIVATE);
        history = shares.getString("historyMath","");
        tvHistory.setText(history); //xem lai lich su thao tac

        btnCaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long number1 = Integer.parseInt(edtNumber1.getText().toString().trim());
                long number2 = Integer.parseInt(edtNumber2.getText().toString().trim());
               long result = number1 + number2;
                edtResult.setText(String.valueOf(result));
                history += number1+ "+" + number2+ "=" + result;
                tvHistory.setText(history);
                edtNumber1.setText("");
                edtNumber2.setText("");
                history +="\n";
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = "";
                tvHistory.setText(history);
                edtNumber1.setText("");
                edtNumber2.setText("");
                edtResult.setText("");

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //xu ly luu du lieu
        SharedPreferences myPrefs = getSharedPreferences("CaculateMath",MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("historyMath", history);
        editor.apply();
    }
}
