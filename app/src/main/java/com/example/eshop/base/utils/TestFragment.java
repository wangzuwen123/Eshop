package com.example.eshop.base.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gqq on 2017/2/22.
 */

public class TestFragment extends Fragment {

    private static final String FRAGMENT_TEXT = "fragment_text";

    @BindView(R.id.text)
    TextView mTextView;

    // 对外提供一个创建方法：传递数据
    public static TestFragment newInstance(String text){
        TestFragment testFragment = new TestFragment();

        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TEXT,text);
        testFragment.setArguments(bundle);

        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test,container,false);

        ButterKnife.bind(this,view);
        mTextView.setText(getArgumentText());
        return view;
    }

    public String getArgumentText(){
        return getArguments().getString(FRAGMENT_TEXT);
    }
}