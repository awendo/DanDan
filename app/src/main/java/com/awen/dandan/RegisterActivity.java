package com.awen.dandan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Bean.UserNP;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    private Button register;
    private EditText name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister);
        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText())||TextUtils.isEmpty(password.getText())){
                    Toast.makeText(RegisterActivity.this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterActivity.this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
                    UserNP user=new UserNP();
                    user.setName(name.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            Intent it=new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(it);
                        }
                    });

                }
            }
        });

    }

    private void init() {
        register= (Button) findViewById(R.id.rRegister);
        name= (EditText) findViewById(R.id.rEmailAddress);
        password= (EditText) findViewById(R.id.rPassword);
    }
}
