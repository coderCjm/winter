package com.moon.executor;

import base.autumn.feign.UserFeignClient;
import base.autumn.model.User;
import base.autumn.protocol.transport.AutumnResponse;
import com.moon.SpringUtil;

/**
 * Created by sandog on 2018/11/15.
 */
public class UserExecutor {

    private static class Holder {
        private static final UserExecutor singleton = new UserExecutor();
    }

    public static UserExecutor getInstance() {
        return UserExecutor.Holder.singleton;
    }

    private UserExecutor() {
        userFeignClient = SpringUtil.getBean(UserFeignClient.class);
    }

    private UserFeignClient userFeignClient;

    public AutumnResponse addUser(User user) {
        return userFeignClient.addUser(user);
    }

}
