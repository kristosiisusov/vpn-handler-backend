package com.netracker.validation.annotations;

import com.netracker.validation.message.ConstraintMessage;
import com.netracker.validation.validator.ConstraintVpnExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = ConstraintVpnExistsValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface VpnExists {
    String message() default ConstraintMessage.Field.VPN_ID + ConstraintMessage.Constraint.NOT_EXISTS;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
