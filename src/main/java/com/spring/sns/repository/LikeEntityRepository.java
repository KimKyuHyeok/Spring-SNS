package com.spring.sns.repository;

import com.spring.sns.model.entity.LikeEntity;
import com.spring.sns.model.entity.PostEntity;
import com.spring.sns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {

    Optional<LikeEntity> findByUserAndPost(UserEntity userEntity, PostEntity postEntity);
    List<LikeEntity> findAllByPost(PostEntity postEntity);

    @Query(value = "SELECT COUNT(*) FROM LikeEntity entity WHERE entity.post =:post")
    Integer countByPost(@Param("post") PostEntity postEntity);
}
