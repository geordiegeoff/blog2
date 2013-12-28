package org.geoff.blog2.service.authentication;

import javax.annotation.Resource;

import org.geoff.blog2.dao.authentication.RoleDAO;
import org.geoff.blog2.domain.authentication.Role;
import org.springframework.stereotype.Component;

@Component("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource(name="roleDAO")
    private RoleDAO roleDAO;
    
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }
}
