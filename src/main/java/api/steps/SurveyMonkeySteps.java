package api.steps;

import api.exceptions.NoSurveyFoundException;
import api.services.SurveyMonkeyRequests;
import io.qameta.allure.Step;
import lombok.Getter;
import pojo.disqualified.Data;
import pojo.disqualified.Disqualified;
import pojo.disqualified.Pages;
import pojo.disqualified.Questions;
import pojo.question.QuestionPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Getter
public class SurveyMonkeySteps {

    SurveyMonkeyRequests requests = new SurveyMonkeyRequests();

    Map<Integer, Integer> collectorMap = new HashMap<Integer, Integer>();

    private List<Integer> notRelatedQuestion = new ArrayList<>();
    private ArrayList<Long> answersListId = new ArrayList<>();
    private ArrayList<Long> deleteList = new ArrayList<>();

    @Step
    public int getPageCount(int id){
        int totalQuestionNumber = requests.getDisqualifiedResponses(id, 1).getTotal();
        return totalQuestionNumber % 100 > 0 ? totalQuestionNumber / 100 + 1 : totalQuestionNumber / 100;
    }

    @Step
    public int findSurveyId(String title){
        return requests.getSurveys()
                .getData().stream()
                    .filter(data -> data.getTitle().equalsIgnoreCase(title))
                    .findFirst()
                    .orElseThrow(NoSurveyFoundException::new)
                .getId();
    }

    @Step
    public int getAnswersIdList(int id, String questionText, List<String> answersList){
        Disqualified disqualified = requests.getDisqualifiedResponses(id,1);

        int collectorId = disqualified.getData().get(0).getCollector_id();
        collectorMap.put(id, collectorId);

        for (Data data: disqualified.getData()){
            List<Pages> pages = data.getPages();
            Map<Integer, List<Questions>> integerListMap = pages.stream().collect(toMap(Pages::getId, Pages::getQuestions));

            for(Map.Entry<Integer, List<Questions>> entry: integerListMap.entrySet()){
                Integer key = entry.getKey();
                List<Questions> questions = entry.getValue();

                if (questions.size() > 0 && !notRelatedQuestion.contains(key)) {
                    for (Questions quest: questions) {
                        QuestionPojo questionPojo = requests.getQuestionAndAnswers(id, key, quest.getId());

                        String question = questionPojo.getHeadings().get(0).getHeading();
                        if (question.equals(questionText)) {
                            int questionId = quest.getId();
                            questionPojo.getAnswers().getChoices().forEach(choice -> {
                                if (answersList.contains(choice.getText())) answersListId.add(choice.getId());
                            });
                            return questionId;
                        }
                        else notRelatedQuestion.add(key);
                    }
                }
            }
        }
        return 0;
    }

    @Step
    public ArrayList<Long> findDisqualifiedResponse(int id, int questionId, int pagesNumber){
        for (int i = 1; i <= pagesNumber; i++) {
            Disqualified responses = requests.getDisqualifiedResponses(id, i);
            responses.getData().forEach(data -> {
                data.getPages().forEach(pages -> {
                    pages.getQuestions().forEach(questions -> {
                        if (questions.getId() == questionId) {
                            if (answersListId.contains(questions.getAnswers().get(0).getChoice_id())) {
                                deleteList.add(data.getId());
                            }
                        }
                    });
                });
            });
        }
        return deleteList;
    }

    @Step
    public void deleteDisqualifiedResponses(int id, List<Long> deleteList){
        int collectorId = collectorMap.get(id);

        deleteList.forEach(resp -> requests.deleteResponse(collectorId, resp));
    }

}
