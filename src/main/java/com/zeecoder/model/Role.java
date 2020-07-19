package com.zeecoder.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getName(){
        return role;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}