package allure;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private static final String REPO = "satenikasatqa-source/Homework9_AllureReports";
    private static final int ISSUE_NUMBER = 1;
    private static final String EXPECTED_TITLE = "Test issue for allure";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void addAllureListener() {
        addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    @DisplayName("Lambda steps через step()")
    void checkIssueTitle() {

        step("Открываем репозиторий", () -> open("/" + REPO));
        step("Переходим во вкладку Issues", () -> $("#issues-tab").click());
        step("Открываем Issue №" + ISSUE_NUMBER + " по URL", () ->
                open("/" + REPO + "/issues/" + ISSUE_NUMBER));
        step("Проверяем заголовок Issue", () ->
                $$("h1").filterBy(visible).first().shouldHave(text(EXPECTED_TITLE)));
    }
}
