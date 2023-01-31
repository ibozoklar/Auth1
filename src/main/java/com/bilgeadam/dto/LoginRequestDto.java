package com.bilgeadam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequestDto {

    String password;

    @Email
    String email;
}
