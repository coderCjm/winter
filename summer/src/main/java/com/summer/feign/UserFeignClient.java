package com.summer.feign;

import base.autumn.model.User;
import base.autumn.protocol.transport.AutumnResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandog on 2018/11/10.
 */
@FeignClient(name = "autumn", fallbackFactory = UserFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    AutumnResponse findById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    AutumnResponse addUser(@RequestBody User user);

}

@Component(value = "fallbackFactory")
class UserFallback implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        throwable.printStackTrace();
        return new UserFeignClient() {
            @Override
            public AutumnResponse findById(Integer id) {
                AutumnResponse response = new AutumnResponse();
                response.setStatus(AutumnResponse.STATUS_FAIL);
                response.setUser(new User(0, "默认用户"));
                return response;
            }

            @Override
            public AutumnResponse addUser(User user) {
                AutumnResponse response = new AutumnResponse();
                response.setStatus(AutumnResponse.STATUS_FAIL);
                return response;
            }
        };
    }

}