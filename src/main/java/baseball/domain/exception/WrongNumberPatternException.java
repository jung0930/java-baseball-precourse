package baseball.domain.exception;

public class WrongNumberPatternException extends IllegalArgumentException {

    private static final String WRONG_NUMBER_PATTERN_ERROR_MESSAGE = "[ERROR] 1~9 사이의 3자리 숫자를 입력해주세요.";

    public WrongNumberPatternException() {
        super(WRONG_NUMBER_PATTERN_ERROR_MESSAGE);
    }

}
