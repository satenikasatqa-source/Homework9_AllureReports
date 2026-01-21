package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static config.TestData.*;

public class SelenideTest {

    @Test
    @DisplayName("Чистый Selenide тест с Listener: проверка названия Issue")
    void checkIssueTitle() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/" + REPOSITORY);

        $("#issues-tab").click();

        $("a[href='/" + REPOSITORY + "/issues/" + ISSUE_NUMBER + "']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(EXPECTED_TITLE));
    }
}
