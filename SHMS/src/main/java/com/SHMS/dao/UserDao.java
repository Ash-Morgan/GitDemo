package com.SHMS.dao;

import com.SHMS.dao.base.BaseDao;
import com.SHMS.model.DbUser;

import java.util.List;

/*
    Author:Administrator
    Time:2017/10/14 11:01
*/
public interface UserDao extends BaseDao<DbUser> {
    DbUser getDatabase(String username);

    List<DbUser> internalDatabase();
}
