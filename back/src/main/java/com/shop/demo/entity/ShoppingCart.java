package com.shop.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * shopping_cart
 * @author 
 */
public class ShoppingCart implements Serializable {
    private Integer id;

    private Integer userId;

    private Date createDate;

    private Double createPrice;

    private Integer commodityId;

    private Integer num;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getCreatePrice() {
        return createPrice;
    }

    public void setCreatePrice(Double createPrice) {
        this.createPrice = createPrice;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}