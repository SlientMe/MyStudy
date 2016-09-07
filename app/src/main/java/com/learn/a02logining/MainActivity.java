package com.learn.a02logining;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    EditText password;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.remember)
    CheckBox remember;
    @InjectView(R.id.et_name)
    EditText etName;
    @InjectView(R.id.et_password)
    EditText etPassword;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayouy);
        TextView tv;
        ButterKnife.inject(this);
        sharedPreferences = getSharedPreferences("my",MODE_PRIVATE);

        Map<String, String> maps = UserInfoUtils.readInfo();

        if (maps != null) {
            String name = maps.get("name");
            String pwd = maps.get("pwd");

        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myname = etName.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (TextUtils.isEmpty(myname) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    //登录
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                    if (remember.isChecked()) {
                        try {
                            boolean result = UserInfoUtils.saveInfo(MainActivity.this,myname, pass);
                            if (result) {
                                Toast.makeText(MainActivity.this, "保存数据成功", Toast.LENGTH_SHORT).show();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });


    }
}
