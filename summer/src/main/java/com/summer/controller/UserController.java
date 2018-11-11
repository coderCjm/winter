package com.summer.controller;

import base.autumn.model.User;
import base.autumn.protocol.transport.AutumnResponse;
import com.summer.feign.UserFeignClient;
import com.summer.protocol.convert.Convert;
import com.summer.protocol.transport.SummerResponse;
import com.summer.protocol.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sandog on 2018/11/10.
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/get", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public SummerResponse GetUser(@Validated Integer id) {
        AutumnResponse autumnResponse = userFeignClient.findById(id);
        SummerResponse response = new SummerResponse();
        response.setUser(Convert.convertUser(autumnResponse.getUser()));
        System.out.println(response);
        return response;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public SummerResponse AddUser(@Validated String name) {
        userFeignClient.addUser(getUser(name));
        System.out.println(name);
        return new SummerResponse();
    }

    private User getUser(String name) {

        UserVO vo = new UserVO();
        vo.setName(name);
        User user = Convert.convertUser(vo);
        return user;
    }

}
