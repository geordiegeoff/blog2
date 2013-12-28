package org.geoff.blog2.domain.authentication;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.geoff.blog2.domain.authentication.type.RoleType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="role")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Role {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private RoleType role;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", 
        joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
    )
    private Set<User> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }
    
}
