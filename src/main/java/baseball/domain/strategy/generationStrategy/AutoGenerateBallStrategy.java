package baseball.domain.strategy.generationStrategy;

import baseball.domain.Ball;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class AutoGenerateBallStrategy implements GenerateBallStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_BALLS_SIZE = 3;

    public List<Ball> generate() {
        List<Ball> balls = new ArrayList<>();
        while (balls.size() < MAX_BALLS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addBall(balls, randomNumber);
        }
        return balls;
    }

    private void addBall(final List<Ball> balls, final int randomNumber) {
        if (!balls.contains(Ball.from(randomNumber))) {
            balls.add(Ball.from(randomNumber));
        }
    }

}
