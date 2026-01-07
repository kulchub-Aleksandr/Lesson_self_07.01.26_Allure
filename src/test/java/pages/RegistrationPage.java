package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResponsive;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            sabject = $("#subjectsInput"),
            Hobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateFieldSetValue = $("#react-select-3-input"),
            cityFieldSetValue = $("#react-select-4-input"),
            submit = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            closeModal = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsive tableResponsive = new TableResponsive();

    @Step("Открываем страницу заполнения формы")
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Закрываем и убираем мешающие элементы со страницы")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    @Step("Вводим Имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим Фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим Эл.Адрес")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Вводим телефон")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Вводим полную дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Вводим предмет")
    public RegistrationPage setSabjects(String value) {
        sabject.setValue(value).pressEnter();
        return this;
    }

    @Step("Вводим Хобби")
    public RegistrationPage setHobbies(String value) {
        Hobbies.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Вводим Адрес проживания")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("скролим страницу")
    public RegistrationPage setScroll() {
        submit.scrollIntoView("{block: 'center'}");
        return this;
    }

    @Step("Выбираем Штат")
    public RegistrationPage setStateDropdown(String value) {
        stateFieldSetValue.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем Город")
    public RegistrationPage setCityDropdown(String value) {
        cityFieldSetValue.setValue(value).pressEnter();
        return this;
    }

    @Step("Нажимаем Submit")
    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверяем модальное окно на видимость")
    public RegistrationPage setModalDialog() {
        modalDialog.should(appear);
        return this;
    }

    @Step("Проверяем модальное окно на НЕвидимость")
    public RegistrationPage getModalDialog() {
        modalDialog.shouldNotBe(visible);
        return this;
    }

    @Step("Проверяем заголовок модального окна")
    public RegistrationPage setModalTitle(String title) {
        modalTitle.shouldHave(text(title));
        return this;
    }

    @Step("Проверяем соответствие столбцов в итоговой таблице")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.setTable(key, value);
        return this;
    }

    @Step("Закрываем итоговую таблицу")
    public RegistrationPage closeModal() {
        closeModal.click();
        return this;
    }
}