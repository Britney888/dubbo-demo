package com.example.democonsumer.beans;

import lombok.Data;

/**
 * @Description TODO
 * @Author ning
 * @Date 2020/4/23 18:01
 */
@Data
public class OrdersQueryBo {
    private Integer userId;
    private String orderCode;
    private String qpOrderCode;
    private String mobilePhone;
    private String marketingSource;
    private String orderStatus;
    private String createTimeStart;
    private String createTimeEnd;
    private String fundName;
    private String fundStatus;
    private Integer minPayAmount;
    private Integer maxPayAmount;
    private Integer consumptionType;
    private Integer pageNum;
    private Integer pageSize;
}
