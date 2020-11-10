package com.example.dubboapi.client;

import com.example.dubboapi.dto.UserDto;
import com.example.dubboapi.request.HttpResult;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    HttpResult<UserDto> queryUserByUserId(Integer userId);
}
