package com.example.java.kaoshi.utils;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by java on 2018/5/11.
 */

public class Util {
    private static final Util ourInstance = new Util();

    public static Util getInstance() {
        return ourInstance;
    }

    private Util() {
    }

    public void getDataByOK(String path, final Handler handler, final int tag) {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(path).build();

        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.obtainMessage(tag, response.body().string()).sendToTarget();
            }
        });
    }
}
