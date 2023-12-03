package com.br.srv.saudeconnect.dataprovider.repository;

import com.br.srv.saudeconnect.dataprovider.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, String> {
    Optional<SchoolEntity> findBySchoolName(String schoolName);

    Optional<SchoolEntity> findByAccount_AccountId(String accountId);
}
