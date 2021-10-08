package baseball.domain.strategy.generationStrategy;

import baseball.domain.Ball;

import java.util.List;

public interface GenerateBallStrategy {
    List<Ball> generate();
}
