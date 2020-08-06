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
        val loginPage = new LoginPage(); // создаем объект (страница ввода имени и логина)
        val authInfo = getAuthInfo(); // берем информацию с класса authInfo
        val verificationPage = loginPage.validLogin(authInfo); // создаем объект verificationPage ссылаясь loginPage
        val verificationCode = getVerifyCode(authInfo); // берем данные кода вварификации
        val dashboardPage = verificationPage.validVerify(verificationCode); // создаем объект dashboardPage ссылаясь на метод
        val dataCard = getNumberCard();// берем данные с дата класса
        val balanceFirst = dashboardPage.getFirstCardBalance();// берем данные 1 й карты
        val balanceSecond = dashboardPage.getSecondCardBalance(); //берем данные 2 й карты
        val moneyPage = dashboardPage.MoveCardOne();// пополняем 1 карту
        moneyPage.endMoneyPage(amount, dataCard.getSecondNumber());// ввод с 2й карты
        assertEquals(balanceFirst + amount, dashboardPage.getFirstCardBalance());
        assertEquals(balanceSecond - amount, dashboardPage.getSecondCardBalance());
    }
}


