package ru.plot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.plot.dto.LoginDto;
import ru.plot.dto.SimpleResultDto;
import ru.plot.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/public/login")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public SimpleResultDto getIndexPage(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse resp) {
        return authService.login(loginDto, request, resp);
    }

}
