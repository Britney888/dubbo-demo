package com.example.dubbousersprovider.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 浪花黑卡实名表
 *
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_qpm_realname")
public class TQpmRealname implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 身份证号
     */
    private String papersCode;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 出生年
     */
    private String year;

    /**
     * 出生月
     */
    private String month;

    /**
     * 出生日
     */
    private String day;

    /**
     * 民族
     */
    private String nation;

    /**
     * 身份证地址
     */
    private String address;

    /**
     * 发卡机关
     */
    private String authority;

    /**
     * 性别
     */
    private String sex;

    /**
     * 有效期
     */
    private String validDate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 认证时间
     */
    private LocalDateTime approveTime;

    /**
     * ocr图片正面
     */
    private String ocrUrl1;

    /**
     * ocr图片反面
     */
    private String ocrUrl2;

    /**
     * 紧急联系人关系
     */
    private String emergencyTitle;

    /**
     * 紧急联系人名称
     */
    private String emergencyContact;

    /**
     * 紧急联系人电话
     */
    private String emergencyMobile;

    /**
     * 紧急联系人更新时间
     */
    private String emergencyTime;

    /**
     * 刷脸图片
     */
    private String faceImgUrl1;

    /**
     * 刷脸图片
     */
    private String faceImgUrl2;

    /**
     * 刷脸图片
     */
    private String faceImgUrl3;

    /**
     * 刷脸图片
     */
    private String faceImgUrl4;

    /**
     * 置信度
     */
    private String hackScore;

    /**
     * 刷脸第三方唯一标示
     */
    private String marital;

    private String loginName;


}
