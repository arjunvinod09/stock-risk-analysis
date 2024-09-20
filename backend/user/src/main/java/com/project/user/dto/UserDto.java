package com.project.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDto(

        @NotEmpty
        int id,

        @NotEmpty
        String username,

        @NotEmpty(message = "Password must not be null")
        @Length(min = 8,max = 20)
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,20}$", message = "Password must contain at least one digit, one lowercase, one uppercase letter, and one special character")
        String password,

        @NotEmpty(message = "Email must not be null")
        @Email
        String email,

        @NotEmpty(message = "Firstname must not be null")
        String firstName,

        @NotEmpty(message = "Lastname must not be null")
        String lastName


//
//        @Past
//        Date dob,
//
//        String address,
//
//        @Pattern(regexp = "^(?:\\+?1\\s*[-.\\(\\)]?)?(\\(?\\d{3}\\)?[\\s-]?)?[\\d\\s-]{3}[\\d\\s-]{4}$\n")
//        String phone,
//
//        String profilePic,
//
//        Date registrationDate
) {
}
