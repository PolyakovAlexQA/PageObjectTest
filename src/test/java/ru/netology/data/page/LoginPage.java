package ru.netology.data.page;

import ru.netology.data.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
// в классе указываем эллементы 1 й странице ввода кода
public class LoginPage {
    public  VerificationPage validLogin(DataHelper.AuthInfo info){ // указываем класс от куда берем дата-данные и метод класса AuthInfo от куда мы возвращаем логи и пароль
        $("[data-test-id=login]input").setValue(info.getLogin());
        $("[data-test-id=password]input").setValue(info.getPassword());
        $("[data-test-id=action-login]input").click();
        return new VerificationPage(); // после ввода кода, происход переход на страницу варификации

    }

}
