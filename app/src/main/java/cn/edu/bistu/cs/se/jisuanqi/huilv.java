package cn.edu.bistu.cs.se.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class huilv extends AppCompatActivity {
    result result;
    private RadioGroup yuan;
    private RadioGroup mudi;
    private Button chaxun;
    private TextView xianshihuilv;
    private EditText shurujine;
    private Button zhuanhuan;
    private TextView zhuanhuanjieguo;
    private String yuanhuobi;
    private String mudihuobi;
    String api;
    String s1="http://api.k780.com/?app=finance.rate&scur=";
    String s2="&tcur=";
    String s3="&appkey=46930&sign=ccde9a6258788ad81788614f40e19350";
    String api1="http://api.k780.com/?app=finance.rate&scur=USD&tcur=CNY&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huilv);
        first();

        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                api=s1+yuanhuobi+s2+mudihuobi+s3;
                Log.d("mytag",api);
                HttpUtil.sendOkHttpRequest(api, new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseText = response.body().string();
                        result=HttpUtil.tran(responseText);
                        Message message=new Message();
                        message.what=1;
                        handler.sendMessage(message);
                    }
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("mytage",e.toString());
                    }
                });
            }
        });

        zhuanhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double yuan=Double.parseDouble(shurujine.getText().toString());
                double huilv=Double.parseDouble(result.huilv);
                zhuanhuanjieguo.setText("可兑换"+result.MuBiaoBiZhong+"的金额为"+yuan*huilv+"元");
            }
        });


    }

    private void first() {
        yuan=findViewById(R.id.yuan);
        mudi=findViewById(R.id.mudi);
        chaxun=findViewById(R.id.chaxun);
        shurujine=findViewById(R.id.shurujine);
        zhuanhuan=findViewById(R.id.zhuanhuan);
        zhuanhuanjieguo=findViewById(R.id.zhuanhuanjieguo);
        xianshihuilv=findViewById(R.id.xianshihuilv);
        yuan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    RadioButton radioButton_checked=radioGroup.findViewById(i);
                    String gender=radioButton_checked.getText().toString();
                    Toast.makeText(huilv.this,gender,Toast.LENGTH_SHORT).show();
                    switch (i){
                        case R.id.CNY1:
                            yuanhuobi="CNY";
                            Log.d("yuanhuobi",yuanhuobi);
                            break;
                        case R.id.USD1:
                            yuanhuobi="USD";
                            Log.d("yuanhuobi",yuanhuobi);
                            break;
                        case R.id.GBP1:
                            yuanhuobi="GBP";
                            Log.d("yuanhuobi",yuanhuobi);
                            break;
                }
            }
        });

        mudi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton_checked=radioGroup.findViewById(i);
                String gender=radioButton_checked.getText().toString();
                Toast.makeText(huilv.this,gender,Toast.LENGTH_SHORT).show();
                switch (i){
                    case R.id.CNY2:
                        mudihuobi="CNY";
                        Log.d("mudihuobi",mudihuobi);
                        break;
                    case R.id.USD2:
                        mudihuobi="USD";
                        Log.d("mudihuobi",mudihuobi);
                        break;
                    case R.id.GBP2:
                        mudihuobi="GBP";
                        Log.d("mudihuobi",mudihuobi);
                        break;
                }
            }
        });




    }

    private Handler handler=new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case 1:xianshihuilv.setText(result.YuanBiZhong+"到"+result.MuBiaoBiZhong+"的汇率为"+result.huilv+ "  "+result.RiQi);break;
            }
        }
    };

}
