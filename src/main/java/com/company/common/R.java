package com.company.common;

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
        return new ResponseData(true, "", data);
    }
    public static ResponseData fail(String message){
        return new ResponseData(false, message, null);
    }

    public static class ResponseData{

        private Boolean success;
        private String message;
        private Object data;

        public ResponseData(Boolean success, String message, Object data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
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
