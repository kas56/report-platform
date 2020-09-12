package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.UserEntity;

import java.math.BigInteger;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {
    UserEntity getUserEntitiesByEmail(String email);
}
