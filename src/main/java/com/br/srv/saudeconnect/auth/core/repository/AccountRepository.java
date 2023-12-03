package com.br.srv.saudeconnect.auth.core.repository;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByEmail(String email);

    Boolean existsByEmail(String email);
}
