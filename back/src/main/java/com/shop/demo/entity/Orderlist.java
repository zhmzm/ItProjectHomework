package com.shop.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * orderList
 * @author 
 */
@Data
public class Orderlist implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer sellerId;

    private Integer commodityId;

    private Date time;

    private Integer state;

    private Double price;

    private Double discount;

    private Integer num;

    private String c1;

    private String c2;

    private String c3;

    private static final long serialVersionUID = 1L;
}