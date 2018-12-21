package com.walker.user.util;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author walker
 * @date 2018/12/21
 */
public class BPwdEncoderUtil {

    private static PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public static String encode(String password) {
        return encoder.encode(password);
    }

    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
