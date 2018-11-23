package com.company.cofiguration;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.company.common.utils.FastJson;
import org.springframework.beans.PropertyValuesEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author guofa.liu@kingtroldata.com
 * @description
 * @create 2018/11/17 11:26
 */

@Configuration
public class WeMVCConfiguration {


    /**
     * CORS跨域
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
            }
        };
    }


    /**
     * Fastjson 配置
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonConfigure(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(FastJson.DefaultSerializerFeature);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.defaultCharset());
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(Charset.forName("utf-8"));
        stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML));
        return new HttpMessageConverters(stringHttpMessageConverter, fastJsonHttpMessageConverter);
    }


    /**
     * 全局的属性编辑器
     * @param requestMappingHandlerAdapter
     */
    @Autowired
    public void setWebBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        requestMappingHandlerAdapter.setWebBindingInitializer(new WebBindingInitializer() {
            @Override
            public void initBinder(WebDataBinder webDataBinder) {
                webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor());
            }
        });
    }


    class CustomDateEditor extends PropertyValuesEditor{

        private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            try{
                setValue(df.parse(text));
            }catch (Exception e){
                setValue(null);
            }
        }


        @Override
        public String getAsText() {
            Date value = (Date) getValue();
            return (value != null ? df.format(value) : "");
        }
    }

}