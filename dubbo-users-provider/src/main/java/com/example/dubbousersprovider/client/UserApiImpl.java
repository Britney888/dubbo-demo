package com.example.dubbousersprovider.client;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.dubboapi.client.UserApi;
import com.example.dubboapi.dto.UserDto;
import com.example.dubboapi.request.HttpResult;
import com.example.dubbousersprovider.entity.TUmUser;
import com.example.dubbousersprovider.service.ITUmUserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

/**
 * @Description TODO
 * @Author ning
 * @Date 2020/10/28 14:52
 */
@Service(version = "1.0")
public class UserApiImpl implements UserApi {
    @Autowired
    ITUmUserService umUserService;
    @Override
    public HttpResult<UserDto> queryUserByUserId(Integer userId) {
        TUmUser user=umUserService.getOne(Wrappers.<TUmUser>lambdaQuery().eq(TUmUser::getId, userId));
        UserDto userDto=new UserDto();
        if (!Optional.ofNullable(user).isPresent()){
            return null;
        }
        BeanUtils.copyProperties(user,userDto);
        return new HttpResult<>(userDto);
    }
}
