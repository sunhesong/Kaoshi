package com.example.java.kaoshi.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.application.dao.BeanDao;
import com.android.application.dao.DaoMaster;
import com.android.application.dao.DaoSession;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.java.kaoshi.R;
import com.example.java.kaoshi.data.bean.Bean;
import com.example.java.kaoshi.data.bean.Second_Bean;
import com.example.java.kaoshi.presenter.contract.IContract;
import com.example.java.kaoshi.presenter.impl.PresenterIml_TWO;
import com.example.java.kaoshi.ui.adapter.RecyAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements IContract.IView_TWO<IContract.IPresenter_TWO> {
    IContract.IPresenter_TWO iPresenter_two;
    @BindView(R.id.recy)
    RecyclerView recy;
    private List<Second_Bean.ResultBean.DataBean> data;
    public static BeanDao beanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        new PresenterIml_TWO(this);
        iPresenter_two.Data();
        DaoSession bean = DaoMaster.newDevSession(this, "Bean");
        beanDao = bean.getBeanDao();
    }

    @Override
    public void setPresenter(IContract.IPresenter_TWO iPresenter_two) {
        this.iPresenter_two = iPresenter_two;
    }

    @Override
    public void showData(String a) {

        Second_Bean second_bean = new Gson().fromJson(a, Second_Bean.class);
        data = second_bean.getResult().getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecyAdapter recyAdapter = new RecyAdapter(R.layout.layoutitem3, data);
                recy.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
                recy.setAdapter(recyAdapter);
                recyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {

                        new AlertDialog.Builder(Main2Activity.this).setNegativeButton("添加", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Second_Bean.ResultBean.DataBean dataBean = data.get(position);
                                Bean bean = new Bean(null, dataBean.getContent(), dataBean.getUrl());
                                beanDao.insert(bean);
                            }
                        }).setPositiveButton("取消", null).show();

                    }
                });
                recyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                    }
                });
            }
        });

    }
}
