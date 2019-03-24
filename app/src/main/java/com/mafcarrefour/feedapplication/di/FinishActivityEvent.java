package com.mafcarrefour.feedapplication.di;

public class FinishActivityEvent {
   private Class activity;
    public FinishActivityEvent(Class activity){
        this.activity=activity;
    }

    public Class getActivity() {
        return activity;
    }
}
