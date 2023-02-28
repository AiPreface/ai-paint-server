package com.paint.common.validation.constraints;


import com.paint.common.validation.FieldRepeatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = FieldRepeatValidator.class)
public @interface FieldRepeat {
    /**
     * 需要校验的字段
     */
    String[] fields() default {};

    String message() default "字段内容重复!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
