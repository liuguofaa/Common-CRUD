package com.company.common.resp;

/**
 * @author guofa.liu@kingtroldata.com
 * @description 错误码返回
 * @create 2018/11/17 14:10
 */
public class R {

    public static ResponseData success(){
        return success(null);
    }
    public static  ResponseData success(Object data){
        return new ResponseData(ResponseCode.CODE_200.getCode(), "", data);
    }

    /**
     * 业务中应该使用这个
     * @param message
     * @return
     */
    public static ResponseData fail(String message){
        return new ResponseData(ResponseCode.CODE_400.getCode(), message, null);
    }

    /**
     * 这两个一般ExceptionHandler中使用
     * @param message
     * @return
     */
    public static ResponseData serverFail(String message){
        return new ResponseData(ResponseCode.CODE_500.getCode(), message, null);
    }
    public static ResponseData diyFail(ResponseCode code, String message){
        return new ResponseData(code.getCode(), message, null);
    }

    public enum ResponseCode{

        CODE_200(200),CODE_400(400),CODE_401(401),CODE_500(500);

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
