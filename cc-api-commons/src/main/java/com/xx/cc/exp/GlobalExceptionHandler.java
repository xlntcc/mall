package com.xx.cc.exp;

import com.xx.cc.resp.ResultData;
import com.xx.cc.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
//@RestControllerAdvice//本质上是个Component，用于定义@ExceptionHandler，@InitBinder和@ModelAttribute方法，适用于所有使用@RequestMapping方法。
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)//用于指定异常处理方法。当与@RestControllerAdvice配合使用时，用于全局处理控制器里的异常。
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//是 Spring Framework 提供的一个注解，用于指定控制器方法抛出异常时的 HTTP 状态码。
    public ResultData<String> exception(Exception e){
        log.error("全局异常信息exception:{}", e.getMessage(), e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }



}
