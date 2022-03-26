package com.jiangqian.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import java.net.Authenticator;

public class JwtToken implements AuthenticationToken {

    private String token;

    private JwtToken(String jwt ){
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}
