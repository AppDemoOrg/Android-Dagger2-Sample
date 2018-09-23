package com.mindorks.example.dagger.di.component;

import android.app.Application;
import android.content.Context;

import com.mindorks.example.dagger.app.DaggerApp;
import com.mindorks.example.dagger.data.DataManager;
import com.mindorks.example.dagger.data.db.DbHelper;
import com.mindorks.example.dagger.data.prefs.SharedPrefsHelper;
import com.mindorks.example.dagger.di.annotation.ApplicationContext;
import com.mindorks.example.dagger.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DaggerApp demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
