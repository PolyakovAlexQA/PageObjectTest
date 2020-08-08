package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Data
public class MoneyPage {
    private SelenideElement dashboardMoneyField = $("[data-test-id=dashboard]");
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement toField = $("[data-test-id=to] input");
    private SelenideElement buttonField = $("[data-test-id=action-transfer]");
    private SelenideElement cancelField = $("[data-test-id=action-cancel]");
    private SelenideElement titleError = $("[class='notification__title']");

    public MoneyPage() {
        dashboardMoneyField.shouldHave(visible, text("Личный кабинет")); // видость элемента
    }

    public void endMoneyPage(int amount, String cardNumber) {
        amountField.setValue(String.valueOf((amount)));
        fromField.setValue(cardNumber);
        buttonField.click();

    }
}
