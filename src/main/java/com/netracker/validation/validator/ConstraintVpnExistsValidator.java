package com.netracker.validation.validator;
import com.netracker.services.implementation.VpnService;
import com.netracker.validation.annotations.VpnExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class ConstraintVpnExistsValidator implements ConstraintValidator<VpnExists, UUID> {

    private final VpnService vpnService;

    @Autowired
    public ConstraintVpnExistsValidator(VpnService vpnService) {
        this.vpnService = vpnService;
    }

    @Override
    public void initialize(VpnExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext constraintValidatorContext) {
        return vpnService.existsById(uuid);
    }
}
