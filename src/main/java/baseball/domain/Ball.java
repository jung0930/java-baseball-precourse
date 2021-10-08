package baseball.domain;

import baseball.domain.exception.OutOfRangeOfNumberException;

import java.util.Objects;

public final class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int ballNumber;

    private Ball(final int ballNumber) {
        validate(ballNumber);
        this.ballNumber = ballNumber;
    }

    public static Ball from(final int ballNumber) {
        return new Ball(ballNumber);
    }

    private void validate(final int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new OutOfRangeOfNumberException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

}
