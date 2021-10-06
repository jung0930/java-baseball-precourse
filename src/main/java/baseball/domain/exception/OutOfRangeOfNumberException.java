package baseball.domain.exception;

public class OutOfRangeOfNumberException extends IllegalArgumentException {

    private static final String OUT_OF_RANGE_OF_NUMBER_ERROR_MESSAGE = "[ERROR] 각 자리의 수는 1~9사이의 수여야 합니다.";

    public OutOfRangeOfNumberException() {
        super(OUT_OF_RANGE_OF_NUMBER_ERROR_MESSAGE);
    }

}
