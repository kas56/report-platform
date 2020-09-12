package ru.plot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.j2ee.J2eePreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;
import ru.plot.dto.UserDto;
import ru.plot.service.AuthService;
import ru.plot.utils.CommonUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthFilter extends J2eePreAuthenticatedProcessingFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    private AuthService authService;

    @Autowired
    public AuthFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    private boolean isPublicRes (String path) {
        if (path.contains("report") || "/".equals(path)) {
            return false;
        }

        if (path.startsWith("/api/public")) {
            return true;
        }

        if (!path.startsWith("/api")) {
            return true;
        }

        /*if (path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".html") || path.endsWith(".jpg")) {
            return true;
        }*/

        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        ((HttpServletRequest) request).getContextPath();
        String servletPath = ((HttpServletRequest) request).getServletPath();

        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        String sessionKey = null;

        for (Cookie cookie : cookies) {
            if (AuthService.USER_SESSION_COOKIE.equals(cookie.getName())) {
                sessionKey = cookie.getValue();
                break;
            }
        }

        if (isPublicRes(servletPath)) {
            super.doFilter(request, response, chain);
            return;
        }

        if (CommonUtils.isNullOrEmpty(sessionKey)) {
            RequestDispatcher rd = ((HttpServletRequest) request).getRequestDispatcher("/login");
            rd.forward(request,response);
//            ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
//            throw new RuntimeException("Пользователь не авторизован");
        }

        try {
            UserDto userDto = authService.getUserAndPermissions(sessionKey);
//            ((HttpServletRequest) request).getUserPrincipal()
        } catch (Exception ex) {
            LOGGER.error("");
//            ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            RequestDispatcher rd = ((HttpServletRequest) request).getRequestDispatcher("/login");
            rd.forward(request,response);
            return;
        }


        super.doFilter(request, response, chain);
    }




}
