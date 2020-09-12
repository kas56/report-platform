package ru.plot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.plot.dto.LoginDto;
import ru.plot.dto.SimpleResultDto;
import ru.plot.dto.UserDto;
import ru.plot.entity.UserEntity;
import ru.plot.repo.AuthRepository;
import ru.plot.repo.dao.AuthDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Service
public class AuthService {

    public final static String USER_SESSION_COOKIE = "session";

    private static final int ONE_YEAR = 31536000;

    private AuthRepository authRepository;

    private AuthDao authDao;

    @Autowired
    public AuthService(AuthRepository authRepository, AuthDao authDao) {
        this.authRepository = authRepository;
        this.authDao = authDao;
    }

    public UserDto getUserAndPermissions (String sessionKey) {
        UserEntity userEntity = authDao.getUserBySessionKey(sessionKey);

        if (userEntity == null) {
            throw new RuntimeException("Пользователь не авторизован");
        }

        return new UserDto(userEntity);
    }

    public SimpleResultDto login (LoginDto loginDto, HttpServletRequest req, HttpServletResponse resp) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();

        UserEntity userEntity = authDao.getUserEntityByEmail(email);

        if (userEntity == null) {
            throw new RuntimeException("Не верный email или пароль");
        }

        String salt = userEntity.getSalt();

        String hashpw = BCrypt.hashpw(password, salt);

        if (!hashpw.equals(userEntity.getPassword())) {
            throw new RuntimeException("Не верный email или пароль");
        }

        SimpleResultDto result = new SimpleResultDto();

        UUID session = UUID.randomUUID();

        authDao.createUserSession(userEntity, session);
        req.getSession().setAttribute(USER_SESSION_COOKIE, session.toString());

        Cookie cookie = new Cookie(USER_SESSION_COOKIE, session.toString());
        cookie.setMaxAge(ONE_YEAR);
        cookie.setPath("/");
        resp.addCookie(cookie);

        result.setSuccess(true);
        return result;
    }

}
