package cn.edu.bistu.cs.se.jisuanqi;



import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

    public static result tran(String response) {
        response=response.replace("{","");
        response=response.replace("}","");
        response=response.replace(",","");
        response=response.replace(":","");
        String[] a=response.split("\"");
        for(int i=0;i<a.length;i++)
            Log.d("mytage",i+"____"+a[i]);

        result result=new result();
        result.setYuanBiZhong(a[13]);
        result.setHuilv(a[25]);
        result.setMuBiaoBiZhong(a[17]);
        result.setRiQi(a[29]);
        result.setZhongWenMingCheng(a[21]);
        return result;

    }
}
