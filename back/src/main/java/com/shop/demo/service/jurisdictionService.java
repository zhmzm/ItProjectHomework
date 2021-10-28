package com.shop.demo.service;

import com.shop.demo.entity.Jurisdiction;

import java.util.List;

public interface jurisdictionService {
    int addNewJurisdiction(Jurisdiction newJurisdiction);
    int delJurisdiction(Jurisdiction delJurisdiction);
    Jurisdiction checkJurisdiction(int userId);
    List<Jurisdiction> checkAllJurisdiction();
}
