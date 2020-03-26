package com.macro.mall.tiny.component.valid;

import com.macro.mall.tiny.component.valid.modal.CanEmptyValueValidatorImpl;
import com.macro.mall.tiny.component.valid.modal.FlagValidatorClass;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = CanEmptyValueValidatorImpl.class)
public @interface CanEmptyValueValidator {
    String parrern() default "";

    String message() default "flag is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
