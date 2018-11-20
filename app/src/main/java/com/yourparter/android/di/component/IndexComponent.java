package com.yourparter.android.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.yourparter.android.di.module.IndexModule;
import com.yourparter.android.mvp.contract.IndexContract;

import com.jess.arms.di.scope.ActivityScope;
import com.yourparter.android.mvp.ui.activity.IndexActivity;
import com.yourparter.android.mvp.ui.fragment.IndexFragment;

@ActivityScope
@Component(modules = IndexModule.class, dependencies = AppComponent.class)
public interface IndexComponent {
    void inject(IndexActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        IndexComponent.Builder view(IndexContract.View view);

        IndexComponent.Builder appComponent(AppComponent appComponent);

        IndexComponent build();
    }


}