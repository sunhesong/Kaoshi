package com.example.java.kaoshi.data.model;

/**
 * Created by java on 2018/5/11.
 */

public interface Model {
    void RequestData(CallBackListener callBackListener);
    interface CallBackListener{
        void showData(String a);
    }

    void RequestData2(CallBackListener_TWO callBackListener);
    interface CallBackListener_TWO{
        void showData(String a);
    }
}
