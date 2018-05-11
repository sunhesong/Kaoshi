package com.example.java.kaoshi.data.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.java.kaoshi.utils.Util;

/**
 * Created by java on 2018/5/11.
 */

public class ModelIml implements Model{

    @Override
    public void RequestData(final CallBackListener callBackListener) {
        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==1){
                    String a= (String) msg.obj;
                    callBackListener.showData(a);
                }

            }
        };
        Util.getInstance().getDataByOK("http://192.168.43.120/first_page.json",handler,1);
    }

    @Override
    public void RequestData2(final CallBackListener_TWO callBackListener) {
        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==2){
                    String a= (String) msg.obj;
                    Log.e("-===",a);
                    callBackListener.showData(a);
                }

            }
        };
        Util.getInstance().getDataByOK("http://192.168.43.120/second_page.json",handler,2);

    }

}
