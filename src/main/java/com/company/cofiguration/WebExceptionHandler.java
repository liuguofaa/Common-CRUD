package com.company.cofiguration;

import com.company.common.R;
import com.company.common.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author guofa.liu@kingtroldata.com
 * @description
 * @create 2018/11/17 14:09
 */

@Slf4j
@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    public R.ResponseData constraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> set =  e.getConstraintViolations();
        return R.diyFail(R.ResponseCode.CODE_401, set.isEmpty() ? "" : set.iterator().next().getMessage());
    }

    @ExceptionHandler(ServerException.class)
    public R.ResponseData serverException(ServerException e) {
        e.printStackTrace();
        log.error(e.getMessage(), e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R.ResponseData exception(Exception e) {
        e.printStackTrace();
        log.error("服务器异常", e);
        return R.serverFail("服务器异常");
    }
}
