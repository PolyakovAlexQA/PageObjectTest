package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MoneyPage {
    @FindBy(css="[data-test-id=dashboard]")
    private SelenideElement dashboardMoneyField;
    @FindBy(css="[data-test-id=amount]input")
    private SelenideElement amountField;
    @FindBy(css="[data-test-id=from]input")
    private SelenideElement fromField;
    @FindBy(css="[data-test-id=to]input")
    private SelenideElement toField;
    @FindBy(css="[data-test-id=action-transfer]")
    private SelenideElement buttonField;


    public MoneyPage() {
        dashboardMoneyField.shouldHave(visible, text("Личный кабинет")); // видость элемента
    }



}
