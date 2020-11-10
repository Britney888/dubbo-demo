package com.example.dubboapi.common;
/**
 * 请求，响应的常量信息
 *
 * @author fredy.liu
 * @since 2013-10-22
 */
public class ProtocalConstants {

    /**
     * 返回的信息编码code
     */
    public static final String CODE = "code";

    /**
     * 返回的信息编码解释message
     */
    public static final String MESSAGE = "message";

    /**
     * 请求的参数的contents
     */
    public static final String CONTENTS = "contents";
    /**
     * 请求的协议
     */
    public static final String PROTOCAL = "protocal";
    /**
     * 接口返回错误的时候，错误消息对应的key值
     */
    public static final String ERRORMSG = "errorMsg";

    /**
     * 常用的CODE枚举类型
     *
     * @author fredy
     * @version $id$
     */
    public static class CODE_CONSTANTS {
        /**
         * 请求处理成功
         */
        public static int SUCCESS = 200;
        /**
         * 请求处理失败(因为参数、权限不足等原因造成的)
         */
        public static int FAILURE = 300;
        /**
         * 请求处理成功
         */
        public static int PROCESSING = 600;
        /**
         * 用户未登陆
         */
        public static int NOT_LOGIN = 400;


        public static int TOKEN_INVALID = 400;
        /**
         * 请求处理过程中发生了Exception
         */
        public static int EXCEPTION = 500;

    }

    public static class CODE_MESSAGE {

        public static String CODE_500_MESSAGE = "系统异常,请稍候重试";

    }

    /**
     * 常用的MESSAGE描述
     *
     * @author fredy
     * @version $id$
     */
    public static class MESSAGE_CONSTANTS {
        /**
         * 请求处理成功
         */
        public static String SUCCESS = "success";
        public static String PROCESSING = "请求正在处理中，请主动查询或等待异步回调";
        /**
         * 请求处理失败(因为参数、权限不足等原因造成的)
         */
        public static String FAILURE = "系统繁忙，请稍后再试";
        /**
         * 用户未登陆
         */
        public static String NOT_LOGIN = "not_login";
        /**
         * 请求处理过程中发生了Exception
         */
        public static String EXCEPTION = "系统繁忙，请稍后再试";
    }

}
