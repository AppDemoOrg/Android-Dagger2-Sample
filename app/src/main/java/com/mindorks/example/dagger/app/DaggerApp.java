package com.mindorks.example.dagger.app;

import android.app.Application;
import android.content.Context;

import com.mindorks.example.dagger.data.DataManager;
import com.mindorks.example.dagger.di.component.ApplicationComponent;
import com.mindorks.example.dagger.di.component.DaggerApplicationComponent;
import com.mindorks.example.dagger.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by janisharali on 25/12/16.
 */

public class DaggerApp extends Application {

    @Inject
    DataManager dataManager;
    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public static DaggerApp get(Context context) {
        return (DaggerApp) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
