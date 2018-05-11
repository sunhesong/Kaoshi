package com.example.java.kaoshi.presenter.impl;

import com.example.java.kaoshi.data.model.Model;
import com.example.java.kaoshi.data.model.ModelIml;
import com.example.java.kaoshi.presenter.contract.IContract;

/**
 * Created by java on 2018/5/11.
 */

public class PresenterIml implements IContract.IPresenter{
    IContract.IView iView;
    private final ModelIml modelIml;

    public PresenterIml(IContract.IView iView) {
        this.iView=iView;
        iView.setPresenter(this);
        modelIml = new ModelIml();
    }

    @Override
    public void Data() {
        modelIml.RequestData(new Model.CallBackListener() {
            @Override
            public void showData(String a) {
                iView.showData(a);
            }
        });
    }
}
