package com.miki.smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miki.smartbutler.R;

/*
 *  项目名:  SmartButler
 *  包  名:  com.miki.smartbutler.fragment
 *  文件名:  ButlerFragment
 *  创建者:  WZH
 *  时  间:  2018/5/18  11:02
 *  描  述:  ButlerFragment
 */
public class ButlerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butler, null);
        return view;
    }
}
