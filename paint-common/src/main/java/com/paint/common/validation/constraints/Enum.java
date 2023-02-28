package com.paint.common.validation.constraints;


import com.paint.common.validation.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Constraint(validatedBy = EnumValidator.class)
public @interface Enum {
    String message() default "该字段应该为枚举值!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> target();

    String field() default "name";
}

