package com.mindorks.example.dagger.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mindorks.example.dagger.R;
import com.mindorks.example.dagger.app.DaggerApp;
import com.mindorks.example.dagger.data.DataManager;
import com.mindorks.example.dagger.data.bean.User;
import com.mindorks.example.dagger.di.component.DaggerActivityComponent;
import com.mindorks.example.dagger.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;
    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DaggerApp.get(this).getComponent())
                .build().inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");
        String token = mDataManager.getAccessToken();
        if (token != null) {
            mTvAccessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
