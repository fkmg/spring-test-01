package com.sxt.service;

import com.sxt.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 根据用户账户名称获取资源
     * @param account
     * @return
     */
    List<String> getUserPermissionsByAccount(String account);

    /**
     * 通过用户名获取角色信息
     * @param account
     * @return
     */
    List<String> getUserRolesByAccount(String account);

    /**
     * 通过账户获取用户信息
     * @param account
     * @return
     */
    User getUserByAccount(String account);
}
