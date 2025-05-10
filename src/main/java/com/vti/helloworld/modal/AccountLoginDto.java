package com.vti.helloworld.modal;

import com.vti.helloworld.entity.Account;
import lombok.Data;

@Data
public class AccountLoginDto {
    private String userName;
    private String mail;
    private String token;
}
