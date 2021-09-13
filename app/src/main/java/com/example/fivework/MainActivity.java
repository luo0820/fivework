package com.example.fivework;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.SharedPreferences;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  static  final String userno="myfile1";

    private  static  final  String name="username";
    private  static  final  String no="userno";
    String str="";
    Button bt1,bt2;
    EditText text;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        text=findViewById(R.id.edit);

        SharedPreferences preferences=getPreferences(MODE_PRIVATE);;
        SharedPreferences.Editor editor=preferences.edit();






        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                str=text.getText().toString();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(name,str);
                editor.commit();
                str="";
                Toast.makeText(MainActivity.this,"保存成功！！",Toast.LENGTH_LONG).show();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=preferences.getString(name,null);
                Toast.makeText(MainActivity.this,"读取信息为："+str,Toast.LENGTH_LONG).show();
            }
        });


    }


    
}