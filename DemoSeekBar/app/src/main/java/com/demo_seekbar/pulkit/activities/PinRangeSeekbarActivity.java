package com.demo_seekbar.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo_seekbar.pulkit.R;
import com.xw.repo.BubbleSeekBar;

public class PinRangeSeekbarActivity extends AppCompatActivity {

    private static final String TAG = PinRangeSeekbarActivity.class.getName();

    private BubbleSeekBar bubbleSeekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_range_seekbar);

        findIds();
        init();
    }

    private void findIds() {

        bubbleSeekBar = findViewById(R.id.pin_seekbar);
        textView = findViewById(R.id.text_view);
    }

    private void init() {

        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                textView.setText(String.format("on Change %d ", progress));
            }

            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {

            }

            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {

            }
        });

    }

}
