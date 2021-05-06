package com.sxt.shiro.realm;

import com.sxt.bean.User;
import com.sxt.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class ShiroRelam  extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 授权
     * @param principal
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        User user =(User) principal.getPrimaryPrincipal();
        String account = user.getAccount();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户名获取角色信息
        try {
            List<String> roles = userService.getUserRolesByAccount(account);
            info.addRoles(roles);
            //利用账户名从数据库中查询出所有的权限名称
            List<String> permissions = userService.getUserPermissionsByAccount(account);
            info.addStringPermissions(permissions);
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String)token.getPrincipal();
        System.out.println(account);

        User user = userService.getUserByAccount(account);
        if(user!=null) {
            String password = user.getPassword();
            System.out.println(password);
            user.setPassword("**********");
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(user.getSalt()),this.getName());
            return info;
        }
        return null;

    }
}
