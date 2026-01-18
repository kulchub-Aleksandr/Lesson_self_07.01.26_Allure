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

    @Step("Opening the form filling page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Close and remove the interfering elements from the page")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Type last name \"{value}\"")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Type Email \"{value}\"")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Choosing a gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Enter the phone number \"{value}\"")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Enter the full date of birth \"{day}\" \"{month}\" \"{year}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Type the subject \"{value}\"")
    public RegistrationPage setSabjects(String value) {
        sabject.setValue(value).pressEnter();
        return this;
    }

    @Step("Type the hobby \"{value}\"")
    public RegistrationPage setHobbies(String value) {
        Hobbies.$(byText(value)).click();
        return this;
    }

    @Step("Upload picture \"{value}\"")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Type current address \"{value}\"")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Scroll page")
    public RegistrationPage setScroll() {
        submit.scrollIntoView("{block: 'center'}");
        return this;
    }

    @Step("Choosing a State \"{value}\"")
    public RegistrationPage setStateDropdown(String value) {
        stateFieldSetValue.setValue(value).pressEnter();
        return this;
    }

    @Step("Choosing a City \"{value}\"")
    public RegistrationPage setCityDropdown(String value) {
        cityFieldSetValue.setValue(value).pressEnter();
        return this;
    }

    @Step("Press Submit")
    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }

    @Step("Checking the modal window for visibility")
    public RegistrationPage setModalDialog() {
        modalDialog.should(appear);
        return this;
    }

    @Step("Проверяем модальное окно на НЕвидимость")
    public RegistrationPage getModalDialog() {
        modalDialog.shouldNotBe(visible);
        return this;
    }

    @Step("Checking the title of the modal window")
    public RegistrationPage setModalTitle(String title) {
        modalTitle.shouldHave(text(title));
        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\" ")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.setTable(key, value);
        return this;
    }

    @Step("Closing the final table")
    public RegistrationPage closeModal() {
        closeModal.click();
        return this;
    }
}