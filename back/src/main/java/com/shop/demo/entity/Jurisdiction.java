package com.shop.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * jurisdiction
 * @author 
 */
@Data
public class Jurisdiction implements Serializable {
    private Integer userId;

    private Integer sellerPower;

    private Integer administratorPower;

    private Date sellerStart;

    private Date administratorStart;

    private String c1;

    private String c2;

    private String c3;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerPower() {
        return sellerPower;
    }

    public void setSellerPower(Integer sellerPower) {
        this.sellerPower = sellerPower;
    }

    public Integer getAdministratorPower() {
        return administratorPower;
    }

    public void setAdministratorPower(Integer administratorPower) {
        this.administratorPower = administratorPower;
    }

    public Date getSellerStart() {
        return sellerStart;
    }

    public void setSellerStart(Date sellerStart) {
        this.sellerStart = sellerStart;
    }

    public Date getAdministratorStart() {
        return administratorStart;
    }

    public void setAdministratorStart(Date administratorStart) {
        this.administratorStart = administratorStart;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }
}