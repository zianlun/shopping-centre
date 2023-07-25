package cuit.ljzhang.mall.product.exception;

import cuit.ljzhang.common.exception.BStatusCode;
import cuit.ljzhang.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MallExceptionControllerAdvice
 * @Description
 * @Author ljzhang
 * @Date 2023/7/21 16:57
 * @Version 1.0
 * 代码高质量：可读性，可维护性，可变更性
 */
@Slf4j
@RestControllerAdvice(basePackages = "cuit.ljzhang.mall.product")
public class MallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题: {}， 异常类型：{}", e.getMessage(), e.getClass());
        BindingResult result = e.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(
                error -> {
                    String name = error.getField();
                    String msg = error.getDefaultMessage();
                    errors.put(name, msg);
                }
        );
        return R.error(BStatusCode.BAD_REQUEST.getCode(), BStatusCode.BAD_REQUEST.getMsg()).put("error", errors);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleThrowable(Throwable e){
        log.error("系统未知异常: {}， 异常类型：{}", e.getMessage(), e.getClass());
        return R.error(BStatusCode.INTERNAL_SERVER_ERROR.getCode(), BStatusCode.INTERNAL_SERVER_ERROR.getMsg()).put("msg",e.getMessage());
    }
}
