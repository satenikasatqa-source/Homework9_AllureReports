package allure;

import config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static config.TestData.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends TestBase {

    @Test
    @DisplayName("Lambda steps через step()")
    void checkIssueTitle() {

        step("Открываем репозиторий", () -> open("/" + REPOSITORY));
        step("Переходим во вкладку Issues", () -> $("#issues-tab").click());

        step("Открываем Issue №" + ISSUE_NUMBER + " по URL", () ->
                open("/" + REPOSITORY + "/issues/" + ISSUE_NUMBER));

        step("Проверяем заголовок Issue", () ->
                $$("h1").filterBy(visible).first().shouldHave(text(EXPECTED_TITLE)));
    }
}
