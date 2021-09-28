package com.shop.demo.service;

import com.shop.demo.entity.Commodity;

public interface commodityService {
    Commodity checkCommodity(Commodity checkCommodity);
    int addCommodity(Commodity addCommodity);
    int delCommodity(Commodity delCommodity);
}
