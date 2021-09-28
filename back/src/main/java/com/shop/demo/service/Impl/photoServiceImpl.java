package com.shop.demo.service.Impl;

import com.shop.demo.Dao.PictureDao;
import com.shop.demo.entity.Picture;
import com.shop.demo.service.photoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class photoServiceImpl implements photoService {
    @Autowired
    PictureDao pictureDao;

    @Override
    public List<Picture> getPicture(String commodityID) {
        return pictureDao.selectByCommodityId(commodityID);
    }

    @Override
    public int addPicture(Picture addpicture) {
        return pictureDao.insertSelective(addpicture);
    }
}
