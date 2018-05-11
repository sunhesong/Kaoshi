package com.example.java.kaoshi.presenter.impl;

import com.example.java.kaoshi.data.model.Model;
import com.example.java.kaoshi.data.model.ModelIml;
import com.example.java.kaoshi.presenter.contract.IContract;

/**
 * Created by java on 2018/5/11.
 */

public class PresenterIml_TWO implements IContract.IPresenter_TWO {
    IContract.IView_TWO iView_two;
    private  ModelIml modelIml;

    public PresenterIml_TWO(IContract.IView_TWO iView_two) {
        this.iView_two = iView_two;
        iView_two.setPresenter(this);
        modelIml = new ModelIml();
    }

    @Override
    public void Data() {
        modelIml.RequestData2(new Model.CallBackListener_TWO() {
            @Override
            public void showData(String a) {
                iView_two.showData(a);
            }
        });
    }
}
