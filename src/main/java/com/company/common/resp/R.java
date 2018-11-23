package com.company.common.resp;

/**
 * @author guofa.liu@kingtroldata.com
 * @description 错误码返回
 * @create 2018/11/17 14:10
 */
public class R {


    /**
     * 成功响应
     * @return
     */
    public static ResponseData success(){
        return success(null);
    }
    public static  ResponseData success(Object data){
        return new ResponseData(ResponseCode.CODE_200.getCode(), "", data);
    }

    /**
     * 失败响应业务中应该使用这个
     * @param message
     * @return
     */
    public static ResponseData fail(String message){
        return new ResponseData(ResponseCode.CODE_417.getCode(), message, null);
    }

    /**
     * 自定义异常响应，ExceptionHandler中使用
     * @param message
     * @return
     */
    public static ResponseData fail(ResponseCode code, String message){
        return new ResponseData(code.getCode(), message, null);
    }

    public enum ResponseCode{

        /**
         * 响应成功
         */
        CODE_200(200),
        /**
         * 参数异常
         */
        CODE_400(400),
        /**
         * 没有登录
         */
        CODE_401(401),
        /**
         * 业务异常
         */
        CODE_417(417),
        /**
         * 系统异常
         */
        CODE_500(500);

        private final Integer code;

        ResponseCode(Integer code){
            this.code = code;
        }
        public Integer getCode() {
            return code;
        }
    }

    public static class ResponseData{

        private Integer code;
        private String message;
        private Object data;

        public ResponseData(Integer code, String message, Object data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

}
