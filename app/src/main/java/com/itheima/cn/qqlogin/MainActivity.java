package com.itheima.cn.qqlogin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private CheckBox cb_remberMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去掉AppCompatActivity的标题栏
        // requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉继承activity的标题栏
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("login", 0);

        et_username=findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        cb_remberMemory = findViewById(R.id.cb_remberMemory);

        //        //获取保存的用户名密码
//        Map<String,String> maps=UserInforUtils.readInfor(MainActivity.this);
//        if(maps!=null){
//            String username=maps.get("username");
//            String password=maps.get("password");

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        Boolean ischeck = sharedPreferences.getBoolean("ischeck", false);

        et_username.setText(username);
        et_password.setText(password);
        cb_remberMemory.setChecked(ischeck);
//    }

    }

    //按钮的点击事件
    public void Login(View view) {
        //获取用户名和密码
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        boolean ischeck = cb_remberMemory.isChecked();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "用户名或密码不能为空！", Toast.LENGTH_LONG).show();
        } else {
            //进行登录的逻辑
            System.out.println("等待后续学习！");

            if (ischeck) {
//                //将用户名对应的密码存起来（用户名和密码一定要相对应）
////                boolean result=UserInforUtils.saveInfor(MainActivity.this,username,password);
////                if(result){
////                    Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();
////                }else{
////                    Toast.makeText(MainActivity.this,"保存失败",Toast.LENGTH_LONG).show();
////                }
                SharedPreferences sharedPreferences = getSharedPreferences("login", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.putBoolean("ischeck", ischeck);
                editor.commit();

            }

        }

    }

}
