package com.yourparter.android.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yourparter.android.R;
import com.yourparter.android.mvp.model.entity.User;

import java.util.List;

public class IndexAdatper extends BaseQuickAdapter<User, BaseViewHolder> {

    public IndexAdatper(List data) {
        super(R.layout.recycle_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {

    }
}
