package com.example.eshop;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EShopMainActivity extends AppCompatActivity implements OnTabSelectListener {
    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop_main);
        ButterKnife.bind(this);
        initView();
    }

    // 视图的初始化操作
    private void initView() {
        // 设置导航选择的监听事件
        mBottomBar.setOnTabSelectListener(this);
    }


    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_category:
                Toast.makeText(this, "分类", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_cart:
                Toast.makeText(this, "购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_mine:
                Toast.makeText(this, "我的", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new UnsupportedOperationException("unsupport");

        }
    }
}
