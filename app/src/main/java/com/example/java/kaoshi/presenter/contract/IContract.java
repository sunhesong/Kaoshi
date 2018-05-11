package com.example.java.kaoshi.presenter.contract;

import com.example.java.kaoshi.presenter.BasePresenter;
import com.example.java.kaoshi.ui.BaseView;

/**
 * Created by java on 2018/5/11.
 */

public interface IContract {
    interface IPresenter extends BasePresenter{
        void Data();
    }
    interface IView<IPresenter> extends BaseView<IPresenter> {
        void showData(String a);
    }
    interface IPresenter_TWO extends BasePresenter{
        void Data();
    }
    interface IView_TWO<IPresenter_TWO> extends BaseView<IPresenter_TWO> {
        void showData(String a);
    }

}
