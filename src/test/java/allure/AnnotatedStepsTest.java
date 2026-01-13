package allure;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class AnnotatedStepsTest {

    private static final String REPO = "satenikasatqa-source/Homework9_AllureReports";
    private static final int ISSUE_NUMBER = 1;
    private static final String EXPECTED_TITLE = "Test issue for allure";

    private final WebSteps steps = new WebSteps();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void addAllureListener() {
        addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    void checkIssueTitle() {
        steps.openRepo(REPO);
        steps.openIssuesTab();
        steps.openIssue(REPO, ISSUE_NUMBER);
        steps.checkIssueTitle(EXPECTED_TITLE);
    }
}
