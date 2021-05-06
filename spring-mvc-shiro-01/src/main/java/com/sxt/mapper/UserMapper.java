package com.sxt.mapper;

import com.sxt.bean.User;
import com.sxt.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

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