package com.example.dubboapi.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jianwei
 */
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String loginName;

    private String registerType;

    private String loginPassword;

    private Date lastLoginTime;

    private Date registerTime;

    private String roles;

    private String salt;

    private String status;

    private String isRealnameApprove;

    private String isBindCard;

    private String payPassword;

    private Integer isActivation;

    private String isAuthorization;

    private String registerImei;

    private String registerIp;

    private Integer isUploadId;

    private Integer inviterId;

    private Byte isUploadVideo;

    private String nickName;

    private String image;

}
