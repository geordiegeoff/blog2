package org.geoff.blog2.service.authentication;

import org.geoff.blog2.domain.authentication.User;

public interface UserService {

    User getUser(String username);
}
