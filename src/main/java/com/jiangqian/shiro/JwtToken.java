package com.jiangqian.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import java.net.Authenticator;

public class JwtToken implements AuthenticationToken {

    private String token;

    JwtToken(String jwt){
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
