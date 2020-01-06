package com.example.demo.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "UserName is required")
    @Size(min = 4, max = 8)
    private String userName;

    @NotNull(message = "PassWorld is required")
    @Size(min = 4, max = 8)
    private String passWorld;

    @NotNull(message = "Fullname is required")
    private String fullName;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @ApiModelProperty(
            example="sam.smith@gmail.com",
            notes="Email cannot be empty",
            required=true
    )
    private String email;

    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    @ApiModelProperty(
            example="0916016972",
            notes="Phone cannot be empty",
            required=true
    )
    private String phone;

    @NotNull(message = "Role is required")
    private int role;

    private boolean active;
}
