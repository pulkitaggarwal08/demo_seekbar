package com.demo_seekbar.pulkit.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.demo_seekbar.pulkit.R;

/**
 * Created by pulkit on 18/1/18.
 */

public class SimpleSeekbarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final String TAG = SimpleSeekbarActivity.class.getName();

    private SeekBar simpleSeekbar;
    private TextView tvSeekbarValue1, tvSeekbarValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_seekbar);

        findIds();
        init();
    }

    private void findIds() {

        simpleSeekbar = findViewById(R.id.simple_seekbar);
        tvSeekbarValue1 = findViewById(R.id.tv_seekbar_value1);
        tvSeekbarValue2 = findViewById(R.id.tv_seekbar_value2);

    }

    private void init() {

        simpleSeekbar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar.getId() == R.id.simple_seekbar) {

            String seekbarProgress = String.valueOf(seekBar.getProgress());

            tvSeekbarValue1.setText(seekbarProgress);

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.i(TAG, "onStartTrackingTouch: ");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.i(TAG, "onStopTrackingTouch: ");
    }


}
