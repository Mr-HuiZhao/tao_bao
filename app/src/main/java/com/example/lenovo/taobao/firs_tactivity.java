package com.example.lenovo.taobao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Lenovo on 2016/10/26.
 */

public class firs_tactivity extends AppCompatActivity {
    private LinearLayout ll;
    private TextView tv;
    private boolean first = true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout)findViewById(R.id.first_page_skip);
        tv = (TextView)findViewById(R.id.first_text);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAt();
            }
        });

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startAt();
        }
        };
        timer.schedule(task, 5000);
    }
    private void startAt(){
        if(first){
            Intent intent = new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pinghua,R.anim.pinghua);
            first = false;
            finish();
        }
    }

}
