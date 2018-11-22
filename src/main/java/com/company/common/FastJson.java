package com.company.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * @author guofa.liu
 * @create 2018/11/22 19:43
 * @description
 */

public class FastJson {

    /**
     * fastjson默认序列化参数
     */
    SerializerFeature[] DefaultSerializerFeature = new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty};


    /**
     * 对象转成json字符串
     * @param object
     * @return
     */
    public String toJSONString(Object object){
        return JSON.toJSONString(object, DefaultSerializerFeature);
    }

    /**
     * json字符串转为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T parseObject(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

    /**
     * json字符串转为list
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public  <T> List<T> parseArray(String json, Class<T> clazz){
        return JSON.parseArray(json, clazz);
    }
}
