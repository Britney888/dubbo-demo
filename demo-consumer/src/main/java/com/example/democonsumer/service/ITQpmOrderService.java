package com.example.democonsumer.service;

import com.example.democonsumer.beans.BackOrderDetailsVo;
import com.example.democonsumer.beans.OrdersQueryBo;
import com.example.democonsumer.entity.TQpmOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * quick pass 闪付订单表 服务类
 * </p>
 *
 * @author
 * @since 2020-10-29
 */
public interface ITQpmOrderService extends IService<TQpmOrder> {
    BackOrderDetailsVo getOrderInfoByOrderCode(OrdersQueryBo ordersQueryBo);
}
