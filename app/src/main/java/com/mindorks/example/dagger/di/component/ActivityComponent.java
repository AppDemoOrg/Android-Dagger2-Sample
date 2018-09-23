package com.mindorks.example.dagger.di.component;

import com.mindorks.example.dagger.ui.MainActivity;
import com.mindorks.example.dagger.di.annotation.PerActivity;
import com.mindorks.example.dagger.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by janisharali on 08/12/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
