package com.fancx.common.util;

import java.time.LocalDateTime;
import java.util.Random;

public class UUIDUtil {
    /**
     * 利用当前时间和Random函数实现唯一ID
     * @return
     */
    public static synchronized String getUUID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(LocalDateTime.now().toString());
        for (int i = 0; i < sb.length(); i++) {
            char cur = sb.charAt(i);
            if (cur == '-' || cur == ':' || cur == '.') {
                cur = (char) ('A' + random.nextInt(26));
                sb.replace(i, i + 1, String.valueOf(cur));
            }
        }
        return sb.reverse().toString();
    }
}
