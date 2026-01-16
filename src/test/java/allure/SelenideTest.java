package allure;

import config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static config.TestData.*;

public class SelenideTest extends TestBase {

    @Test
    @DisplayName("Чистый тест с Listener")
    void checkIssueTitle() {
        open("/" + REPOSITORY);
        $("#issues-tab").click();
        open("/" + REPOSITORY + "/issues/" + ISSUE_NUMBER);
        $("h1").shouldHave(text(EXPECTED_TITLE));
    }
}
