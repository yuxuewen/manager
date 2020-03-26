package com.macro.mall.tiny.component.valid.modal;

import com.macro.mall.tiny.component.valid.CanEmptyValueValidator;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CanEmptyValueValidatorImpl implements ConstraintValidator<CanEmptyValueValidator,Object> {
    String patternStr;
    @Override
    public void initialize(CanEmptyValueValidator constraintAnnotation) {

        patternStr=constraintAnnotation.parrern();
    }

    @Override
    public boolean isValid(Object values, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(patternStr) || StringUtils.isEmpty(values))
        {
            return true;
        }
        Pattern pattern=Pattern.compile(patternStr);
        Matcher m= pattern.matcher((CharSequence) values);
        return m.matches();
    }
}
