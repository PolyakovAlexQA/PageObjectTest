package ru.netology.data.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.data.DataCard.getNumberCard;
import static ru.netology.data.data.DataHelper.getAuthInfo;
import static ru.netology.data.data.DataHelper.getVerifyCode;

public class TransferMoneyTest {

    @Test
    void validLogin() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = getVerifyCode(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldSuccessfulTransferFromSecondToFirst() {
        int amount = 1000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = getVerifyCode(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val dataCard = getNumberCard();
        val balanceFirst = dashboardPage.getFirstCardBalance();
        val balanceSecond = dashboardPage.getSecondCardBalance();
        val moneyPage = dashboardPage.MoveCardOne();
        moneyPage.endMoneyPage(amount, dataCard.getSecondNumber());
        assertEquals(balanceFirst + amount, dashboardPage.getFirstCardBalance());
        assertEquals(balanceSecond - amount, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldSuccessfulTransferFromFirstToSecond() {
        int amount = 1000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = getVerifyCode(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val dataCard = getNumberCard();
        val balanceFirst = dashboardPage.getFirstCardBalance();
        val balanceSecond = dashboardPage.getSecondCardBalance();
        val moneyPage = dashboardPage.MoveCardTwo();
        moneyPage.endMoneyPage(amount, dataCard.getFirstNumber());
        assertEquals(balanceFirst - amount, dashboardPage.getFirstCardBalance());
        assertEquals(balanceSecond + amount, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldBalance0TransferFromSecondToFirst() {
        int amount = 0;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = getVerifyCode(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val dataCard = getNumberCard();
        val balanceFirst = dashboardPage.getFirstCardBalance();
        val balanceSecond = dashboardPage.getSecondCardBalance();
        val moneyPage = dashboardPage.MoveCardOne();
        moneyPage.endMoneyPage(amount, dataCard.getSecondNumber());
        assertEquals(balanceFirst + amount, dashboardPage.getFirstCardBalance());
        assertEquals(balanceSecond - amount, dashboardPage.getSecondCardBalance());
    }

}