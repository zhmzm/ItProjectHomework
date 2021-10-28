package com.shop.demo.entity;

import java.io.Serializable;

/**
 * comments
 * @author 
 */
public class CommentsKey implements Serializable {
    private Integer commodityId;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}