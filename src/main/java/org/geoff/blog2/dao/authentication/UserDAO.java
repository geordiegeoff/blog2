package org.geoff.blog2.dao.authentication;

import org.geoff.blog2.domain.authentication.User;

public interface UserDAO {
    
    public User findUser(String username);
}
