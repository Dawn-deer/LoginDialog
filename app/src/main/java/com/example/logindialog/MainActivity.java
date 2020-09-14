package com.example.logindialog;

import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    AlertDialog dialog;
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        final View view1 = inflater.inflate(R.layout.login, null);



        view1.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText edittxt_name = (EditText) view1.findViewById(R.id.editText);
                final EditText edittxt_password = (EditText) view1.findViewById(R.id.editText2);
                if (edittxt_name.getText().toString().equals("abc") && edittxt_password.getText().toString().equals("123")) {
                    dialog.cancel();
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "错误的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view1.findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();

            }
        });
        dialog = builder.setCancelable(false).setView(view1).show();
    }
}


