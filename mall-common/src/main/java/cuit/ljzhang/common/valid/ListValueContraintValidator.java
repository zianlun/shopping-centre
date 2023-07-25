package cuit.ljzhang.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ListValueContraintValidator
 * @Description
 * @Author ljzhang
 * @Date 2023/7/21 19:47
 * @Version 1.0
 *
 * ListValue 的自定义校验器
 */
public class ListValueContraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] value = constraintAnnotation.values();
        for(int i = 0; i < value.length; i++){
            set.add(value[i]);
        }
    }

    /**
     *
     * @param value 需要校验的值
     * @param context 校验的上下文环境
     * @return
     */
    //判断是否校验成功
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
