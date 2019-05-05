package com.example.fjnu.fdd.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button bt;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentlayout);
        bt=(Button)findViewById(R.id.btn);
        et=(EditText)findViewById(R.id.et);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url="http://"+et.getText().toString();
                intent.putExtra("url",url);
                Intent choose=Intent.createChooser(intent,"选择一个浏览器");
                startActivity(intent);
            }
        });
    }
}
