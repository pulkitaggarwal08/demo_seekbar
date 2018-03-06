package com.demo_seekbar.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo_seekbar.pulkit.R;
import com.demo_seekbar.pulkit.range_seekbar.RangeSeekBar;

import java.text.DecimalFormat;

public class BubbleRangeSeekbarActivity extends AppCompatActivity {

    private RangeSeekBar bubbleSimpleSeekbar, bubbleRangeSeekbar;
    private TextView tvProgress;
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_range_seekbar);

        findIds();
        init();

    }

    private void findIds() {

        bubbleSimpleSeekbar = findViewById(R.id.bubble_simple_seekbar);
        bubbleRangeSeekbar = findViewById(R.id.bubble_range_seekbar);
        tvProgress = findViewById(R.id.tv_progress);
    }

    private void init() {

        bubbleSimpleSeekbar.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {
                bubbleRangeSeekbar.setProgressDescription((int) min + "%");
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });

        bubbleRangeSeekbar.setValue(-0.5f, 0.8f);
        bubbleRangeSeekbar.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float min, float max, boolean isFromUser) {

                tvProgress.setText(min + "-" + max);
                bubbleRangeSeekbar.setLeftProgressDescription(decimalFormat.format(min));
                bubbleRangeSeekbar.setRightProgressDescription(decimalFormat.format(max));

            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });


    }

}
