package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage steps = new RegistrationPage();
    TestData testData = new TestData();
    CalendarComponent calendarComponent = new CalendarComponent();

    @BeforeAll
    static void beforeAll() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "127");
        String baseUrl = System.getProperty("baseUrl");
        String remoteUrl = System.getProperty("remoteUrl");
        String browserSize = System.getProperty("browserSize", "1920x1080");

        Configuration.browserSize = browserSize;
        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000; // default 4000

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote =remoteUrl;
                //"https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();

    }
}
