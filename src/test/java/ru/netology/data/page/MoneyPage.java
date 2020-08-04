package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.data.DataCard;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Data
public class MoneyPage {
    private SelenideElement dashboardMoneyField = $("[data-test-id=dashboard]");
    private SelenideElement amountField =$("[data-test-id=amount]input");
    private SelenideElement fromField=$("[data-test-id=from]input");
    private SelenideElement toField=$("[data-test-id=to]input");
    private SelenideElement buttonField=$("[data-test-id=action-transfer]");
    private SelenideElement cancelField=$( "[data-test-id=action-cancel]");



    public MoneyPage() {
        dashboardMoneyField.shouldHave(visible, text("Личный кабинет")); // видость элемента
    }

    public void setAmount(int amount) {
        amountField.setValue(Integer.toString(amount));
    }

    public void setFromWhere(DataCard.NumberCard card) {
        fromField.setValue(card.getFirstNumber());
        fromField.setValue(card.getSecondNumber());
    }

    public DashboardPage endMoneyPage(int amount, DataCard.NumberCard card) {
        amountField.setValue(String.valueOf((amount)));
        fromField.setValue(card.getFirstNumber());
        buttonField.click();

        return new DashboardPage(); // возвращаем страницу Dashboard после ввода кода
    }


    }

