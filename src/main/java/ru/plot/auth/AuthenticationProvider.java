package ru.plot.auth;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider, InitializingBean, Ordered {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public int getOrder() {
        return -1;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
