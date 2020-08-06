package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.val;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Data
public class DashboardPage {
    private SelenideElement dashboardField= $("[data-test-id=dashboard]");
    private SelenideElement cardOne= $( "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement cardTwo=$("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");


    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        dashboardField.shouldHave(visible, text("Личный кабинет")); // видость элемента
    }

    public int getFirstCardBalance() { // получаем баланс карты
        val text = cardOne.text(); //показываем текст элемента
        return extractBalance(text);
    }

    public int getSecondCardBalance() { // получаем баланс второй карты
        val text = cardTwo.text(); //показываем текст элемента
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart); //indexOf - возвращает позицию, с которой начинается подстрока в строке
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish); // "баланс:  " р."
        return Integer.parseInt(value);
    }


    public MoneyPage MoveCardOne(){
        cardOne.$("button").click();
        return new MoneyPage();
    }

    public MoneyPage MoveCardTwo(){
        cardTwo.$("button").click();
        return new MoneyPage();
    }
}