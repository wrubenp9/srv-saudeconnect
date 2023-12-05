package com.br.srv.saudeconnect.dataprovider.repository;

import com.br.srv.saudeconnect.dataprovider.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    Optional<StudentEntity> findByFullName(String fullName);

    Optional<StudentEntity> findByAccount_AccountId(String accountId);

    void deleteByAccount_AccountId(String accountId);
}
