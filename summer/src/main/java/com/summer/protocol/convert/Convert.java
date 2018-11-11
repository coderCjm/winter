package com.summer.protocol.convert;

import base.autumn.model.User;
import com.summer.protocol.vo.UserVO;

/**
 * Created by sandog on 2018/11/11.
 */
public class Convert {

    public static UserVO convertUser(User input) {
        if (input == null) {
            return null;
        }
        UserVO result = new UserVO();
        result.setId(input.getId());
        result.setName(input.getName());
        return result;
    }

    public static User convertUser(UserVO input) {
        if (input == null) {
            return null;
        }
        return new User(input.getId(), input.getName());
    }

}
