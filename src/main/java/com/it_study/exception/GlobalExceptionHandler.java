package com.it_study.exception;

import com.it_study.pojo.Result;
import org.springframework.web.bind.annotation.*;


//全局异常处理器
@RestControllerAdvice//=@ControllerAdvice+@RequestBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//指定要捕获的异常的类型
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
