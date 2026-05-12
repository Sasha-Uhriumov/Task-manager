package com.sasha.task_manager.repository;

import com.sasha.task_manager.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusRepository, Long> {

    Optional<StatusEntity> findByStatusNameIgnoreCase(String statusName);
}
