package cn.cs.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cs
 * @Date 2022-11-25 16:17
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "cs");
        hashMap.put("10002", "cs2");
        hashMap.put("10003", "cs3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
