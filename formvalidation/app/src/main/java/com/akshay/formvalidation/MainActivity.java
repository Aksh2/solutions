package com.akshay.formvalidation;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.nameEt)
    AppCompatEditText nameEt;

    @BindView(R.id.phoneEt)
    AppCompatEditText phoneEt;

    @BindView(R.id.emailEt)
    AppCompatEditText emailEt;

    @BindView(R.id.validateBtn)
    Button validateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        validateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.validateBtn:
                validateForm();
                break;
        }
    }

    public void validateForm(){
        if(nameEt.getText().toString().trim().isEmpty()){
            nameEt.setError(getResources().getString(R.string.field_blank_error_msg));
            changeEtColor(nameEt);

        }else {
            changeEtColorAccent(nameEt);
            nameEt.setError(null);
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(nameEt.getText().toString().trim());
        boolean containsOtherChar=matcher.matches();
       if(containsOtherChar==false){
           nameEt.setError(getResources().getString(R.string.name_error_msg));
           changeEtColor(nameEt);
       }

        if(phoneEt.getText().toString().trim().isEmpty()){
            phoneEt.setError(getResources().getString(R.string.field_blank_error_msg));
            changeEtColor(phoneEt);

        }
        if(phoneEt.getText().toString().trim().length()>10 || phoneEt.getText().toString().trim().length()<10){
            phoneEt.setError(getResources().getString(R.string.number_error_msg));
            changeEtColor(phoneEt);

        }else {
            changeEtColorAccent(phoneEt);
            phoneEt.setError(null);
        }

        if(emailEt.getText().toString().trim().isEmpty()){
            emailEt.setError(getResources().getString(R.string.field_blank_error_msg));
            changeEtColor(emailEt);

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailEt.getText().toString().trim()).matches()){
            emailEt.setError(getResources().getString(R.string.email_error_msg));
            changeEtColor(emailEt);
        }else {
            changeEtColorAccent(emailEt);
            emailEt.setError(null);
        }


    }

    @SuppressLint("RestrictedApi")
    public void changeEtColor(AppCompatEditText editText){
        ColorStateList colorStateList = ColorStateList.valueOf(Color.RED);
        editText.setSupportBackgroundTintList(colorStateList);
    }

    @SuppressLint("RestrictedApi")
    public void changeEtColorAccent(AppCompatEditText editText){
        ColorStateList colorStateList = ColorStateList.valueOf(Color.BLACK);
        editText.setSupportBackgroundTintList(colorStateList);
    }
}
