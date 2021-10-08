package baseball.domain;

import baseball.domain.exception.DuplicateNumberException;
import baseball.domain.exception.EmptyOrNullException;
import baseball.domain.exception.WrongNumberPatternException;
import baseball.domain.strategy.generationStrategy.GenerateBallStrategy;
import baseball.util.StringUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Balls {

    private static final String SEPARATOR = "";

    private final List<Ball> balls;
    private final Pattern pattern = Pattern.compile("[1-9]{3}");

    private Balls(final String input) {
        validate(input);
        this.balls = createBalls(input);
    }

    private Balls(final GenerateBallStrategy generateBallStrategy) {
        this.balls = generateBallStrategy.generate();
    }

    public static Balls from(final String input) {
        return new Balls(input);
    }

    public static Balls from(final GenerateBallStrategy generateBallStrategy) {
        return new Balls(generateBallStrategy);
    }

    private List<Ball> createBalls(final String input) {
        List<Ball> balls = new ArrayList<>();
        for (String number : input.split(SEPARATOR)) {
            balls.add(Ball.from(Integer.parseInt(number)));
        }
        return balls;
    }

    public boolean isEquals(final Ball ball, final int order) {
        return ball.equals(balls.get(order));
    }

    public boolean isContains(final Ball ball) {
        return balls.contains(ball);
    }

    public int size() {
        return balls.size();
    }

    public Ball get(final int index) {
        return balls.get(index);
    }

    private void validate(final String input) {
        if (StringUtil.isEmptyOrNull(input)) {
            throw new EmptyOrNullException();
        }
        validatePattern(input);
        validateDuplicate(input);
    }

    private void validatePattern(final String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new WrongNumberPatternException();
        }
    }

    private void validateDuplicate(final String input) {
        List<String> list = Arrays.asList(input.split(SEPARATOR));
        Set<String> set = new HashSet<>(list);
        if (list.size() != set.size()) {
            throw new DuplicateNumberException();
        }
    }

}
