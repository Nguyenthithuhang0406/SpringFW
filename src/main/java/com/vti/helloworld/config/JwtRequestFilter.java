package com.vti.helloworld.config;

import com.vti.helloworld.utils.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // lay token
        String token = request.getHeader("Authorization") != null ? request.getHeader("Authorization").substring(7) : "";

        //Giai ma token, neu token khong hop le, het han... => tra ve null thong itn dang nhap
        // neu token hop le => lay ra thong tin user tu token UsernamePasswordAuthenticationToken authentication = JwtUtils.checkToken(token, request);
        UsernamePasswordAuthenticationToken authentication = JwtUtils.checkToken(token, request);

        // Set đối tượng Athen trên vào Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //do filter den buoc tiep theo
        filterChain.doFilter(request, response);
    }
}
