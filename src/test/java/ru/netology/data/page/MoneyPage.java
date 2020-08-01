package ru.netology.data.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.data.DataCard;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Data
public class MoneyPage {
    @FindBy(css = "[data-test-id=dashboard]")
    private SelenideElement dashboardMoneyField;
    @FindBy(css = "[data-test-id=amount]input")
    private SelenideElement amountField;
    @FindBy(css = "[data-test-id=from]input")
    private SelenideElement fromField;
    @FindBy(css = "[data-test-id=to]input")
    private SelenideElement toField;
    @FindBy(css = "[data-test-id=action-transfer]")
    private SelenideElement buttonField;
    @FindBy(css = "[data-test-id=action-cancel]")
    private SelenideElement cancelField;


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

    public DashboardPage endMoneyPage2(int amount, DataCard.NumberCard card) {
        amountField.setValue(String.valueOf((amount)));
        fromField.setValue(card.getSecondNumber());
        buttonField.click();

        return new DashboardPage(); // возвращаем страницу Dashboard после ввода кода
    }
}
