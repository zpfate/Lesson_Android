package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    static final String TAG = "fate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /// textView
//        setContentView(R.layout.activity_main);
//        TextView tv_one = findViewById(R.id.tv_one);
//        tv_one.setText("leo");

        createEditText();
    }


    public void createEditText() {
        setContentView(R.layout.edit_text);
        EditText editText = findViewById(R.id.edittext);
        Button btn = findViewById(R.id.getBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Log.e(TAG, "onClick: 输入的内容： " + text );
            }
        });
    }


    public void createBtn() {
        /// 按钮
        setContentView(R.layout.button);

        Button btn = findViewById(R.id.btn);
//        // 点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG,"onClick");
            }
        });
        /// 长按事件
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.e(TAG,"onLongClick");
                return false;
            }
        });
        /// 触摸事件
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e(TAG,"onTouch" + motionEvent.getAction());
                /// return true会消费事件
                return false;
            }
        });
    }


    public void onClick(View view) {
        Log.e(TAG,"onClick");
    }
}