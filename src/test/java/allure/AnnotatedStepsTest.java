package allure;

import config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static config.TestData.*;

public class AnnotatedStepsTest extends TestBase {

    private final WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    void checkIssueTitle() {
        steps.openRepo(REPOSITORY);
        steps.openIssuesTab();
        steps.openIssue(REPOSITORY, ISSUE_NUMBER);
        steps.checkIssueTitle(EXPECTED_TITLE);
    }
}
