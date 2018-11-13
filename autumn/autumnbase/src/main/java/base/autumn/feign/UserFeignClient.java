package base.autumn.feign;

import base.autumn.model.User;
import base.autumn.protocol.transport.AutumnResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sandog on 2018/11/13.
 */
@FeignClient(name = "autumn", fallbackFactory = UserFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    AutumnResponse findById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    AutumnResponse addUser(@RequestBody User user);

}