package com.spring.sns.controller;

import com.spring.sns.controller.request.UserJoinRequest;
import com.spring.sns.controller.request.UserLoginRequest;
import com.spring.sns.controller.response.AlarmResponse;
import com.spring.sns.controller.response.Response;
import com.spring.sns.controller.response.UserJoinResponse;
import com.spring.sns.controller.response.UserLoginResponse;
import com.spring.sns.model.Alarm;
import com.spring.sns.model.User;
import com.spring.sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        User user = userService.join(request.getName(), request.getPassword());
        return Response.success(UserJoinResponse.fromUser(user));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }

    @GetMapping("/alarm")
    public Response<Page<AlarmResponse>> alarm(Pageable pageable, Authentication authentication) {
        return Response.success(userService.alarmList(authentication.getName(), pageable).map(AlarmResponse::fromAlarm));
    }
}
