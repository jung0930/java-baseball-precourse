package baseball.domain.strategy.judgeStrategy;

import baseball.domain.Ball;
import baseball.domain.BallType;
import baseball.domain.Balls;

@FunctionalInterface
public interface RuleStrategy {
    BallType judge(BallType ballType, Balls computerBalls, Ball playerBall, int order);
}
