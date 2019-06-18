package com.example.eshop;


import android.support.annotation.IdRes;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.eshop.base.utils.TestFragment;
import com.example.eshop.category.CategoryFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;





import butterknife.BindView;
import butterknife.ButterKnife;


public class EShopMainActivity extends AppCompatActivity implements OnTabSelectListener {
    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    private TestFragment mHomeFragment;
    private CategoryFragment mCategoryFragment;
    private TestFragment mCartFragment;
    private TestFragment mMineFragment;

    private Fragment mCurrentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop_main);
        ButterKnife.bind(this);
        initView();
    }

    // 视图的初始化操作
    private void initView() {
        // 可以看一下Fragmentmanager里面是不是已经有了这些Fragment
        retrieveFragment();

        //alt + enter
        // 设置导航选择的监听事件
        mBottomBar.setOnTabSelectListener(this);
    }

    // 恢复因为系统重启造成的Fragmentmanager里面恢复的Fragment
    private void retrieveFragment() {
        FragmentManager manager = getSupportFragmentManager();
        mHomeFragment = (TestFragment) manager.findFragmentByTag("HomeFragment");
        mCategoryFragment = (CategoryFragment)  manager.findFragmentByTag(CategoryFragment.class.getName());
        mCartFragment = (TestFragment) manager.findFragmentByTag("CartFragment");
        mMineFragment = (TestFragment) manager.findFragmentByTag("MineFragment");
    }

    // 处理返回键
    @Override
    public void onBackPressed() {
        if (mCurrentFragment!=mHomeFragment){

            // 如果不是在首页，就切换首页上
            mBottomBar.selectTabWithId(R.id.tab_home);
            return;
        }
        // 是首页，我们不去关闭，退到后台运行
        moveTaskToBack(true);

    }

    //底部导航栏某一项选择的时候触发
    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                if (mHomeFragment == null) {
                    mHomeFragment = TestFragment.newInstance("HomeFragment");
                }
                // 切换Fragment
                switchfragment(mHomeFragment);

                break;
            case R.id.tab_category:
                if (mCategoryFragment == null) {
                    mCategoryFragment = CategoryFragment.newInstance();
                }
                switchfragment(mCategoryFragment);
                break;
            case R.id.tab_cart:
                if (mCartFragment == null) {
                    mCartFragment = TestFragment.newInstance("CartFragment");
                }
                switchfragment(mCartFragment);
                break;
            case R.id.tab_mine:
                if (mMineFragment == null) {
                    mMineFragment = TestFragment.newInstance("MineFragment");
                }
                switchfragment(mMineFragment);

                break;
            default:
                throw new UnsupportedOperationException("unsupport");

        }
    }
    // 作用：切换Fragment
    private void switchfragment(Fragment target) {
        // show hide的方式

        if (mCurrentFragment==target) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mCurrentFragment!=null){
            transaction.hide(mCurrentFragment);
        }
        if (target.isAdded()){
            // 如果已经添加到FragmentManager里面，就展示
            transaction.show(target);
        }else {
            // 为了方便找到Fragment，我们是可以设置Tag

            String tag;
            if (target instanceof TestFragment){
                tag = ((TestFragment)target).getArgumentText();
            }else {

                // 把类名作为tag
                tag = target.getClass().getName();
            }

            // 添加Fragment并设置Tag
            transaction.add(R.id.layout_container,target,tag);
        }

        transaction.commit();

        mCurrentFragment=target;


    }
}

