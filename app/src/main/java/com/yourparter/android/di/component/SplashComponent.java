package com.yourparter.android.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yourparter.android.di.module.SplashModule;
import com.yourparter.android.mvp.contract.SplashContract;

import com.jess.arms.di.scope.ActivityScope;
import com.yourparter.android.mvp.ui.activity.SplashActivity;

@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}