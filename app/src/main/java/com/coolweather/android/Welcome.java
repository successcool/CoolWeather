package com.coolweather.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Welcome extends AppCompatActivity {
    protected LinearLayout left;
    protected LinearLayout right;
    protected LinearLayout animLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*//隐藏标题栏
        getSupportActionBar().hide();
//隐藏系统状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//显示系统状态栏//
// getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        setContentView(R.layout.activity_welcome);
        init();
    }
    private void init(){
        left=(LinearLayout)findViewById(R.id.left);
        right=(LinearLayout)findViewById(R.id.right);
        animLayout=(LinearLayout)findViewById(R.id.animLayout);
        animLayout.setBackgroundResource(R.drawable.klpe);
        Animation leftOutAnimation= AnimationUtils.loadAnimation(
                getApplicationContext(),R.anim.translate_left);
        Animation rightOutAnimation= AnimationUtils.loadAnimation(
                getApplicationContext(),R.anim.translate_right);
        left.setAnimation(leftOutAnimation);
        right.setAnimation(rightOutAnimation);
        leftOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                left.setVisibility(android.view.View.GONE);
                right.setVisibility(android.view.View.GONE);
                Intent intent=new Intent();
                intent.setClass(Welcome.this,Access.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                Welcome.this.finish();
            }

        });
    }
}