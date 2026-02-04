package com.xx.cc.common.exception;

import com.xx.cc.common.enums.ResultCode;
import com.xx.cc.common.result.Result;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.stream.Collectors;

/**
 * 全局异常处理器
 * 统一处理项目中的各类异常，返回格式化的错误响应
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     * @param e 业务异常对象
     * @return 错误响应
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e) {
        log.error("业务异常: code={}, message={}", e.getCode(), e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常（@Valid注解校验失败）
     * @param e 参数校验异常对象
     * @return 错误响应
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 收集所有字段错误信息，用逗号连接
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        log.error("参数校验失败: {}", message);
        return Result.fail(ResultCode.PARAM_ERROR, message);
    }

    /**
     * 处理参数绑定异常
     * @param e 参数绑定异常对象
     * @return 错误响应
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleBindException(BindException e) {
        String message = e.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        log.error("参数绑定失败: {}", message);
        return Result.fail(ResultCode.PARAM_ERROR, message);
    }

    /**
     * 处理缺少请求参数异常
     * @param e 缺少请求参数异常对象
     * @return 错误响应
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String message = "缺少必要参数: " + e.getParameterName();
        log.error(message);
        return Result.fail(ResultCode.PARAM_ERROR, message);
    }

    /**
     * 处理404异常（接口不存在）
     * @param e 404异常对象
     * @return 错误响应
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<Void> handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.error("接口不存在: {}", e.getRequestURL());
        return Result.fail(ResultCode.NOT_FOUND);
    }

    /**
     * 处理请求方法不支持异常
     * @param e 请求方法不支持异常对象
     * @return 错误响应
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result<Void> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("请求方法不支持: {}", e.getMethod());
        return Result.fail(ResultCode.PARAM_ERROR, "请求方法不支持");
    }

    /**
     * 处理Feign调用异常
     * @param e Feign异常对象
     * @return 错误响应
     */
    @ExceptionHandler(FeignException.class)
    public Result<Void> handleFeignException(FeignException e) {
        log.error("Feign调用异常: {}", e.getMessage());
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "服务调用失败");
    }

    /**
     * 处理参数非法异常
     * @param e 参数非法异常对象
     * @return 错误响应
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("参数异常: {}", e.getMessage());
        return Result.fail(ResultCode.PARAM_ERROR, e.getMessage());
    }

    /**
     * 处理其他未知异常
     * @param e 异常对象
     * @return 错误响应
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Void> handleException(Exception e) {
        log.error("系统异常", e);
        return Result.fail(ResultCode.SERVER_ERROR);
    }
}
