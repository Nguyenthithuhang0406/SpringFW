package com.vti.helloworld.service.impl;

import com.vti.helloworld.entity.Account;
import com.vti.helloworld.repository.AccountRepository;
import com.vti.helloworld.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optional = accountRepository.findByUserName(username);
        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        // Neu co thong tin nguoi dung, lay gia tri userName, password, danh sach quyen cua nguoi dung
        //de khoi tao

        Account account = optional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        //c1
        Account.Role role = account.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        authorities.add(authority);

        return new User(account.getUserName(), account.getPassword(), authorities) ;
    }
}
