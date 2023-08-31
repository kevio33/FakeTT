package com.yht.ftt.base;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        init();

    }

    protected abstract View getLayout();//加载布局
    protected abstract void init();//加载数据

    /**
     * 设置状态栏颜色
     */
    protected void setSystemBarColor(int color){

        ImmersionBar.with(this)
                .statusBarColor(color);//状态栏颜色，不写默认透明色
    }

    /**
     * 去掉状态栏
     */
    protected  void hidStatusBar(){
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
    }

    /**
     * 不息屏
     */
    protected  void keepScreenOn(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * Activity退出动画
     */
    protected  void setExitAnimation(int animId){
        overridePendingTransition(0,animId);
    }

    /**
     * 全屏
     */
    protected  void setFullScreen(){
        ImmersionBar.with(this).init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


