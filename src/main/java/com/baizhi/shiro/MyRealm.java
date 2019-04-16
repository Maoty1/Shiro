package com.baizhi.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String principal = (String) usernamePasswordToken.getPrincipal();
        String s = usernamePasswordToken.getPassword().toString();

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal , s , ByteSource.Util.bytes("abcd") , getName());

        
        return authenticationInfo;
    }
}
