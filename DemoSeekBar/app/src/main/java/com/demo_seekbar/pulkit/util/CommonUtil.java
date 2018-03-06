package com.demo_seekbar.pulkit.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by pulkit on 18/1/18.
 */

public class CommonUtil {

    public static boolean checkAndRequestPermission(Activity activity, String permissions, int PERMISSION_CODE) {

        if (ContextCompat.checkSelfPermission(activity, permissions) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{permissions}, PERMISSION_CODE);
            return false;
        }

    }

}
