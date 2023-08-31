package com.yht.ftt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yht.ftt.base.BaseActivity;
import com.yht.ftt.base.CommonPagerAdapter;
import com.yht.ftt.bean.MainPageChangeEvent;
import com.yht.ftt.bean.PauseVideoEvent;
import com.yht.ftt.databinding.ActivityMainBinding;
import com.yht.ftt.fragment.CurrentLocationFragment;
import com.yht.ftt.fragment.RecommendFragment;
import com.yht.ftt.utils.RxBus;
import com.yht.ftt.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.functions.Action1;

public class MainActivity extends BaseActivity {


    private ActivityMainBinding activityMainBinding;
    private CommonPagerAdapter pagerAdapter;
    private List<Fragment> fragmentList ;
    //定位页
    private CurrentLocationFragment currentLocationFragment;
    //推荐页
    private RecommendFragment recommendFragment;

    private Long lastClickBackTime = 0l;//上次点击返回键时间

    private final int EXIT_TIME = 2000;//连续按返回键退出时间

    private int curPage = 1;//viewpager显示的页面索引
    @Override
    protected View getLayout() {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return activityMainBinding.getRoot();

    }

    @Override
    protected void init() {

        fragmentList = new ArrayList<Fragment>();
        currentLocationFragment = new CurrentLocationFragment();
        recommendFragment = new RecommendFragment();
        try {
            Thread.sleep(EXIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*bottomNavigationTab的按钮*/
        activityMainBinding.tabMainMenu.addTab(activityMainBinding.tabMainMenu.newTab().setText("首页"));
        activityMainBinding.tabMainMenu.addTab(activityMainBinding.tabMainMenu.newTab().setText("好友"));
        activityMainBinding.tabMainMenu.addTab(activityMainBinding.tabMainMenu.newTab().setText(""));
        activityMainBinding.tabMainMenu.addTab(activityMainBinding.tabMainMenu.newTab().setText("消息"));
        activityMainBinding.tabMainMenu.addTab(activityMainBinding.tabMainMenu.newTab().setText("我"));


        //viewpager的两个fragments
        fragmentList.add(currentLocationFragment);
        fragmentList.add(recommendFragment);
        //顶部tab
        pagerAdapter = new CommonPagerAdapter(getSupportFragmentManager(), (ArrayList<Fragment>) fragmentList, new ArrayList(Arrays.asList("重庆","推荐")));
        activityMainBinding.viewPager.setAdapter(pagerAdapter);
        setViewPagerChangeListener();

    }

    /**
     * 设置viewPager的滑动事件
     */
    private void setViewPagerChangeListener(){
        activityMainBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                curPage = position;
                if(position == 1){
                    //继续播放
                    RxBus.getDefault().post(new PauseVideoEvent(true));
                    Log.e("切换页面", "继续播放" );
                }else{
                    //切换到其他页面，暂停播放
                    Log.e("切换页面", "暂停播放" );
                    RxBus.getDefault().post(new PauseVideoEvent(false));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    /**
     * 监听头像点击事件，点击头像切换页面
     */
    private  void setPicClickListener(){
        RxBus.getDefault().toObservable(MainPageChangeEvent.class)
                .subscribe(new Action1<MainPageChangeEvent>() {
                    @Override
                    public void call(MainPageChangeEvent mainPageChangeEvent) {

                    }


                });
    }

    /**
     * 双击放回推出app
     */
    @Override
    public void onBackPressed() {
        //如果连续两秒点击返回就退出app
        if(System.currentTimeMillis()-lastClickBackTime>EXIT_TIME){
            if(activityMainBinding.viewPager.getCurrentItem() == 1){
                activityMainBinding.viewPager.setCurrentItem(0);
            }else{
                ToastUtil.showMsg(getApplicationContext(),"再按一次退出");
                lastClickBackTime = System.currentTimeMillis();
            }
        }else{
            super.onBackPressed();

        }
    }


}