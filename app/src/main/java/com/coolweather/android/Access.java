package com.coolweather.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Access extends Activity {
    private TextView textTime;
    private TextView jump;
    public static final int FLAG = 0;
    public int time = 5;

    private Button access;
    private SharedPreferences sp=null;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case FLAG:
                    textTime.setText(String .valueOf(time));
                    time = time-1;
                    if (time < 0){
                        startMainActivity();
                    }else {
                        sendEmptyMessageDelayed(FLAG,1000);
                    }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_access);
        access=(Button)findViewById(R.id.access);
        textTime = (TextView) findViewById(R.id.time);
        jump = (TextView) findViewById(R.id.jump);
        Message msg = new Message();
        msg.what = FLAG;
        handler.sendMessage(msg);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();

            }
        });
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();

            }
        });
    }
    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}


