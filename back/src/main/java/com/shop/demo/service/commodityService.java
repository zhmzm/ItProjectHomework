package com.shop.demo.service;

import com.shop.demo.entity.Commodity;

import java.util.List;

public interface commodityService {
    Commodity checkCommodity(Commodity checkCommodity);
    int addCommodity(Commodity addCommodity);
    int delCommodity(Commodity delCommodity);
    Commodity checkCommodityWithPhoto(Commodity checkCommodity);
    List<Commodity> getAllCommodityBySellerId(int sellerId);

    List<String> getAllCommodity();
}
