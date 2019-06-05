package com.rolan.leetcode;

import android.app.Activity;
import android.app.Application;

import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by wangyang on 2019-06-05.18:25
 */
public class App extends Application {

    public static App INSTANCE;

    public static Stack<Activity> activities=new Stack<>();

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
    }

    public static App getInstance() {
        return INSTANCE;
    }
}
