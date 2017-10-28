package com.SHMS.service;

import com.SHMS.dao.impl.UserDaoImpl;
import com.SHMS.model.DbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * service
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDaoImpl userDao;


    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserDetails user;

        try {
            DbUser dbUser = userDao.getDatabase(username);
            String password = dbUser.getPassword().toLowerCase();
            Collection<GrantedAuthority> authorities = getAuthorities(dbUser.getAccess());
            boolean accountNonExpired = true;
            boolean accountNonLocked = true;
            boolean credentialsNonExpired = true;
            user = new User(username, password, true, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }

    /**
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        //        ROLE_USER
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        //        ROLE_ADMIN
        if (access.compareTo(1) == 0) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return authList;
    }
}