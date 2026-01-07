package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    @Test
    public void RegistrationPageTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step ("Открываем страницу заполнения формы", ()-> {
            open("https://demoqa.com/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });
        step( "Закрываем и убираем мешающие элементы со страницы", ()-> {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
    }
}
