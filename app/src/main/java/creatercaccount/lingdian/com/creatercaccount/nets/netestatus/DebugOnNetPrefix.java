package creatercaccount.lingdian.com.creatercaccount.nets.netestatus;

import creatercaccount.lingdian.com.creatercaccount.MyStringBuilder;

/**
 * Created by lingdian on 2017/11/27.
 */

public class DebugOnNetPrefix extends BaseNetUrl {
    @Override
    public MyStringBuilder getApiPrefix() {
        MyStringBuilder sb = new MyStringBuilder(getHttp());
        sb.append("://qa.knowbox.cn:8019");
        return sb;
    }

    @Override
    public MyStringBuilder getPayPrefix() {
        MyStringBuilder sb = new MyStringBuilder(getHttp());
        sb.append("://betassweb.knowbox.cn:7001/");
        return sb;
    }

    @Override
    public MyStringBuilder getWebPrefix() {
        MyStringBuilder sb = new MyStringBuilder(getHttp());
        sb.append("://betassweb.knowbox.cn:7001/");
        return sb;
    }
}
