package ru.plot.service;

import org.springframework.stereotype.Service;
import ru.plot.auth.PermissionHolder;
import ru.plot.dto.PermissionsDto;
import ru.plot.dto.UserDto;

@Service
public class PermissionService {

    public PermissionsDto getUserPermissions () {
        PermissionsDto permissionsDto = new PermissionsDto();

        UserDto userDto = PermissionHolder.getUserInfo();

        if (userDto == null) {
            return permissionsDto;
        }

        if (userDto.getRoles().contains("ADMIN")) {
            permissionsDto.setAdmin(true);
        }

        if (userDto.getRoles().contains("OPER")) {
            permissionsDto.setOper(true);
        }

        if (userDto.getRoles().contains("AUDITOR ")) {
            permissionsDto.setAuditor(true);
        }

        return permissionsDto;
    }
}
