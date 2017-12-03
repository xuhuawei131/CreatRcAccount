package creatercaccount.lingdian.com.creatercaccount.nets.netestatus;

/**
 * Created by lingdian on 2017/11/28.
 */

public abstract class BaseNetUrl implements OnNetConfigListener {
    public static boolean isHttps=false;
    protected static String getHttp(){
        return isHttps?"https":"http";
    }

}
