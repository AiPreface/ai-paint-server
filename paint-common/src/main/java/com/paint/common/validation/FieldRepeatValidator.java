package com.paint.common.validation;

import com.paint.common.validation.constraints.FieldRepeat;
import com.paint.common.validation.util.FieldRepeatUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldRepeatValidator implements ConstraintValidator<FieldRepeat, Object> {
    private FieldRepeatUtils fieldRepeatUtils;
    private String[] fields;
    private String message;
    private FieldRepeat fieldRepeat;

    @Autowired
    public void setFieldRepeatUtils(FieldRepeatUtils fieldRepeatUtils) {
        this.fieldRepeatUtils = fieldRepeatUtils;
    }

    @Override
    public void initialize(FieldRepeat constraintAnnotation) {
        this.fieldRepeat = constraintAnnotation;
        this.fields = constraintAnnotation.fields();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return fieldRepeatUtils.isValid(o, fieldRepeat);
    }
}
