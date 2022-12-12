package cn.cs.springframework.test.bean;

import cn.cs.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cs
 * @Date 2022-12-12 17:33
 */
@Component
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "cs，hz，xh");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
