package ru.plot.repo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.plot.entity.UserEntity;
import ru.plot.utils.CommonUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class AuthDao {


    @PersistenceContext
    private EntityManager em;

    public UserEntity getUserEntityByEmail (String email) {
        String sql = "select * from h2020.users where s_email = :email";

        Query query = em.createNativeQuery(sql, UserEntity.class);
        query.setParameter("email", email);
//        query.setParameter("passw", password);

        List<UserEntity> resultList = (List<UserEntity>)query.getResultList();

        if (CommonUtils.isNullOrEmpty(resultList)) {
            return null;
        }

        return resultList.get(0);
    }

    @Transactional
    public void createUserSession(UserEntity userEntity, UUID sessionId) {

        String sql = "insert into h2020.user_session (create_time, session_key, user_id) values (now(), :sessionId, :userId)";

        Query query = em.createNativeQuery(sql);
        query.setParameter("sessionId", sessionId.toString());
        query.setParameter("userId", userEntity.getIdUser());

        query.executeUpdate();
    }

    public UserEntity getUserBySessionKey (String sessionKey) {
        String sql = "select * from h2020.users u " +
                "join h2020.user_session us on us.user_id = u.id_users" +
                " where us.session_key = :sessionKey";

        Query query = em.createNativeQuery(sql, UserEntity.class);
        query.setParameter("sessionKey", sessionKey);

        List<UserEntity> resultList = (List<UserEntity>)query.getResultList();

        if (CommonUtils.isNullOrEmpty(resultList)) {
            return null;
        }

        return resultList.get(0);
    }


}
