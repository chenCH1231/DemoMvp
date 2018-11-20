package com.yourparter.android.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.yourparter.android.mvp.contract.MainContract;
import com.yourparter.android.mvp.model.MainModel;


@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.Model bindMainModel(MainModel model);
}