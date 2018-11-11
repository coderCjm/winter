package base.autumn.protocol.transport;

import base.autumn.model.User;
import lombok.Data;

/**
 * Created by sandog on 2018/11/10.
 */
@Data
public class AutumnResponse {

    public static final byte STATUS_SUCCESS = 1;
    public static final byte STATUS_FAIL = 2;

    private Byte status = STATUS_SUCCESS;

    private User user;

}
