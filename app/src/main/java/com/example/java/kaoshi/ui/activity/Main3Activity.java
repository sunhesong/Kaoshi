package com.example.java.kaoshi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.application.dao.DaoMaster;
import com.example.java.kaoshi.R;
import com.example.java.kaoshi.data.bean.Bean;
import com.example.java.kaoshi.ui.adapter.Adapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.recy)
    RecyclerView recy;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        List<Bean> beans = Main2Activity.beanDao.loadAll();
        adapter = new Adapter(R.layout.layout, beans);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
adapter.notifyDataSetChanged();
    }
}
