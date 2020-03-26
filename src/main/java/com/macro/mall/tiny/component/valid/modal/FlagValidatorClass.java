package com.macro.mall.tiny.component.valid.modal;

import com.macro.mall.tiny.component.valid.FlagValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagValidatorClass  implements ConstraintValidator<FlagValidator,Object> {
    private String[] values;
    @Override
    public void initialize(FlagValidator flagValidator) {
        values=flagValidator.value();
    }

    @Override
    public boolean isValid(Object  value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if(value==null){
            //当状态为空时使用默认值
            return true;
        }
        for(int i=0;i<values.length;i++){
            if(values[i].equals(String.valueOf(value))){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
