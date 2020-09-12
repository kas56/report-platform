package ru.plot.auth;

import ru.plot.dto.UserDto;

public class PermissionHolder {

    public static final ThreadLocal<UserDto> userInfoDto = new ThreadLocal<>();;

    public static UserDto getUserInfo () {
        return userInfoDto.get();
    }

    public static void setUserInfo (UserDto userDto) {
        userInfoDto.set(userDto);
    }

}
