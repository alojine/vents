package com.management.vently.repository;

import com.management.vently.domain.model.Password;
import com.management.vently.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {
    Password findByApplicationNameAndEmailAddressAndPassword(String applicationName, String emailAddress, String password);

    Optional<List<Password>> findAllByUser(User user);
}
