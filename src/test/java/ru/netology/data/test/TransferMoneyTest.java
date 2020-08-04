package ru.netology.data.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.data.DataHelper;
import ru.netology.data.page.LoginPage;


import static com.codeborne.selenide.Selenide.open;

public class TransferMoneyTest {



@Test
    void validLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerifyCode(authInfo);
        verificationPage.validVerify(verificationCode);
    }
}

