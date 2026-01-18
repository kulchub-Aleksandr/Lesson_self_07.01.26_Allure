package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {

    @Test
    @DisplayName("Тестирование регистрации на сайте_Lambda")
    @Feature("Регистрация__Feature")
    @Story("Пользователь регистрируется на сайте__Story")
    @Owner("AleksKulch")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE"),
            @Tag("demoqa")
    })
    public void RegistrationPageLambdaTest() {
        String city = testData.city(testData.state);

        step("Open registration page", () -> {
            step("Открываем страницу заполнения формы", () -> {
                open("/automation-practice-form");
                $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            });
            step("Закрываем и убираем мешающие элементы со страницы", () -> {
                executeJavaScript("$('#fixedban').remove()");
                executeJavaScript("$('footer').remove()");
            });
        });
        step("Fill registration form", () -> {
            step("Вводим Имя", () -> {
                $("#firstName").setValue(testData.firstName);
            });
            step("Вводим Фамилию", () -> {
                $("#lastName").setValue(testData.lastName);
            });
            step("Вводим Эл.Адрес", () -> {
                $("#userEmail").setValue(testData.userEmail);
            });
            step("Выбираем пол", () -> {
                $("#genterWrapper").$(byText(testData.gender)).click();
            });
            step("Вводим телефон", () -> {
                $("#userNumber").setValue(testData.userNumber);
            });
            step("Вводим полную дату рождения", () -> {
                $("#dateOfBirthInput").click();
                calendarComponent.setDate(testData.day, testData.month, testData.year);
            });
            step("Вводим предмет", () -> {
                $("#subjectsInput").setValue(testData.subjects).pressEnter();
            });
            step("Вводим Хобби", () -> {
                $("#hobbiesWrapper").$(byText(testData.hobbies)).click();
            });
            step("Загружаем картинку", () -> {
                $("#uploadPicture").uploadFromClasspath(testData.Picture);
            });
            step("Вводим Адрес проживания", () -> {
                $("#currentAddress").setValue(testData.currentAddress);
            });
            step("Скролим страницу", () -> {
                $("#submit").scrollIntoView("{block: 'center'}");
            });
            step("Выбираем Штат", () -> {
                $("#react-select-3-input").setValue(testData.state).pressEnter();
            });
            step("Выбираем Город", () -> {
                $("#react-select-4-input").setValue(city).pressEnter();
            });
            step("Нажимаем Submit", () -> {
                $("#submit").click();
            });
        });
        step("Check registration form results", () -> {
            step("Проверяем модальное окно на видимость", () -> {
                $(".modal-dialog").should(appear);
            });
            step("Проверяем модальное окно на видимость заданного текста", () -> {
                $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            });
            step("Проверяем соответствие столбцов в итоговой таблице", () -> {
                step("Проверка имени ", () -> {
                    $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(testData.firstName + " " + testData.lastName));
                });


                step("Закрываем итоговую таблицу", () -> {
                    $("#closeLargeModal").click();
                });

            });


        });


    }

    @Test
    @DisplayName("Successful RegistrationPageTestWithWebSteps__DisplayName")
    @Feature("Registration__Feature")
    @Story("The user registers on the website__Story")
    @Owner("AleksKulch")
    @Tag("demoqa")
    @Link(value = "Страница для заполнения данных", url = "https://demoqa.com/automation-practice-form")
    public void RegistrationPageTestWithWebSteps() {

        String city = testData.city(testData.state);
        step("Open registration page", () -> {
            steps.openPage()
                    .removeBanner();
        });
        step("Fill registration form", () -> {
            steps.setFirstName(testData.firstName)
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
                    .setSubmit();
        });
        step("Check registration form results", () -> {
            steps.setModalDialog()
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
        });
    }
}
