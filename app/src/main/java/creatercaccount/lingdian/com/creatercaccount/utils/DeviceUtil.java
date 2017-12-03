package creatercaccount.lingdian.com.creatercaccount.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.File;

import creatercaccount.lingdian.com.creatercaccount.MyApp;

import static android.content.Context.TELEPHONY_SERVICE;
import static android.os.Build.BRAND;
import static android.os.Build.CPU_ABI;
import static android.os.Build.MODEL;
import static android.os.Build.PRODUCT;
import static android.os.Build.VERSION.RELEASE;
import static android.os.Build.VERSION.SDK_INT;

/**
 * Created by lingdian on 2017/12/1.
 */

public class DeviceUtil {
    public static String CMCC1 = "46000"; // 中国移动
    public static String CMCC2 = "46002"; // 中国移动
    public static String CMCC3 = "46007"; // 中国移动
    public static String CU = "46001"; // 中国联通
    public static String CT = "46003"; // 中国电信

    /**
     * 获取DeviceId
     *
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager telephoneManager = getTelephoneManager(context);
        return telephoneManager.getDeviceId();
    }

    private static TelephonyManager getTelephoneManager(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        return telephonyManager;
    }

    /**
     * 获取手机IMSI
     *
     * @param context
     * @return
     */
    public static String getIMSI(Context context) {
        TelephonyManager telephoneManager = getTelephoneManager(context);
        return telephoneManager.getSubscriberId();
    }

    /**
     * 获取本机号码
     *
     * @param context
     * @return
     */
    public static String getPhoneNumber(Context context) {
        TelephonyManager telephoneManager = getTelephoneManager(context);
        return telephoneManager.getLine1Number();
    }

    /**
     * 获取Mac地址
     *
     * @param context
     * @return
     */
    public static String getMac(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getMacAddress();
    }

    /**
     * 获取产品名称
     *
     * @return
     */
    public static String getProductName() {
        return PRODUCT;
    }

    /**
     * 获取手机CPU类型
     *
     * @return
     */
    public static String getCpuType() {
        return CPU_ABI;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getModel() {
        return MODEL;
    }

    /**
     * 获取手机SDK版本Level
     *
     * @return
     */
    public static int getSystemVersionLevel() {
        return SDK_INT;
    }

    /**
     * 获取手机系统版本
     *
     * @return
     */
    public static String getSystemVersionName() {
        return RELEASE;
    }


    /**
     * 获取Android ID
     *
     * @return
     */
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);// 获取Android ID;
    }


    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getBrand() {
        return BRAND;
    }


    /***
     * 功能描述： 获取是否root
     */
    public static boolean isRoot() {
        File file = new File("/system/bin/su");
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }


    public static String getOperatorCode() {
        TelephonyManager telManager = (TelephonyManager) MyApp.getAppContext()
                .getSystemService(Context.TELEPHONY_SERVICE);
        String operator = telManager.getSimOperator();
        return operator;
    }

    public static String getOperatorCodeZh() {
        String str = getOperatorCode();
        if (TextUtils.isEmpty(str)) {
            return "";
        } else if (CMCC1.equals(str) || CMCC2.equals(str) || CMCC3.equals(str)) {
            return "中国移动";
        } else if (CU.equals(str)) {
            return "中国联通";
        } else if (CT.equals(str)) {
            return "中国电信";
        } else {
            return "未知";
        }
    }

    public static String getOperatorCodeEn() {
        String str = getOperatorCode();
        if (TextUtils.isEmpty(str)) {
            return "";
        } else if (CMCC1.equals(str) || CMCC2.equals(str) || CMCC3.equals(str)) {
            return "cmcc";
        } else if (CU.equals(str)) {
            return "cucc";
        } else if (CT.equals(str)) {
            return "ctcc";
        } else {
            return "unknown";
        }
    }
}
