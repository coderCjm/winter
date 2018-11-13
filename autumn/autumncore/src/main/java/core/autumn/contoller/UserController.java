package core.autumn.contoller;

import base.autumn.protocol.transport.AutumnResponse;
import base.autumn.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sandog on 2018/11/10.
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    private static Map<Integer, User> map = new ConcurrentHashMap<Integer, User>();

    static {
        map.put(1, new User(1, "傅红雪"));
        map.put(2, new User(2, "李寻欢"));
        map.put(3, new User(3, "任我行"));
        map.put(4, new User(4, "令狐冲"));
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public AutumnResponse GetUser(Integer id) {
        AutumnResponse response = new AutumnResponse();
        User user = findUserById(id);
        if (user == null) {
            response.setStatus(AutumnResponse.STATUS_FAIL);
            return response;
        }
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        response.setUser(user);
        System.out.println(response.toString());
        return response;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    public AutumnResponse PdPurchase(@RequestBody User user) {
        int len = map.size();
        int id = len + 1;
        User iUser = new User(id, user.getName());
        map.put(id, iUser);
        AutumnResponse response = new AutumnResponse();
        response.setUser(iUser);
        return response;
    }

    private User findUserById(int id) {
        return map.get(id);
    }

}
