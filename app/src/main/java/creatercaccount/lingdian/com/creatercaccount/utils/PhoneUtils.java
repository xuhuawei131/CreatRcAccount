package creatercaccount.lingdian.com.creatercaccount.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import butterknife.internal.Utils;
import creatercaccount.lingdian.com.creatercaccount.MyApp;

/**
 * Created by lingdian on 2017/11/27.
 */

public class PhoneUtils {

    /**
     * 获取手机号码
     *
     * @return
     */
    public static String getPhoneRadomNum() {
        StringBuilder str = new StringBuilder(20);
        str.append(1);
        for (int i = 0; i < 10; i++) {
            str.append((int) (Math.random() * 9));
        }
        return str.toString();
    }

    public static int getGodCode() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int code = 1024 + (month + 1) * day;
        return code;
    }

    public static String getUrlCommonParams() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("?source=").append("androidRCStudent");
        buffer.append("&version=").append(String.valueOf(VersionUtils.getVersionCode(MyApp.getAppContext())));

//        String token = Utils.getToken();
//        if (!TextUtils.isEmpty(token)) {
//            try {
//                buffer.append("&token=").append(URLEncoder.encode(token, "utf-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
        buffer.append("&appVersion=").append(VersionUtils.getVersionName(MyApp.getAppContext()));
        buffer.append("&platform=Android");
        buffer.append("&appName=RCStudent");
        buffer.append("&channel=").append("Knowbox");
        buffer.append("&deviceId=" + DeviceUtil.getDeviceId(MyApp.getAppContext()));
        buffer.append("&deviceVersion=" + Build.VERSION.RELEASE);
        buffer.append("&deviceType=" + Build.MODEL.replaceAll(" ", ""));
        return buffer.toString();
    }

    public static String getStudentCommonParams() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("?source=").append("androidRCStudent");
        buffer.append("&version=").append("1");

//        String token = Utils.getToken();
//        if (!TextUtils.isEmpty(token)) {
//            try {
//                buffer.append("&token=").append(URLEncoder.encode(token, "utf-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
        buffer.append("&appVersion=").append("1.0");
        buffer.append("&platform=Android");
        buffer.append("&appName=RCStudent");
        buffer.append("&channel=").append("Knowbox");
        buffer.append("&deviceId=" + DeviceUtil.getDeviceId(MyApp.getAppContext()));
        buffer.append("&deviceVersion=" + Build.VERSION.RELEASE);
        buffer.append("&deviceType=" + Build.MODEL.replaceAll(" ", ""));
        return buffer.toString();
    }
}
