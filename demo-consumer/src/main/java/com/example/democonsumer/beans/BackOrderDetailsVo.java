package com.example.democonsumer.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author ning
 * @Date 2020/4/23 18:04
 */
@Data
public class BackOrderDetailsVo implements Serializable {
    private String qpOrderCode;
    private String virtualOrderCode;
    private Integer userId;
    private String mobilePhone;
    private Date createTime;
    private String payAmount;
    private String consumptionAmount;
    private String bizType;
    private String consumptionType;
    private String periods;
    private String fundsName;
    private String fundsStatus;
    private String fundsCode;
    private String orderStatus;
    private String tradeStatus;
    private String marketingSource;
    private String payChannel;
    private Date payTime;
    private Integer discountAmount;
    private String merchantOrderCode;
    private String orderDescription;
    private String bankName;
    private String bankCardNo;
}
