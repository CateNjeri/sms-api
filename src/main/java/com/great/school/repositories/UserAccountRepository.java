package com.great.school.repositories;

import com.great.school.models.data.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Kibet on 25-Nov-17.
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUsername(String username);

    Optional<UserAccount> findByUsernameOrEmail(String username, String email);

    Optional<UserAccount> findByEmail(String email);

    Optional<UserAccount> findByEmailAndType(String email, int type);
}
