package com.mafcarrefour.feedapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.mafcarrefour.feedapplication.di.AppInjector;
import com.mafcarrefour.feedapplication.models.Article;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        AppInjector.init(this);


    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


}
