package pages;

import com.codeborne.selenide.SelenideElement;
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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSabjects(String value) {
        sabject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        Hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setScroll() {
        submit.scrollIntoView("{block: 'center'}");
        return this;
    }


    public RegistrationPage setStateDropdown(String value) {
        stateFieldSetValue.setValue(value).pressEnter();
        return this;
    }


    public RegistrationPage setCityDropdown(String value) {
        cityFieldSetValue.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage setModalDialog() {
        modalDialog.should(appear);
        return this;
    }

    public RegistrationPage getModalDialog() {
        modalDialog.shouldNotBe(visible);
        return this;
    }

    public RegistrationPage setModalTitle(String title) {
        modalTitle.shouldHave(text(title));
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.setTable(key, value);
        return this;
    }

    public RegistrationPage closeModal() {
        closeModal.click();
        return this;
    }
}