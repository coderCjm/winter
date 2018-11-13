package base.autumn.feign;

import base.autumn.model.User;
import base.autumn.protocol.transport.AutumnResponse;
import feign.hystrix.FallbackFactory;

/**
 * Created by sandog on 2018/11/13.
 */
public class UserFallback implements FallbackFactory<UserFeignClient> {

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