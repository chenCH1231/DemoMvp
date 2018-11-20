package com.yourparter.android.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.yourparter.android.mvp.contract.SplashContract;
import com.yourparter.android.mvp.model.SplashModel;
import com.yourparter.android.mvp.model.entity.User;

import java.util.ArrayList;
import java.util.List;


@Module
public class SplashModule {
    private SplashContract.View view;

    /**
     * 构建 UserModule 时,将 View 的实现类传进来,这样就可以提供 View 的实现类给 Presenter
     *
     * @param view
     */
    public SplashModule(SplashContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SplashContract.View provideSplashView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SplashContract.Model provideSplashModel(SplashModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    List<User> getUsers() {
        return new ArrayList<>();
    }
}