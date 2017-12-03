package creatercaccount.lingdian.com.creatercaccount.response;

/**
 * Created by lingdian on 2017/12/1.
 */

public interface HttpResponseListener<T> {
    public void  onSuccess(int code,T data);
    public void onError(int code,Throwable throwable);
}
