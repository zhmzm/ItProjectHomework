package com.shop.demo.controller;

import com.shop.demo.entity.Picture;
import com.shop.demo.service.photoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Api(value="图片上传接口",tags={"图片上传接口"})
@RestController
@RequestMapping("/file")
public class imgController {
    @ApiOperation("上传商品图片")
    @PostMapping("/CommodityImg")
    public String uploadImg(@RequestParam MultipartFile file){
        String oldFileName=file.getOriginalFilename();
        File dirFile = new File("/usr/local/ftpdir/commodityImg");
        if (!dirFile.exists()){
            dirFile.mkdir();
        }
        String newFileName= System.currentTimeMillis()+'-'+oldFileName;
        File newFile = new File(dirFile,newFileName);
        try{
            file.transferTo(newFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "commodityImg/"+newFileName;
    }

    @ApiOperation("上传用户头像图片")
    @PostMapping("/personalImg")
    public String uploadAvatar(@RequestParam MultipartFile file){
        String oldFileName=file.getOriginalFilename();
        File dirFile = new File("/usr/local/ftpdir/personalImg");
        if (!dirFile.exists()){
            dirFile.mkdir();
        }
        String newFileName= System.currentTimeMillis()+'-'+oldFileName;
        File newFile = new File(dirFile,newFileName);
        try{
            file.transferTo(newFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "personalImg/"+newFileName;
    }
    @Autowired
    photoService photoService;
    @ApiOperation("更新图片库消息")
    @PostMapping("/updateInfo")
    public int updatePicture(int commodityId, String picAdress, short picSlot){
        Picture addPicture = new Picture();
        addPicture.setCommodityId(commodityId);
        addPicture.setAddress(picAdress);
        addPicture.setSlot(picSlot);
        return photoService.addPicture(addPicture);
    }
}
