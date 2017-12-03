package creatercaccount.lingdian.com.creatercaccount;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;

import creatercaccount.lingdian.com.creatercaccount.nets.netestatus.DebugOnNetPrefix;
import creatercaccount.lingdian.com.creatercaccount.nets.HttpServiceApi;

/**
 * Created by lingdian on 2017/11/29.
 */

public class MyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isAppMainProcess(this)) {
            context = this;
            HttpServiceApi.init(this);

        }
    }

    public static Context getAppContext() {
        return context;
    }

    /**
     * 判断是否运行在主进程中
     *
     * @return 是否为主进程
     */
    public synchronized static boolean isAppMainProcess(Application application) {
        try {
            int pid = android.os.Process.myPid();
            String process = "";
            ActivityManager manager = (ActivityManager) application.getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
                if (processInfo.pid == pid) {
                    process = processInfo.processName;
                }
            }
            if (TextUtils.isEmpty(process)) {
                return true;
            } else return application.getPackageName().equalsIgnoreCase(process);
        } catch (Exception e) {
            return true;
        }
    }
}
