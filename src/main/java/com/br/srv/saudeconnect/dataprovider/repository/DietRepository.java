package com.br.srv.saudeconnect.dataprovider.repository;

import com.br.srv.saudeconnect.dataprovider.entity.DietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<DietEntity, String> {}
