package tests.API;

import api.steps.SurveyMonkeySteps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Survey Monkey Automation")
class SurveyAutomation {

    private String title = "Fun Prescreen";
    private String questionText = "Recent research on decision making shows that choices are affected by context. Specifically, we are interested in whether you actually take the time to read each question. To show that you are paying attention, please check only the \"none of the above\" option as your answer.";
    private List<String> answersList = Arrays.asList("Interested","Distressed","Excited","Upset","Strong","Guilty","Scared","Hostile","Enthusiastic");
    private int expectedResponsesCount = 76;

    private SurveyMonkeySteps smStep;

    @BeforeAll
    void setup() {
        smStep = new SurveyMonkeySteps();
    }

    @Test
    void deleteResponses() {

        int surveyId = smStep.findSurveyId(title);
        int pageNumber = smStep.getPageCount(surveyId);
        int questionId = smStep.getAnswersIdList(surveyId, questionText, answersList);

        ArrayList<Long> deleteList = smStep.findDisqualifiedResponse(surveyId, questionId, pageNumber);
        assertThat(expectedResponsesCount, is(equalTo(deleteList.size())));

        smStep.deleteDisqualifiedResponses(surveyId, deleteList);

        deleteList = smStep.findDisqualifiedResponse(surveyId, questionId, pageNumber);
        assertThat(deleteList, is(empty()));
    }
}
