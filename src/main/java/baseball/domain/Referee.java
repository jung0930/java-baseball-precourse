package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public final class Referee {

    private Referee() {
    }

    public static Result judgment(final Balls computerBalls, final Balls playerBalls) {
        List<BallType> results = new ArrayList<>();
        for (int i = 0; i < playerBalls.size(); i++) {
            results.add(findType(computerBalls, playerBalls.get(i), i));
        }
        return Result.from(results);
    }

    private static BallType findType(final Balls computerBalls, final Ball playerBall, final int order) {
        BallType ballType = BallType.NONE;
        for (Rule value : Rule.values()) {
            ballType = value.ruleStrategy.judge(ballType, computerBalls, playerBall, order);
        }
        return ballType;
    }

}
