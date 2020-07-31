package ru.netology.data.data;

import lombok.Value;


public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerifyCode {
        private String code;
    }

    public static VerifyCode getVerifyCode(AuthInfo authInfo) {
        return new VerifyCode("12345");
    }


}

