package org.geoff.blog2.dao.authentication;

import javax.annotation.Resource;

import org.geoff.blog2.domain.authentication.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserHibernateDAO implements UserDAO {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    
    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findUser(String username) {
        Query query = openSession().createQuery("from User u where u.username = :username");
        query.setString("username", username);
        query.setCacheable(true);
        return (User)query.uniqueResult();
    }

}
