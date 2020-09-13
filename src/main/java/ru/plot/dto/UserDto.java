package ru.plot.dto;

import lombok.Getter;
import lombok.Setter;
import ru.plot.entity.UserEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private BigInteger idUser;

    private String dtUpdate;

    private Long orgId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String position;

    private String email;

    private String salt;

    private String password;

    private List<String> roles;

    public UserDto() {
    }

    public UserDto(UserEntity userEntity) {
        this.idUser = userEntity.getIdUser();
        this.dtUpdate = userEntity.getDtUpdate();
        this.orgId = userEntity.getOrgId();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.middleName = userEntity.getMiddleName();
        this.position = userEntity.getPosition();
        this.email = userEntity.getEmail();
        this.salt = userEntity.getSalt();
        this.password = userEntity.getPassword();
        this.roles = Arrays.asList(userEntity.getRoles().split(","));
    }
}
