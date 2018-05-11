package com.example.java.kaoshi.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.java.kaoshi.R;
import com.example.java.kaoshi.data.bean.First_Bean;
import com.example.java.kaoshi.presenter.contract.IContract;
import com.example.java.kaoshi.presenter.impl.PresenterIml;
import com.example.java.kaoshi.ui.adapter.RecyclerAdapter;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IContract.IView<IContract.IPresenter> {
    IContract.IPresenter iPresenter;
    @BindView(R.id.recy)
    RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new PresenterIml(this);
        iPresenter.Data();
    }

    @Override
    public void setPresenter(IContract.IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public void showData(String a) {
        First_Bean first_bean = new Gson().fromJson(a, First_Bean.class);
        final List<First_Bean.ResultBean.DataBean> data = first_bean.getResult().getData();

       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data);
               recy.setLayoutManager(new LinearLayoutManager(MainActivity.this));
               recy.setAdapter(recyclerAdapter);
               recyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                   @Override
                   public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                       startActivity(new Intent(MainActivity.this,Main2Activity.class));
                   }
               });
           }
       });


    }
}
