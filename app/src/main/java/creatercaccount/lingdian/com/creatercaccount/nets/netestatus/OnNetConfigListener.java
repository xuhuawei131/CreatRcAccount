package creatercaccount.lingdian.com.creatercaccount.nets.netestatus;

import creatercaccount.lingdian.com.creatercaccount.MyStringBuilder;

/**
 * Created by lingdian on 2017/11/27.
 */

public interface OnNetConfigListener {
    public MyStringBuilder getApiPrefix();
    public MyStringBuilder getPayPrefix();
    public MyStringBuilder getWebPrefix();
}
