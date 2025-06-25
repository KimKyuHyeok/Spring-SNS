package com.spring.sns.repository;

import com.spring.sns.model.entity.LikeEntity;
import com.spring.sns.model.entity.PostEntity;
import com.spring.sns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {

    Optional<LikeEntity> findByUserAndPost(UserEntity userEntity, PostEntity postEntity);
}
