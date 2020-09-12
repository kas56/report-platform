package ru.plot.dto;

import ru.plot.entity.UserEntity;

import java.util.Arrays;
import java.util.List;

public class UserDto {

    private Long idUser;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(String dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
