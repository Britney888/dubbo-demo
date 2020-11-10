package com.example.dubboapi.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回给请求的JSON对象
 * @author fredy
 */
public class JsonResult {
    /**
     * 常用的CODE枚举类型
     * @author fredy
     * @version $id$
     */
    public static class CODE{
        /**
         * 请求处理成功
         */
        public static int SUCCESS=200;
        /**
         * 请求处理失败(因为参数、权限不足等原因造成的)
         */
        public static int FAILURE=300;
        /**
         * 用户未登陆
         */
        public static int NOT_LOGIN=400;
        /**
         * 请求处理过程中发生了Exception
         */
        public static int EXCEPTION=500;
        /**
         * 未付费
         */
        public static int CHARGE = 600;

        /**
         * 用户已与其他微信号/微博账号/QQ号绑定
         */
        public static int BIND = 700;

        /**
         * 未绑定
         */
        public static int UNBIND = 800;
        /**
         * 用户支付密码错误
         */
        public static int PAYPWDERROR = 16019;
    }

    /**
     * 常用的MESSAGE描述
     * @author fredy
     * @version $id$
     */
    public static class MESSAGE{
        public static String SUCCESS="success";
        public static String FAILURE="failure";
        public static String NOT_LOGIN="not login";
        public static String EXCEPTION="exception";
    }

    /**
     * JSON请求的返回代码,取值范围包括但不仅限于JsonResult.CODE
     */
    private int code;
    /**
     * 对返回代码的文字描述,取值范围包括但不仅限于JsonResult.MESSAGE
     */
    private String message;
    /**
     * JSON请求的数据,存放在MAP里
     */
    private Map<String,Object> data;

    /**
     * 获取一个标记为执行成功的JsonResult对象（无data）
     * @return
     */
    public static JsonResult getSuccess(){
        JsonResult jr = new JsonResult();
        jr.setCode(CODE.SUCCESS);
        jr.setMessage(MESSAGE.SUCCESS);
        return jr;
    }

    /**
     * 获取一个标记为执行失败的JsonResult对象（无data）
     * @return
     */
    public static JsonResult getFailure(){
        JsonResult jr = new JsonResult();
        jr.setCode(CODE.FAILURE);
        jr.setMessage(MESSAGE.FAILURE);
        return jr;
    }

    /**
     * 获取一个标记为未登录的JsonResult对象（无data）
     * @return
     */
    public static JsonResult getNotLogin(){
        JsonResult jr = new JsonResult();
        jr.setCode(CODE.NOT_LOGIN);
        jr.setMessage(MESSAGE.NOT_LOGIN);
        return jr;
    }

    public JsonResult() {
        super();
    }

    public JsonResult(int code, String message, Map<String, Object> data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(int code, String message, String key, Object value) {
        super();
        this.code = code;
        this.message = message;
        put(key,value);
    }

    public JsonResult(String key, Object value) {
        super();
        this.code = CODE.SUCCESS;
        this.message = MESSAGE.SUCCESS;
        put(key,value);
    }

    public void put(String key,Object value){
        if(this.data==null) data=new HashMap<String,Object>();
        if(!StringUtils.isBlank(key)) data.put(key, value);
    }
    public Object get(String key){
        if(this.data==null) return null;
        return this.data.get(key);
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Map<String, Object> getData() {
        return data;
    }
    public void setData(Map<String, Object> data) {
        this.data = data;
    }


}

