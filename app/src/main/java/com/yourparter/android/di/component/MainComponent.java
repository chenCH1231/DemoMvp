package com.yourparter.android.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yourparter.android.di.module.MainModule;
import com.yourparter.android.mvp.contract.MainContract;

import com.jess.arms.di.scope.ActivityScope;
import com.yourparter.android.mvp.ui.activity.MainActivity;
import com.yourparter.android.mvp.ui.fragment.IndexFragment;
import com.yourparter.android.mvp.ui.fragment.MineFragment;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);

    void inject(IndexFragment fragment);

    void inject(MineFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MainComponent.Builder view(MainContract.View view);

        MainComponent.Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}