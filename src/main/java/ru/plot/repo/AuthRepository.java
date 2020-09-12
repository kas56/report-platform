package ru.plot.repo;

import org.springframework.data.repository.CrudRepository;
import ru.plot.entity.UserEntity;

public interface AuthRepository extends CrudRepository<UserEntity, Long> {

    UserEntity getUserEntityByEmailAndPassword(String email, String password);

}
