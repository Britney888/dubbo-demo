package com.example.dubbousersprovider.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_um_user")
public class TUmUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录类型
     */
    private String registerType;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 角色
     */
    private String roles;

    private String salt;

    /**
     * 登录状态（1，可登录2，不可登录）
     */
    private String loginStatus;

    /**
     * 是否实名认证 1已实名，2未实名，3已提交身份证信息 4已提交紧急联系人
     */
    private String isRealnameApprove;

    /**
     * 是否绑卡
     */
    private String isBindCard;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * 是否激活
     */
    private Integer isActivation;

    /**
     * 原字段废弃，改为支付密码锁定， 1 锁定， 0 正常
     */
    private String isAuthorization;

    /**
     * 设备号
     */
    private String registerImei;

    /**
     * 设备ip
     */
    private String registerIp;

    /**
     * 0未上传，1审核中，2通过，3拒绝
     */
    private Integer isUploadId;

    private Integer inviterId;

    /**
     * 原字段意义废弃，调整为是否锁定支付密码标识，0：未锁定；1：锁定
     */
    private Integer isUploadVideo;

    /**
     * 推送账号
     */
    private String channelNum;

    /**
     * 注册来源
     */
    private String channelWrap;


}
