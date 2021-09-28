package com.shop.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * comments
 * @author 
 */
public class Comments extends com.shop.demo.entity.CommentsKey implements Serializable {
    private Date time;

    private String content;

    private BigDecimal score;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}