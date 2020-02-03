package api.exceptions;

public class NoSurveyFoundException extends RuntimeException  {

    @Override
    public String getMessage() {
        return String.format("No survey found");
    }
}
