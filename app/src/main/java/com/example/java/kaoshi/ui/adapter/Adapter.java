package com.example.java.kaoshi.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.kaoshi.R;
import com.example.java.kaoshi.data.bean.Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public class Adapter extends BaseQuickAdapter<Bean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<Bean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean item) {
        helper.setText(R.id.tv, item.getContent()).setText(R.id.tv2, item.getId() + "");
        Glide.with(mContext).load(item.getImg()).crossFade().into((ImageView) helper.getView(R.id.img));
    }
}
