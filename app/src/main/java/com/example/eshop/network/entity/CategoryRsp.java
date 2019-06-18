package com.example.eshop.network.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/6/18/018.
 */
// 暂时使用的商品分类的响应体
public class CategoryRsp {
    @SerializedName("data")
    private List<CategoryPrimary> mData;

    @SerializedName("status")
    private Status mStatus;

    public Status getStatus() {
        return mStatus;
    }

    public List<CategoryPrimary> getData() {
        return mData;
    }

}
