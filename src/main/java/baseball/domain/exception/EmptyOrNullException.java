package baseball.domain.exception;

public class EmptyOrNullException extends IllegalArgumentException {

    private static final String EMPTY_OR_NULL_ERROR_MESSAGE = "[ERROR] 값을 입력해주세요.";

    public EmptyOrNullException() {
        super(EMPTY_OR_NULL_ERROR_MESSAGE);
    }

}
