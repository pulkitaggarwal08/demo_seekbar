package com.demo_seekbar.pulkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo_seekbar.pulkit.activities.AnimatedPinSeekbarActivity;
import com.demo_seekbar.pulkit.activities.BubbleRangeSeekbarActivity;
import com.demo_seekbar.pulkit.activities.CustomSeekbarActivity;
import com.demo_seekbar.pulkit.activities.PinRangeSeekbarActivity;
import com.demo_seekbar.pulkit.activities.SimpleRangeSeekbarActivity;
import com.demo_seekbar.pulkit.activities.SimpleSeekbarActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnSimpleSeekbar, btnSimpleRangeSeekbar, btnPinSeekbar, btnAnimatedPinSeekbar, btnCustomSeekbar,
            btnBubbleRangeSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();

    }

    private void findIds() {

        btnSimpleSeekbar = findViewById(R.id.btn_simple_seekbar);
        btnSimpleRangeSeekbar = findViewById(R.id.btn_simple_range_seekbar);
        btnPinSeekbar = findViewById(R.id.btn_pin_seekbar);
        btnAnimatedPinSeekbar = findViewById(R.id.btn_animated_pin_seekbar);
        btnCustomSeekbar = findViewById(R.id.btn_custom_seekbar);
        btnBubbleRangeSeekbar = findViewById(R.id.btn_bubble_range_seekbar);
    }

    private void init() {

        btnSimpleSeekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SimpleSeekbarActivity.class);
                startActivity(intent);
            }
        });

        btnSimpleRangeSeekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SimpleRangeSeekbarActivity.class);
                startActivity(intent);
            }
        });

        btnPinSeekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PinRangeSeekbarActivity.class);
                startActivity(intent);
            }
        });

        btnAnimatedPinSeekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AnimatedPinSeekbarActivity.class);
                startActivity(intent);
            }
        });

        btnCustomSeekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CustomSeekbarActivity.class);
                startActivity(intent);
            }
        });

        btnBubbleRangeSeekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), BubbleRangeSeekbarActivity.class);
                startActivity(intent);
            }
        });
    }


}
