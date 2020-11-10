package com.example.democonsumer.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.democonsumer.beans.BackOrderDetailsVo;
import com.example.democonsumer.beans.OrdersQueryBo;
import com.example.democonsumer.entity.TQpmOrder;
import com.example.democonsumer.mapper.TQpmOrderMapper;
import com.example.democonsumer.service.ITQpmOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * <p>
 * quick pass 闪付订单表 服务实现类
 * </p>
 *
 * @author
 * @since 2020-10-29
 */
@Slf4j
@Service(version = "1.0")
@org.springframework.stereotype.Service
public class TQpmOrderServiceImpl extends ServiceImpl<TQpmOrderMapper, TQpmOrder> implements ITQpmOrderService {

    @Override
    public BackOrderDetailsVo getOrderInfoByOrderCode(OrdersQueryBo ordersQueryBo) {
        TQpmOrder tQpmOrder = getOne(Wrappers.<TQpmOrder>lambdaQuery().eq(TQpmOrder::getQpOrderCode, ordersQueryBo.getQpOrderCode()));
        if (null==tQpmOrder){return null;}
        BackOrderDetailsVo backOrderDetailsVo=new BackOrderDetailsVo();
        BeanUtils.copyProperties(tQpmOrder, backOrderDetailsVo);
        return backOrderDetailsVo;
    }
}
