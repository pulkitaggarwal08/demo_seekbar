package com.demo_seekbar.pulkit.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.demo_seekbar.pulkit.R;
import com.demo_seekbar.pulkit.util.AppConstant;
import com.demo_seekbar.pulkit.util.CommonUtil;

import org.florescu.android.rangeseekbar.RangeSeekBar;

public class SimpleRangeSeekbarActivity extends AppCompatActivity {

    private static final int REQUEST_TAKE_GALLERY_VIDEO = 100;
    private static final String TAG = SimpleRangeSeekbarActivity.class.getName();

    private int stopPosition;
    private VideoView videoView;
    private Button uploadVideo;
    private Uri selectedVideoUri;

    private TextView tvLeft, tvRight;
    private RangeSeekBar rangeSeekBar;

    private int duration;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_range_seekbar);

        findIds();
        init();
    }

    private void findIds() {

        videoView = findViewById(R.id.video_view);
        uploadVideo = findViewById(R.id.upload_video);

        tvLeft = (TextView) findViewById(R.id.tvLeft);
        tvRight = (TextView) findViewById(R.id.tvRight);

        rangeSeekBar = (RangeSeekBar) findViewById(R.id.rangeSeekBar);
    }

    private void init() {

        rangeSeekBar.setEnabled(false);

        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissions();
            }
        });

    }

    private void checkPermissions() {

        if (CommonUtil.checkAndRequestPermission(SimpleRangeSeekbarActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                AppConstant.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)) {

            if (CommonUtil.checkAndRequestPermission(SimpleRangeSeekbarActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    AppConstant.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)) {

                uploadVideo();
            }
        }
    }

    private void uploadVideo() {

        try {
            Intent intent = new Intent();
            intent.setType("video/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select video"), REQUEST_TAKE_GALLERY_VIDEO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_TAKE_GALLERY_VIDEO) {

                selectedVideoUri = data.getData();

                videoView.setVideoURI(selectedVideoUri);
                videoView.start();

                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                        duration = mp.getDuration() / 1000;

                        /*Set the timings of media*/
                        tvLeft.setText("00:00:00");
                        tvRight.setText(getTime(duration));

                        /*Set looping*/
//                        mp.setLooping(true);

                        float seekBarposition = duration;

                        rangeSeekBar.setRangeValues(0, duration);
                        rangeSeekBar.setSelectedMinValue(0);
                        rangeSeekBar.setSelectedMaxValue(duration);

                        rangeSeekBar.setEnabled(true);

                        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
                            @Override
                            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {

                                /*After setting the seekBar, play video where you left*/
                                videoView.seekTo((int) minValue * 1000);

                                int leftSeekBar = ((int) bar.getSelectedMinValue());
                                int rightSeekBar = ((int) bar.getSelectedMaxValue());

                                tvLeft.setText(getTime(leftSeekBar));
                                tvRight.setText(getTime(rightSeekBar));

                            }
                        });

                        final Handler handler = new Handler();
                        handler.postDelayed(runnable = new Runnable() {
                            @Override
                            public void run() {

//                                if (videoView.getCurrentPosition() >= rangeSeekBar.getSelectedMaxValue().intValue() * 1000)
//                                    videoView.seekTo(rangeSeekBar.getSelectedMinValue().intValue() * 1000);
//                                handler.postDelayed(runnable, 1000);

                            }
                        }, 1000);

                    }
                });
            }
        }
    }

    private String getTime(int seconds) {
        int hr = seconds / 3600;
        int rem = seconds % 3600;
        int mn = rem / 60;
        int sec = rem % 60;
        return String.format("%02d", hr) + ":" + String.format("%02d", mn) + ":" + String.format("%02d", sec);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {

            case AppConstant.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    checkPermissions();
                } else {
                    CommonUtil.checkAndRequestPermission(SimpleRangeSeekbarActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            AppConstant.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                }
                break;

            case AppConstant.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    checkPermissions();
                } else {
                    CommonUtil.checkAndRequestPermission(SimpleRangeSeekbarActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            AppConstant.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        stopPosition = videoView.getCurrentPosition();
        videoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        videoView.seekTo(stopPosition);
        videoView.start();
    }


}
