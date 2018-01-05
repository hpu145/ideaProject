package com.kaishengit.tms.auth;


import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.Role;
import com.kaishengit.tms.system.service.SynthesizeLoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SynthesizeLoginService synthesizeLoginService;

    /**
     * 角色或权限认证使用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录的对象
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        //根据登录的对象获取角色列表
        List<Role> roles = synthesizeLoginService.findRoleByAccount(account.getId());

        //获取Role集合中的名称，创建字符串列表
        List<String> roleNameList = new ArrayList<>();
        for(Role role : roles) {
            roleNameList.add(role.getRoleName());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //作为当前用户的角色
        simpleAuthorizationInfo.addRoles(roleNameList);
        return simpleAuthorizationInfo;
    }


    /**
     * 登录认证使用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String accountMobile = usernamePasswordToken.getUsername();
        Account account = synthesizeLoginService.findAccountByTel(accountMobile);

        if(account != null) {
            return new SimpleAuthenticationInfo(account,account.getAccountPassword(),getName());
        }
        return null;
    }
}
