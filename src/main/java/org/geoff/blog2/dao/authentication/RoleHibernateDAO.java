package org.geoff.blog2.dao.authentication;

import javax.annotation.Resource;

import org.geoff.blog2.domain.authentication.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("roleDAO")
public class RoleHibernateDAO implements RoleDAO {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Role getRole(int id) {
        Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
    }

}
