package com.mb.software.ecampus.core.security.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * When user login, registers or refresh his password. It encodes or decodes to passwords.
 * @author Berat Yesbek (Feanor)
 */
public class PasswordHelper {

    public static String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static boolean verifyPassword(String password, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(password, encodedPassword);
    }
}
