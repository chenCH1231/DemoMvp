package com.yourparter.android.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.yourparter.android.di.component.DaggerMainComponent;
import com.yourparter.android.mvp.contract.MainContract;
import com.yourparter.android.mvp.presenter.MainPresenter;

import com.yourparter.android.R;
import com.yourparter.android.mvp.ui.fragment.IndexFragment;
import com.yourparter.android.mvp.ui.fragment.MineFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, BottomBarLayout.OnItemSelectedListener {

    @BindView(R.id.bbl)
    BottomBarLayout mBottomBarLayout;

    private List<BaseFragment> mFragments;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mFragments = new ArrayList<>();
        mFragments.add(IndexFragment.newInstance());
        mFragments.add(MineFragment.newInstance());
        changeFragment(0);

        mBottomBarLayout.setOnItemSelectedListener(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    private void changeFragment(int currentPosition) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_content, mFragments.get(currentPosition));
        transaction.commit();
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onItemSelected(BottomBarItem bottomBarItem, int i, int i1) {
        changeFragment(i1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBottomBarLayout = null;
        mFragments = null;
    }
}
