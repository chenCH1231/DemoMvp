package com.yourparter.android.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.yourparter.android.mvp.contract.IndexContract;
import com.yourparter.android.mvp.model.IndexModel;


@Module
public abstract class IndexModule {

    @Binds
    abstract IndexContract.Model bindIndexModel(IndexModel model);
}