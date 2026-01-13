package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем репозиторий {repo}")
    public void openRepo(String repo) {
        open("/" + repo);
    }

    @Step("Переходим во вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Открываем Issue №{number} в репозитории {repo}")
    public void openIssue(String repo, int number) {
        open("/" + repo + "/issues/" + number);
    }

    @Step("Проверяем заголовок Issue: {title}")
    public void checkIssueTitle(String title) {
        $$("h1").filterBy(com.codeborne.selenide.Condition.visible)
                .first()
                .shouldHave(com.codeborne.selenide.Condition.text(title));
    }

}
