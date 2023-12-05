package com.br.srv.saudeconnect.dataprovider.repository;

import com.br.srv.saudeconnect.dataprovider.entity.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<ProfessionalEntity, String> {
    Optional<ProfessionalEntity> findByAccount_AccountId(String accountId);

    Optional<ProfessionalEntity> findByFullName(String fullName);

    void deleteByAccount_AccountId(String accountId);
}
