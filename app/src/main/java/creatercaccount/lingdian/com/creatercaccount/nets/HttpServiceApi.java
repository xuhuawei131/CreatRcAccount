package creatercaccount.lingdian.com.creatercaccount.nets;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.logging.Level;

import creatercaccount.lingdian.com.creatercaccount.MyStringBuilder;
import creatercaccount.lingdian.com.creatercaccount.nets.netestatus.BaseNetUrl;
import creatercaccount.lingdian.com.creatercaccount.nets.netestatus.DebugOnNetPrefix;
import creatercaccount.lingdian.com.creatercaccount.nets.netestatus.OnlineOnNetPrefix;

/**
 * Created by lingdian on 2017/12/1.
 */

public class HttpServiceApi {

    private static BaseNetUrl config;

    public static void init(Application application){
        HttpServiceApi.setHttpServiceApi(new DebugOnNetPrefix());
        initOkGo(application);
    }
    private static void initOkGo(Application application){
        //必须调用初始化
        OkGo.init(application);
        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
            HttpHeaders headers = new HttpHeaders();
            headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
            headers.put("commonHeaderKey2", "commonHeaderValue2");
            HttpParams params = new HttpParams();
            params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
            params.put("commonParamsKey2", "这里支持中文参数");

            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            OkGo.getInstance()
                    // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                    // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                    .debug("OkGo", Level.INFO, true)
                    //如果使用默认的 60秒,以下三行也不需要传
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间
                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                    .setCacheMode(CacheMode.NO_CACHE)

                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)

                    //可以全局统一设置超时重连次数,默认为三次,那么最差的情况会请求4次(一次原始请求,三次重连请求),不需要可以设置为0
                    .setRetryCount(3)

                    //如果不想让框架管理cookie（或者叫session的保持）,以下不需要
//                  .setCookieStore(new MemoryCookieStore())            //cookie使用内存缓存（app退出后，cookie消失）
                    .setCookieStore(new PersistentCookieStore())        //cookie持久化存储，如果cookie不过期，则一直有效

                    //可以设置https的证书,以下几种方案根据需要自己设置
                    .setCertificates()                                  //方法一：信任所有证书,不安全有风险
                    //这两行同上，不需要就不要加入
                    .addCommonHeaders(headers)  //设置全局公共头
                    .addCommonParams(params);   //设置全局公共参数

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setHttpServiceApi(BaseNetUrl pConfig) {
        config = pConfig;
    }
    private static BaseNetUrl getCurrentNetRoot() {
        if (config == null) {
            config = new OnlineOnNetPrefix();
        }
        return config;
    }
    //***************************设置具体的每个url***************************
    public static String getRegisterUrl() {
        MyStringBuilder rootBuilder =getCurrentNetRoot().getApiPrefix();
        return rootBuilder.toString();
    }
}
