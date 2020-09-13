package ru.plot.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.camel.util.StreamUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "users", schema = "h2020")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private BigInteger idUser;

    @Column(name = "dt_update")
    private String dtUpdate;

    @Column(name = "id_org")
    private Long orgId;
    @ManyToOne
    @JoinColumn(name = "id_org", insertable = false, updatable = false)
    private Organizations organization;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="grant_org_user", schema = "h2020" ,
            joinColumns = @JoinColumn( name="id_user"),
            inverseJoinColumns = @JoinColumn( name="id_org")
    )
    private List<Organizations> grantOrgs;


    @Column(name = "s_firstname")
    private String firstName;

    @Column(name = "s_secondname")
    private String lastName;

    @Column(name = "s_middlename")
    private String middleName;

    @Column(name = "s_position")
    private String position;

    @Column(name = "s_email")
    private String email;

    @Column(name = "salt")
    private String salt;


    @Column(name = "s_password")
    private String password;

    @Column(name = "s_roles")
    private String roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null) return null;

        List<SimpleGrantedAuthority> collect = Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
