package creatercaccount.lingdian.com.creatercaccount.response;

import android.os.Build;

import org.json.JSONObject;

import creatercaccount.lingdian.com.creatercaccount.MyApp;
import creatercaccount.lingdian.com.creatercaccount.reqeusts.BaseReqeust;
import creatercaccount.lingdian.com.creatercaccount.utils.DeviceUtil;

/**
 * Created by lingdian on 2017/12/1.
 */

public class RegisterStudentRequest extends BaseReqeust {

    public String buildRegistParams(String mUserName,String mPhoneNumber,String mPassword,String  mSmsCode) {
        try {
            JSONObject json = new JSONObject();
            json.put("source", "androidRCStudent");
            json.put("version", "1");
            json.put("channel", "");
            try {
                json.put("deviceId", DeviceUtil.getDeviceId(MyApp.getAppContext()));
                json.put("deviceVersion", Build.VERSION.RELEASE);
                json.put("deviceType", Build.MODEL.replace(" ", "_"));
                json.put("token", "");
            } catch (Exception e) {
            }

            json.put("transaction", "register");
            json.put("username", mUserName);
            json.put("mobile", mPhoneNumber);
            json.put("password", mPassword);
            json.put("code", mSmsCode);
            return json.toString();
        } catch (Exception e) {
        }
        return null;
    }
}
