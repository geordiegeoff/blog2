package org.geoff.blog2.service.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.geoff.blog2.dao.authentication.UserDAO;
import org.geoff.blog2.domain.authentication.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService, UserDetailsService {

    @Resource(name="userDAO")
    private UserDAO userDAO;

    @Override
    public User getUser(String username) {
        return userDAO.findUser(username.trim()); //should we trim here?
    }
    

    // Spring security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            
        User user = userDAO.findUser(username);

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), true, true, true, true,
            getGrantedAuthorities(user.getRole().getRole().getSecurityRolesAsList()));
    }

        
    private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        
        return authorities;
    }
}
