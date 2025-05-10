package com.vti.helloworld.controller;

import com.vti.helloworld.entity.Account;
import com.vti.helloworld.modal.AccountLoginDto;
import com.vti.helloworld.repository.AccountRepository;
import com.vti.helloworld.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    public Account login(){
//        // lấy thông tin user đang đăng nhập
//        String userName = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
//
//    }

    @PostMapping("/login-jwt")
    public ResponseEntity<?> loginJwt(@RequestParam String userName, @RequestParam String password, HttpServletRequest httpServletRequest) {
        Optional<Account> optional = accountRepository.findByUserName(userName);
        if (optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("User name không tồn tại trong hệ thống!");
        }
        Account account = optional.get();
        if (!passwordEncoder.matches(password, account.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Sai pasword!");
        }

        String token = JwtUtils.createToken(account, httpServletRequest);

        AccountLoginDto dto = new AccountLoginDto();
        dto.setMail(account.getEmail());
        dto.setUserName(account.getUserName());
        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }
}
