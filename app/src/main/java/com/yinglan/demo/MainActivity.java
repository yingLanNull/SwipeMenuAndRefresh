package com.yinglan.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by yinglan
 */
public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private LinearLayout activitymain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activitymain = (LinearLayout) findViewById(R.id.activity_main);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OrdinaryActivity.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UnlimitHighActivity.class));
            }
        });
    }
}
