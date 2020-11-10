package com.example.democonsumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * quick pass 闪付订单表
 *
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_qpm_order")
public class TQpmOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 闪付订单号, 贯穿始终
     */
    private String qpOrderCode;

    /**
     * 交易虚拟订单号, 周期: 交易通知开始-交易成功/失败;
     */
    private String virtualOrderCode;

    /**
     * 第三方交易单号(sinaOrderCode)
     */
    private String thirdOrderCode;

    /**
     * 银行交易批次号
     */
    private String batchNo;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 订单状态 -1: 交易失败  1. 交易完成,已推资   2:审核未通过  3:退款完成  4.交易完成,待推资
     */
    private String orderStatus;

    /**
     * 交易状态 1:交易成功  -1:逾期未还(交易失败)   -2:支用额度超出剩余额度(交易失败)  -3: 支付通道异常(交易失败)  -4: 交易金额小于最低消费金额(交易失败)  -5: 风控拒绝  -6:交易类型限制(交易失败)
     */
    private String tradeStatus;

    /**
     * 创建订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 业务类型 1:商品消费  2:现金消费
     */
    private String bizType;

    /**
     * 消费类型 编号
     */
    private String consumptionType;

    /**
     * 消费金额(没有算优惠),即最开始通知过来的金额
     */
    private Integer consumptionAmount;

    /**
     * 实付金额(在平台上优惠后的金额)
     */
    private Integer payAmount;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 优惠金额
     */
    private Integer discountAmount;

    /**
     * 主体(商户)编号
     */
    private String subject;

    /**
     * 产品编号  例如: 20:微博分期
     */
    private String product;

    /**
     * 渠道编号
     */
    private String marketingChannel;

    /**
     * 来源编号
     */
    private String marketingSource;

    /**
     * 分期期数(用户支付时选择/用户配置的)
     */
    private Integer periods;

    /**
     * 信用分, 来自芝麻信用或其他...
     */
    private Integer creditPoints;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商家订单号
     */
    private String merchantOrderCode;

    /**
     * 消费商家名称
     */
    private String merchantName;

    /**
     * 支付渠道 1:支付宝  2:微信
     */
    private String payChannel;

    /**
     * 银行编号
     */
    private String bankCode;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行卡号(二类卡)
     */
    private String bankCardNo;

    /**
     * 订单描述
     */
    private String orderDescription;

    /**
     * 商品说明
     */
    private String goodsName;

    /**
     * 平台编号
     */
    private String platformCode;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 退款状态 1:全额退款 2:部分退款  -2:默认 -1退款失败 0 待退款 1退款中 2退款成功 
     */
    private Integer refundStatus;

    /**
     * 支付年月 如:  202004
     */
    private String payMonthTime;

    /**
     * 资金方编号, 风控申通过,资金系统授信成功后得到;
     */
    private String fundsCode;

    /**
     * 消费业务类型编号(调用方, 新浪)
     */
    private String consumeBizType;

    /**
     * 失败原因
     */
    private String failedMsg;

    /**
     * 风控审核通过时间
     */
    private LocalDateTime auditTime;

    /**
     * 审核状态  0:待审核  1:审核通过  2:审核不通过  3:建议人工审核  4:人工审核不通过
     */
    private Integer auditStatus;


}
