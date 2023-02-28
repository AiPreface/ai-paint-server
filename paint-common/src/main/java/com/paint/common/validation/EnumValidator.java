package com.paint.common.validation;

import com.paint.common.validation.constraints.Enum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class EnumValidator implements ConstraintValidator<Enum, Object> {
    private static final Logger log = LoggerFactory.getLogger(EnumValidator.class);

    /**
     * 枚举需要校验的属性名
     **/
    private static final String ENUM_DEFAULT_FIELD = "name";
    /**
     * 枚举类
     */
    private Class<?> clazz;
    /**
     * 比较的属性
     */
    private String field;

    @Override
    public void initialize(Enum annotation) {
        this.clazz = annotation.target();
        this.field = annotation.field();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (!clazz.isEnum()) {
            return false;
        }

        Object[] enumValues = clazz.getEnumConstants();
        try {
            Method method = null;
            if (ENUM_DEFAULT_FIELD.equals(field)) {
                method = clazz.getMethod("name");
            }

            for (Object obj : enumValues) {
                Object e;
                if (method == null) {
                    Field enumField = clazz.getDeclaredField(field);
                    enumField.setAccessible(true);
                    e = enumField.get(obj);
                } else {
                    e = method.invoke(obj);
                }
                if (Objects.equals(value, e)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("参数枚举校验-校验失败。", e);
            return false;
        }
        return false;
    }

}