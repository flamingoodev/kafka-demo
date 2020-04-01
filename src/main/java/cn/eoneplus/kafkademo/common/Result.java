package cn.eoneplus.kafkademo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:flamingodev@outlook.com">FLAMINGO</a>
 * @since 2019/12/31 10:06
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = -4268538782137525962L;
    private final static int UNKNOWN_ERROR = -1;
    private final static String MSG_UNKNOWN_ERROR = "未知错误";

    public Result() {
        put("code", 1);
        put("msg", "success");
    }

    public static Result error() {
        return error(UNKNOWN_ERROR, MSG_UNKNOWN_ERROR);
    }

    public static Result error(String msg) {
        return error(UNKNOWN_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
