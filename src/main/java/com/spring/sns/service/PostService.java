package com.spring.sns.service;

import com.spring.sns.exception.ErrorCode;
import com.spring.sns.exception.SnsApplicationException;
import com.spring.sns.model.entity.PostEntity;
import com.spring.sns.model.entity.UserEntity;
import com.spring.sns.repository.PostEntityRepository;
import com.spring.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String body, String userName) {
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        postEntityRepository.save(PostEntity.of(title, body, userEntity));
    }
}
