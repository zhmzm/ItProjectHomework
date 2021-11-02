package com.shop.demo.service;

import com.shop.demo.entity.Seller;

import java.util.List;

public interface sellerService {
    int addSeller(Seller newSeller);
    int delSeller(int sellerId);
    int updateSeller(Seller updateSeller);
    Seller getSellerById(int sellerId);
    List<Seller> getAllSeller();
}
