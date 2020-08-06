package ru.netology.data.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

// класс который возвращает страницу варификации
public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input"); // сохраняем элементы и переводим в приватный доступ
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(Condition.visible); // проверка на то что поле должно быть видимым, если поле не загрузится , тесты упадут
    }

    public DashboardPage validVerify(DataHelper.VerifyCode code) {
        codeField.setValue(code.getCode());
        verifyButton.click();
        return new DashboardPage(); // возвращаем страницу Dashboard после ввода кода
    }
}