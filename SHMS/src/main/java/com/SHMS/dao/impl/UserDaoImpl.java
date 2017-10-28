package com.SHMS.dao.impl;

import com.SHMS.dao.UserDao;
import com.SHMS.dao.base.BaseDaoImpl;
import com.SHMS.model.DbUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<DbUser> implements UserDao {
    
    public DbUser getDatabase(String username) {  
        List<DbUser> users = internalDatabase();
        for (DbUser user : users) {
            if (user.getUsername().equals(username)) {
            	 return user;
            }
        }  
        throw new RuntimeException("User does not exist!");    
    }

    public List<DbUser> internalDatabase() {
        String hql="from com.SHMS.model.DbUser";
        List<DbUser> users = this.findAllByHQL(hql);
        return users;
   
    }  
}