package com.me.sys.dao;

import com.me.sys.entity.UserPo;

public interface UserDao {
    int delete(Integer id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo get(Integer id);

    int updateSelective(UserPo record);

    int update(UserPo record);
}