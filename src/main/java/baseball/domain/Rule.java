package baseball.domain;

import baseball.domain.strategy.judgeStrategy.RuleStrategy;

public enum Rule {

    RULE_STRIKE((ballType, computerBalls, playerBall, order) -> {
        if (computerBalls.isEquals(playerBall, order)) {
            return BallType.STRIKE;
        }
        return ballType;
    }), RULE_BALL((ballType, computerBalls, playerBall, order) -> {
        if (!computerBalls.isEquals(playerBall, order) && computerBalls.isContains(playerBall)) {
            return BallType.BALL;
        }
        return ballType;
    }), RULE_NONE((ballType, computerBalls, playerBall, order) -> {
        if (!computerBalls.isContains(playerBall)) {
            return BallType.NONE;
        }
        return ballType;
    });

    public final RuleStrategy ruleStrategy;

    Rule(final RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

}
