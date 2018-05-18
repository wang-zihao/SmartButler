package com.miki.smartbutler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.miki.smartbutler.fragment.ButlerFragment;
import com.miki.smartbutler.fragment.GirlFragment;
import com.miki.smartbutler.fragment.UserFragment;
import com.miki.smartbutler.fragment.WeChatFragment;
import com.miki.smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    //title
    private List<String> mTitle;
    //fragment
    private List<Fragment> mFragments;
    //floatingActionBar
    private FloatingActionButton fab_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去除阴影
        getSupportActionBar().setElevation(0);

        initData();
        initView();
    }

    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add(getString(R.string.app_name));
        mTitle.add(getString(R.string.wechat));
        mTitle.add(getString(R.string.girl));
        mTitle.add(getString(R.string.user));

        mFragments = new ArrayList<>();
        mFragments.add(new ButlerFragment());
        mFragments.add(new WeChatFragment());
        mFragments.add(new GirlFragment());
        mFragments.add(new UserFragment());
    }

    //初始化view
    private void initView() {

        fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
        //默认隐藏
        fab_setting.setVisibility(View.GONE);

        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);

        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(mFragments.size());
        //设置滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当滑动到第一页时隐藏
                if (position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
        }
    }
}
