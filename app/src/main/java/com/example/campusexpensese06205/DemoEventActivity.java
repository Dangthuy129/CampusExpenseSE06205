package com.example.campusexpensese06205;

import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoEventActivity extends AppCompatActivity {
    EditText edtData;
    CheckBox cbAgree;
    TextView tvTitle, tvCountText;
    Button btnClickMe;
    RadioGroup radgAddress;
    RadioButton radHanoi, radNghean, radHatinh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_layout);
        edtData = findViewById(R.id.adtData);
        cbAgree = findViewById(R.id.cbAgree);
        tvTitle = findViewById(R.id.tvTitle);
        tvCountText = findViewById(R.id.tvTitle);
        btnClickMe = findViewById(R.id.btnClickMe);
        radgAddress = findViewById(R.id.radgAddress);
        radHanoi = findViewById(R.id.radHanoi);
        radNghean = findViewById(R.id.radNghean);
        radHatinh = findViewById(R.id.radHatinh);
        //block edittext
        edtData.setEnabled(false);
        //bat su kien ng dung tich chon
        cbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    //tiich chon
                    edtData.setEnabled(true);
                } else {
                    //ko tich chon
                    edtData.setEnabled(false);
                }
            }
        });

        //su kien onchange Edittext
        edtData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvCountText.setText(String.valueOf(i2));

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String data = editable.toString();
                int countData = data.length();
                tvTitle.setText(data);
                tvCountText.setText(String.valueOf(countData));

            }
        });
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radgAddress.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String address = radioButton.getText().toString().trim().toLowerCase();
                if (address.equals("ha noi")){
                    edtData.setEnabled(true);
                }else {
                    edtData.setEnabled(false);
                }
                Toast.makeText(DemoEventActivity.this,address,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
