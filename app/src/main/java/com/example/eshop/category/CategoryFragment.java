package com.example.eshop.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2019/6/18/018.
 */

public class CategoryFragment extends Fragment {


    @BindView(R.id.standard_toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.standard_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.list_category)
    ListView mListCategory;
    @BindView(R.id.list_children)
    ListView mListChildren;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 初始化视图的操作
        initView();
    }

    private void initView() {

        // 处理toolbar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);
        // 处理actionbar不展示默认的标题
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle.setText(R.string.category_title);

        // ListView的展示

    }
}
