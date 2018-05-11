package com.example.java.kaoshi.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.java.kaoshi.R;
import com.example.java.kaoshi.data.bean.First_Bean;

import java.util.List;

/**
 * Created by java on 2018/5/11.
 */

public class RecyclerAdapter extends BaseMultiItemQuickAdapter<First_Bean.ResultBean.DataBean, BaseViewHolder> {
    public RecyclerAdapter(List<First_Bean.ResultBean.DataBean> data) {
        super(data);
        addItemType(1, R.layout.layoutitem);
        addItemType(2, R.layout.layoutitem2);
    }

    @Override
    protected void convert(BaseViewHolder helper, First_Bean.ResultBean.DataBean item) {
        switch (item.getItemType()) {
            case 1:
                helper.setText(R.id.content, item.getContent());
                Glide.with(mContext).load(item.getUrl1()).crossFade()
                        .into((ImageView) helper.getView(R.id.img));
                break;
            case 2:
                Glide.with(mContext).load(item.getUrl1()).crossFade()
                        .into((ImageView) helper.getView(R.id.img));
                Glide.with(mContext).load(item.getUrl2()).crossFade()
                        .into((ImageView) helper.getView(R.id.img2));
                break;
        }
    }
}
