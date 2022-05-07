package com.at.internship.schedule.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class ContactDto {
    private Integer id;
    @NotNull(message = "First name is required")
    @Length(min = 2, message = "First name should be at least two characters length")
    private String firstName;
    private String lastName;
    @Email(message = "Invalid email address")
    private String emailAddress;
    @Length(min = 10, max = 10, message = "Phone numbers contain 10 characters")
    @Digits(integer = 10, fraction = 0, message = "Phone number contains only digits")
    private String phoneNumber;
    private String birthDay;
}
