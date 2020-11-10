package com.example.democonsumer.controller;


import com.alibaba.fastjson.JSON;
import com.example.democonsumer.beans.BackOrderDetailsVo;
import com.example.democonsumer.beans.OrdersQueryBo;
import com.example.democonsumer.service.ITQpmOrderService;
import com.example.dubboapi.client.UserApi;
import com.example.dubboapi.dto.UserDto;
import com.example.dubboapi.request.HttpResult;
import com.example.dubboapi.utils.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * quick pass 闪付订单表 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-10-29
 */
@Slf4j
@RestController
public class TQpmOrderController {

    @Autowired
    ITQpmOrderService orderService;
    @Reference(version = "1.0")
    UserApi userApi;
    @RequestMapping(value = "/getOrderDetailInfo.json", method = {RequestMethod.POST})
    public ResponseJson getOrderInfoByOrderCode(@RequestBody OrdersQueryBo ordersQueryBo) {
        ResponseJson responseJson = null;
        BackOrderDetailsVo backOrderDetailsVo=orderService.getOrderInfoByOrderCode(ordersQueryBo);
        if (null!=backOrderDetailsVo){
            HttpResult<UserDto> userDto= userApi.queryUserByUserId(backOrderDetailsVo.getUserId());
            backOrderDetailsVo.setMobilePhone(userDto.getBody().getLoginName());
        }
        responseJson = ResponseJson.getSuccessJson();
        responseJson.put("data", backOrderDetailsVo);
        log.info("获取订单信息请求参数{}返回数据{}", JSON.toJSONString(ordersQueryBo),JSON.toJSONString(responseJson));
        return responseJson;
    }
}
