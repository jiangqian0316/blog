package com.jiangqian.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.jiangqian.entity.User;
import com.jiangqian.service.UserService;
import com.jiangqian.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    /**
     * 用来确认token是不是JwtToken
     * */

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     *
     * doGetAuthorizationInfo -- 获取授权信息
     * AuthorizationInfo -- 授权信息
     * */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * token -- 令牌
     * doGetAuthenticationInfo -- 获取身份验证信息
     * AuthenticationInfo -- 认证信息
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));
        if (user == null){
            throw new UnknownAccountException("账户不存在");
        }
        if (user.getStatus() == -1){
            throw new LockedAccountException("账号已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        /*
        * 把user的值复制导profile
        * */
        BeanUtil.copyProperties(user,profile);


        System.out.println("--------------");
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName()
        );
    }
}
