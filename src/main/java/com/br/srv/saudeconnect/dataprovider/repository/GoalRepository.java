package com.br.srv.saudeconnect.dataprovider.repository;

import com.br.srv.saudeconnect.dataprovider.entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, String> {}
