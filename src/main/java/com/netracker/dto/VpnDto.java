package com.netracker.dto;


import com.netracker.validation.message.ConstraintMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.UUID;

@ToString
@Getter
@Setter
public class VpnDto {

    private UUID vpnServiceId;
    @NotBlank(message = ConstraintMessage.Field.TITLE + ConstraintMessage.Constraint.IS_EMPTY)
    private String title;
    @NotNull(message = ConstraintMessage.Field.EXPIRATION_DATE + ConstraintMessage.Constraint.IS_EMPTY)
    private Timestamp expirationDate;
    @NotBlank(message = ConstraintMessage.Field.PASSWORD + ConstraintMessage.Constraint.IS_EMPTY)
    @Size(min = 5, message = ConstraintMessage.Field.PASSWORD + ConstraintMessage.Constraint.TOO_SHORT)
    private String password;
}
