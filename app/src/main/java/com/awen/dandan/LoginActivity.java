package com.awen.dandan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Bean.UserNP;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login,register;
    private EditText mName,mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this,"85f338a6aa85ce35bd06256f49f0f7a3");
        init();
        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    private void init() {
        login= (Button) findViewById(R.id.login);
        register= (Button) findViewById(R.id.register);
        mName= (EditText) findViewById(R.id.emailAddress);
        mPassword= (EditText) findViewById(R.id.password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                String str=mName.getText().toString();
                BmobQuery<UserNP> bmobQuery = new BmobQuery<>();
                bmobQuery.addWhereEqualTo("name",str);
                bmobQuery.findObjects(new FindListener<UserNP>() {
                    @Override
                    public void done(List<UserNP> list, BmobException e) {
                        for (UserNP userNp:list){
                            String psw=mPassword.getText().toString();
                            if (userNp.getPassword().equals(psw)){
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                Intent it=new Intent(LoginActivity.this,MainActivity.class);
                                it.putExtra("userName",mName.getText().toString());
                                startActivity(it);
                            }
                        }
                    }
                });
                break;
            case R.id.register:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
