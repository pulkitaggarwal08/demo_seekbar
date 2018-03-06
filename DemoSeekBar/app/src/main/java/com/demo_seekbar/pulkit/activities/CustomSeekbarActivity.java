package com.demo_seekbar.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.demo_seekbar.pulkit.R;

public class CustomSeekbarActivity extends AppCompatActivity {

    private static final String TAG = CustomSeekbarActivity.class.getName();

    private SeekBar customSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_seekbar);

        findIds();
        init();
    }

    private void findIds() {

        customSeekbar = findViewById(R.id.custom_seekbar);
    }

    private void init() {

        customSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                Toast.makeText(CustomSeekbarActivity.this, "Seekbar vale " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CustomSeekbarActivity.this, "Seekbar touch started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CustomSeekbarActivity.this, "Seekbar touch stopped", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
