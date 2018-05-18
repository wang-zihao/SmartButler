package com.miki.smartbutler.utils;

import android.util.Log;

/*
 *  项目名:  SmartButler
 *  包  名:  com.miki.smartbutler.utils
 *  文件名:  L
 *  创建者:  WZH
 *  时  间:  2018/5/18  14:46
 *  描  述:  Log封装
 */
public class L {

    //开关
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "SmartButler-app";

    //五个等级  V D I W E
    public static void v(String text) {
        if (DEBUG) {
            Log.v(TAG, text);
        }
    }

    public static void d(String text) {
        if (DEBUG) {
            Log.d(TAG, text);
        }
    }

    public static void i(String text) {
        if (DEBUG) {
            Log.i(TAG, text);
        }
    }

    public static void w(String text) {
        if (DEBUG) {
            Log.w(TAG, text);
        }
    }

    public static void e(String text) {
        if (DEBUG) {
            Log.e(TAG, text);
        }
    }
}
