package com.demo_seekbar.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo_seekbar.pulkit.R;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

public class AnimatedPinSeekbarActivity extends AppCompatActivity {

    private DiscreteSeekBar discreteNormal;
    private DiscreteSeekBar discreteMultiple;
    private DiscreteSeekBar discreteMultipleRange;
    private DiscreteSeekBar discreteIntervalMultipleRange;

    private TextView titleNormal;
    private TextView titleMultiple;
    private TextView titleRangeMultiple;
    private TextView titleIntervalRangeMultiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_pin_seekbar);

        findIds();
        init();
    }

    private void findIds() {

        discreteNormal = findViewById(R.id.discrete_normal);
        discreteMultiple = findViewById(R.id.discrete_multiple);
        discreteMultipleRange = findViewById(R.id.discrete_multiple_range);
        discreteIntervalMultipleRange = findViewById(R.id.discrete_interval_multiple_range);

        titleNormal = findViewById(R.id.title_normal);
        titleMultiple = findViewById(R.id.title_multiple);
        titleRangeMultiple = findViewById(R.id.title_range_multiple);
        titleIntervalRangeMultiple = findViewById(R.id.title_interval_range_multiple);
    }

    private void init() {

        initSeekBar(); // normal seek bar bar 0 to 100
        initMultipleOfSeekBar();   // multiple of 100 form 0 to 10000
        initMultipleRangeOfSeekBar();  // multiple of 100 form 500 to 10000
        initIntervalMultipleRangeOfSeekBar();   // multiple of 100 form 500 to 1000 and after multiple of 1000 from 1000 to 10000
    }

    private void initSeekBar() {
        discreteNormal.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                titleNormal.setText("Normal SeekBar- Value: " + value);
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
    }

    private void initMultipleOfSeekBar() {
        discreteMultiple.setMin(0);
        discreteMultiple.setMax(100);  //result should be in multiple of 100
        discreteMultiple.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                return value * 100;
            }
        });

        discreteMultiple.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                titleMultiple.setText("Multiple SeekBar- Value: " + value * 100);
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
    }

    private void initMultipleRangeOfSeekBar() {

        discreteMultipleRange.setMin(0);
        discreteMultipleRange.setMax(95);
        discreteMultipleRange.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                return (value * 100) + 500;
            }
        });

        discreteMultipleRange.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                if (fromUser) {
                    int updatedValue = (value * 100) + 500;
                    titleRangeMultiple.setText("Multiple Range SeekBar- Value: " + updatedValue);
                }
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
    }

    private void initIntervalMultipleRangeOfSeekBar() {
        discreteIntervalMultipleRange.setMin(0);
        discreteIntervalMultipleRange.setMax(14);
        discreteIntervalMultipleRange.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                if (value <= 5) {
                    return (value * 100) + 500;
                } else {
                    return (value - 4) * 1000;
                }
            }
        });

        discreteIntervalMultipleRange.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                if (fromUser) {
                    int updatedValue = 0;
                    if (value <= 5) {
                        updatedValue = (value * 100) + 500;
                    } else {
                        updatedValue = (value - 4) * 1000;
                    }
                    titleIntervalRangeMultiple.setText("Interval Multiple Range SeekBar- Value: " + updatedValue);
                }
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
    }


}
