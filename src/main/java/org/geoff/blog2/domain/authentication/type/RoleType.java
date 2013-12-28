package org.geoff.blog2.domain.authentication.type;

import java.util.Arrays;
import java.util.List;

public enum RoleType {
    MOD("ROLE_MODERATOR"),
    ADMIN("ROLE_ADMIN", "ROLE_MODERATOR"),
    USER("ROLE_USER");
    
    private String[] securityRoles;
    
    private RoleType(String... securityRoles) {
        this.securityRoles = securityRoles;
    }
    
    public List<String> getSecurityRolesAsList() {
        return Arrays.asList(securityRoles);
    }
}


