package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select e from User e where e.userName = :userName a")
    Optional<User> findUserByName(
            @Param("userName") String userName);
}
