package com.example.finalexam07560477;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private Button button;
    private Button loginBtn;
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.username_edit_text);
        mTextPassword = (EditText)findViewById(R.id.password_edit_text);

        button = (Button) findViewById(R.id.register_button);
        loginBtn = (Button) findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity_register();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onSubmit();
            }
        });


    }
    public void  activity_register(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void onSubmit(){
        String user = mTextUsername.getText().toString().trim();
        String pwd = mTextPassword.getText().toString().trim();
        Boolean res = db.checkUser(user, pwd);
        if(res == true)
        {
             Toast.makeText(this,"Wellcome",Toast.LENGTH_LONG);

        }
        else
        {
            Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
        }


    }
}