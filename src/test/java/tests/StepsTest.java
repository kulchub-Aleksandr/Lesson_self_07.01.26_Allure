package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {

    @Test
    @DisplayName("Successful registration with minimal data")
    @Feature("Registration")
    @Story("The user registers on the website")
    @Owner("AleksKulch")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE"),
            @Tag("demoqa")
    })
    @Link(value = "Страница для заполнения данных", url = "https://demoqa.com/automation-practice-form")
    public void registrationTestWithMinimalData() {
        String city = testData.city(testData.state);
        step("Open registration page", () -> {
            steps.openPage()
                    .removeBanner();
        });
        step("Fill registration form", () -> {
            steps.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.gender)
                    .setUserNumber(testData.userNumber)
                    .setSubmit();
        });
        step("Check registration form results", () -> {
            steps.setModalDialog()
                    .setModalTitle(testData.submitFormText)
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .closeModal();
        });
    }

    @Test
    @DisplayName("Successful registration with full data")
    @Feature("Registration")
    @Story("The user registers on the website")
    @Owner("AleksKulch")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE"),
            @Tag("demoqa"),
    })
    @Link(value = "Страница для заполнения данных", url = "https://demoqa.com/automation-practice-form")
    public void registrationTestWithFullData() {
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
                    .setUploadPicture(testData.picture)
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
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " + city)
                    .closeModal();
        });
    }

    @Test
    @DisplayName("Negative registration with not full data")
    @Feature("Registration")
    @Story("The user registers on the website with incomplete phone number")
    @Owner("AleksKulch")
    @Tags({
            @Tag("WEB"),
            @Tag("SMOKE"),
            @Tag("demoqa"),
    })
    @Link(value = "Страница для заполнения данных", url = "https://demoqa.com/automation-practice-form")
    public void negativeTestWithFullData() {
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
                    .setUserNumber(testData.notFullUserNumber)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .setSabjects(testData.subjects)
                    .setHobbies(testData.hobbies)
                    .setUploadPicture(testData.picture)
                    .setCurrentAddress(testData.currentAddress)
                    .setScroll()
                    .setStateDropdown(testData.state)
                    .setCityDropdown(city)
                    .setSubmit();
        });
        step("Check registration form results", () -> {
            steps.getModalDialog();
//                    .setModalTitle(testData.submitFormText)
//                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
//                    .checkResult("Student Email", testData.userEmail)
//                    .checkResult("Gender", testData.gender)
//                    .checkResult("Mobile", testData.userNumber)
//                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
//                    .checkResult("Subjects", testData.subjects)
//                    .checkResult("Hobbies", testData.hobbies)
//                    .checkResult("Picture", testData.picture)
//                    .checkResult("Address", testData.currentAddress)
//                    .checkResult("State and City", testData.state + " " + city)
//                    .closeModal();
        });
    }
}
