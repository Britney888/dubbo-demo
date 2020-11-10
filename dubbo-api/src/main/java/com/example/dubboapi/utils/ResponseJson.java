package com.example.dubboapi.utils;


import com.example.dubboapi.common.ProtocalConstants;
import com.example.dubboapi.request.ProtocolsJson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@ApiModel(description = "返回数据")
public class ResponseJson implements ProtocolsJson {
    /**
     *
     */
    private static final long serialVersionUID = 1999928748461821206L;

    /**
     * 返回的数据体
     */
    @ApiModelProperty(value = "返回的数据体", name = "body", dataType = "Map")
    private Map<String, Object> body = new HashMap<String, Object>();

    /**
     * 返回的头信息
     */
    @ApiModelProperty(value = "返回的头信息", name = "heads", dataType = "Map")
    private Map<String, Object> heads = new HashMap<String, Object>();

    /**
     * 默认key，方便前端好解析，统一key
     */
    private static final String dataKey = "data";

    public ResponseJson() {
    }

    /**
     * 使用code和message构造
     *
     * @param code
     * @param message
     */
    public ResponseJson(int code, String message) {
        this.heads.put(ProtocalConstants.CODE, code);
        this.heads.put(ProtocalConstants.MESSAGE, message);
    }

    /**
     * 失败， 错误码300
     *
     * @param message
     * @return
     */
    public ResponseJson(String message) {
        this.heads.put(ProtocalConstants.CODE, JsonResult.CODE.FAILURE);
        this.heads.put(ProtocalConstants.MESSAGE, message);
    }


    @JsonIgnore
    public boolean isSuccess() {
        try{
            return ProtocalConstants.CODE_CONSTANTS.SUCCESS == (int) heads.get(ProtocalConstants.CODE);
        }catch (Exception e){
            try{
                return ProtocalConstants.CODE_CONSTANTS.SUCCESS == Integer.valueOf((String) heads.get(ProtocalConstants.CODE));
            }catch (Exception ee){
                return false;
            }
        }
    }

    /**
     * 使用 JsonResult 构造
     *
     * @param jsonResult
     */
    public ResponseJson(JsonResult jsonResult) {
        this.heads.put(ProtocalConstants.CODE, jsonResult.getCode());
        this.heads.put(ProtocalConstants.MESSAGE, jsonResult.getMessage());
    }

    /**
     * 使用code和message构造
     *
     * @param code
     * @param message
     */
	/*public ResponseJson(String code, String message) {
		super();
		this.heads.put(ProtocalConstants.CODE, code);
		this.heads.put(ProtocalConstants.MESSAGE, message);
	}*/

    /**
     * 使用code,message,body构造
     *
     * @param code
     * @param message
     * @param body
     */
    public ResponseJson(int code, String message, Map<String, Object> body) {
        super();
        this.heads.put(ProtocalConstants.CODE, code);
        this.heads.put(ProtocalConstants.MESSAGE, message);
        this.body = body;
    }

    /**
     * 使用code,message,一对数据key,value构造
     *
     * @param code
     * @param message
     * @param key
     * @param value
     */
    public ResponseJson(int code, String message, String key, Object value) {
        super();
        this.heads.put(ProtocalConstants.CODE, code);
        this.heads.put(ProtocalConstants.MESSAGE, message);
        body.put(key, value);
    }

    /**
     * 构造成功的响应
     *
     * @return
     */
    public static ResponseJson getSuccessJson() {
        ResponseJson json = new ResponseJson(ProtocalConstants.CODE_CONSTANTS.SUCCESS,
                ProtocalConstants.MESSAGE_CONSTANTS.SUCCESS);
        json.put(null);
        return json;
    }

    /**
     * 构造成功的响应
     *
     * @return
     */
    public static ResponseJson getSuccessJson(Object data) {
        ResponseJson json = new ResponseJson(ProtocalConstants.CODE_CONSTANTS.SUCCESS,
                ProtocalConstants.MESSAGE_CONSTANTS.SUCCESS);
        json.put(data);
        return json;
    }

    /**
     * 构造处理中的响应
     *
     * @return
     */
    public static ResponseJson getProcessingJson() {
        ResponseJson json = new ResponseJson(ProtocalConstants.CODE_CONSTANTS.PROCESSING,
                ProtocalConstants.MESSAGE_CONSTANTS.PROCESSING);
        json.put(null);
        return json;
    }

    /**
     * 构造失败的响应
     *
     * @return
     */
    public static ResponseJson getFailureJson() {
        ResponseJson json = new ResponseJson(ProtocalConstants.CODE_CONSTANTS.FAILURE,
                ProtocalConstants.MESSAGE_CONSTANTS.FAILURE);
        json.put(null);
        return json;
    }

    /**
     * 构造未登陆的响应
     *
     * @return
     */
    public static ResponseJson getNoLoginJson() {
        ResponseJson json = new ResponseJson(ProtocalConstants.CODE_CONSTANTS.NOT_LOGIN,
                ProtocalConstants.MESSAGE_CONSTANTS.NOT_LOGIN);
        json.put(null);
        return json;
    }

    /**
     * 通过jsonResult构造responseJson
     *
     * @param jsonRes
     * @return
     */
    public static ResponseJson getByJsonResult(JsonResult jsonRes) {
        ResponseJson responseJson = getFailureJson();
        responseJson.setCode(String.valueOf(jsonRes.getCode()));
        responseJson.setMessage(jsonRes.getMessage());
        responseJson.body = jsonRes.getData();
        return responseJson;
    }

    /**
     * 单独设置message
     *
     * @param message
     */
    public void setMessage(String message) {
        this.heads.put(ProtocalConstants.MESSAGE, message);
    }

    /**
     * 单独设置code
     *
     * @param code
     */
    public void setCode(Object code) {
        this.heads.put(ProtocalConstants.CODE, code);
    }

    /**
     * 单独设置errorMsg
     *
     * @param errorMsg
     */
    @Deprecated
    public void setErrorMsg(String errorMsg) {
        this.heads.put(ProtocalConstants.MESSAGE, errorMsg);
    }


    /**
     * 增加响应的数据
     *
     * @param bodyKey
     * @param bodyVal
     */
    public void put(String bodyKey, Object bodyVal) {
        if (body == null) {
            body = new HashMap<String, Object>();
        }
        // 默认key
        if (StringUtils.isBlank(bodyKey)) {
            bodyKey = dataKey;
        }
        body.put(bodyKey, bodyVal);
    }

    /**
     * @Title: put @Description: TODO(重载默认key) @param @param bodyVal
     * 设定文件 @return void 返回类型 @throws
     */
    public void put(Object bodyVal) {
        if (body == null) {
            body = new HashMap<String, Object>();
        }
        body.put(dataKey, bodyVal);
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Map<String, Object> getHeads() {
        return heads;
    }

    public void setHeads(Map<String, Object> heads) {
        this.heads = heads;
    }


//	@com.fasterxml.jackson.annotation.JsonIgnore
//	public boolean isSuccess() {
//		int code = 0;
//		Object obj = this.heads.get(ProtocalConstants.CODE);
//		if (obj instanceof String && StringUtils.isNumeric((String) obj)) {
//			code = Integer.parseInt((String) obj);
//			return ProtocalConstants.CODE_CONSTANTS.SUCCESS == code;
//		}
//
//		return ProtocalConstants.CODE_CONSTANTS.SUCCESS == (Integer) this.heads.get(ProtocalConstants.CODE);
//	}

    public static ResponseJson getFailureResponse(int code, String describe) {
        ResponseJson responseJson = new ResponseJson(JsonResult.getFailure());
        responseJson.setCode(String.valueOf(code));
        responseJson.setMessage(describe);
        responseJson.put(null);
        return responseJson;
    }

    public static ResponseJson getFailureResponse(String code, String describe) {
        ResponseJson responseJson = new ResponseJson(JsonResult.getFailure());
        responseJson.setCode(code);
        responseJson.setMessage(describe);
        responseJson.put(null);
        return responseJson;
    }

    public static ResponseJson getFailureResponse(String describe) {
        ResponseJson responseJson = new ResponseJson(JsonResult.getFailure());
        responseJson.setCode(ProtocalConstants.CODE_CONSTANTS.FAILURE);
        responseJson.setMessage(describe);
        responseJson.put(null);
        return responseJson;
    }

    public static ResponseJson getSuccessResponse(String string,
                                                  Object obj) {
        ResponseJson responseJson = new ResponseJson(JsonResult.getSuccess());
        responseJson.put(string, obj);
//		responseJson.put(null);
        return responseJson;
    }


    public void message(String message) {
        this.heads.put(ProtocalConstants.CODE, JsonResult.CODE.FAILURE);
        this.heads.put(ProtocalConstants.MESSAGE, message);
    }

    /**
     * 构造失败的响应
     *
     * @return
     */
    public static ResponseJson getFailureJson(String message) {
        ResponseJson json = new ResponseJson(ProtocalConstants.CODE_CONSTANTS.FAILURE, message);
        return json;
    }

}
