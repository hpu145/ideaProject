package com.kaishengit.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 自定义Realm,实现Realm接口
 * Created by zhangyu on 2017/11/24.
 */
public class MyRealm implements Realm{
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取账号
        String name = token.getUsername();
        //获取密码
        String password = new String(token.getPassword());

        if (!"tom".equals(name)) {
            throw new UnknownAccountException("账号不存在");
        }
        if (!"123456".equals(password)) {
            throw new IncorrectCredentialsException("账号或密码错误");
        }
        //判断认证是否成功
        return new SimpleAuthenticationInfo(name,password,getName());
    }
}
