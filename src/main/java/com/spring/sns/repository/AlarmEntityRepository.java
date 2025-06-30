package com.spring.sns.repository;

import com.spring.sns.model.entity.AlarmEntity;
import com.spring.sns.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmEntityRepository extends JpaRepository<AlarmEntity, Integer> {

    Page<AlarmEntity> findAllByUser(UserEntity user, Pageable pageable);
}
