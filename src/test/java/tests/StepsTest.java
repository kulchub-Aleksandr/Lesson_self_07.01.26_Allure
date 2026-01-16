package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {



    TestData testData = new TestData();

    @Test
    @DisplayName("Тестирование регистрации на сайте")
    @Feature("Регистрация")
    @Story("Пользователь регистрируется на сайте")
    @Owner("User")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE"),
            @Tag("demoqa")
    })
    public void RegistrationPageTest() {

        step("Открываем страницу заполнения формы", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });
        step("Закрываем и убираем мешающие элементы со страницы", () -> {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
    }

    @Test
    @DisplayName("Тестирование регистрации на сайте с помощью WebSteps")
    @Feature("Регистрация_Feature")
    @Story("Пользователь регистрируется на сайте_Story")
    @Owner("User")
    @Tag("demoqa")
    @Link(value = "Страница для заполнения данных", url = "https://demoqa.com/automation-practice-form")
    public void RegistrationPageTestWithWebSteps() {

        RegistrationPage steps = new RegistrationPage();
        String city = testData.city(testData.state);
        steps.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSabjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setUploadPicture(testData.Picture)
                .setCurrentAddress(testData.currentAddress)
                .setScroll()
                .setStateDropdown(testData.state)
                .setCityDropdown(city)
                .setSubmit()
                .setModalDialog()
                .setModalTitle(testData.submitFormText)
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.Picture)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + city)
                .closeModal();

    }
}
