package com.example.java.kaoshi.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.kaoshi.R;
import com.example.java.kaoshi.data.bean.Second_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public class RecyAdapter extends BaseQuickAdapter<Second_Bean.ResultBean.DataBean, BaseViewHolder> {

    public RecyAdapter(int layoutResId, @Nullable List<Second_Bean.ResultBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Second_Bean.ResultBean.DataBean item) {

        helper.setText(R.id.tv, item.getContent()).setText(R.id.tv2, item.getUnixtime()+"");
        Glide.with(mContext).load(item.getUrl()).crossFade().into((ImageView) helper.getView(R.id.img));
        helper.addOnClickListener(R.id.add);
    }
}
