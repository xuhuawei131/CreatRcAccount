package creatercaccount.lingdian.com.creatercaccount.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import creatercaccount.lingdian.com.creatercaccount.R;
import creatercaccount.lingdian.com.creatercaccount.utils.PhoneUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    @BindView(R.id.text_code)
    TextView text_code;

    @BindView(R.id.text_phone)
    TextView text_phone;
    @BindView(R.id.text_name)
    TextView text_name;
    @BindView(R.id.text_password)
    TextView text_password;

    @BindView(R.id.btn_grenrate)
    Button btn_grenrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        int code=PhoneUtils.getGodCode();
        text_code.setText(code+"");



        btn_grenrate.setOnClickListener(listener);
    }




    protected String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        return response.body().string();

    }


    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text_phone.append(PhoneUtils.getPhoneRadomNum());
            text_name.append("作业盒子01");
            text_password.append("123456");
        }
    };
}
