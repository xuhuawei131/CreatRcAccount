package creatercaccount.lingdian.com.creatercaccount.reqeusts;


import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by lingdian on 2017/12/1.
 */

public class BaseReqeust {
    protected String url;

    public enum HTTP_METHOD {
        GET, POST
    }

    protected HTTP_METHOD method;

    protected BaseReqeust(HTTP_METHOD method, String url) {
        this.method = method;
        this.url = url;
    }

    public void sendRequest(Map<String, String> param) {
        if (method == HTTP_METHOD.GET) {
            getByOkGo();
        } else {
            postByGo(param);
        }
    }

    private void getByOkGo() {
        OkGo.get(url)                            // 请求方式和请求url
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheGetKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                    }
                });
    }

    private void postByGo(Map<String, String> param) {
        OkGo.post(url)
                .tag(this)
                .cacheKey("cachePostKey")
                .cacheMode(CacheMode.DEFAULT)
                .params("method", "album.item.get")
                .params("appKey", "myKey")
                .params("format", "json")
                .params("albumId", "Lqfme5hSolM")
                .params("pageNo", "1")
                .params("pageSize", "2")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        mTextView2.setText(s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
//                        mTextView2.setText(e.getMessage());
                    }
                });
    }
}
