package baseball.domain.exception;

public class DuplicateNumberException extends IllegalArgumentException {

    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";

    public DuplicateNumberException() {
        super(DUPLICATE_NUMBER_ERROR_MESSAGE);
    }

}
