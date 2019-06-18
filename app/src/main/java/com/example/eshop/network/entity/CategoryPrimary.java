package com.example.eshop.network.entity;

/**
 * Created by Administrator on 2019/6/18/018.
 */
import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

/**
 * 商品一级分类.
 */
public class CategoryPrimary extends CategoryBase {

    @SerializedName("children")
    private List<CategoryBase> mChildren = Collections.emptyList();

    public List<CategoryBase> getChildren() {
        return mChildren;
    }
}