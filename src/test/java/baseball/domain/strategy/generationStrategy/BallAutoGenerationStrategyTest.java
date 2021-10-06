package baseball.domain.strategy.generationStrategy;

import baseball.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallAutoGenerationStrategyTest {

    @DisplayName("중복되지 않는 숫자 3개 생성")
    @Test
    void create() {
        AutoGenerateBallStrategy strategy = new AutoGenerateBallStrategy();
        List<Ball> balls = strategy.generate();
        Set<Ball> ballsSet = new HashSet<>(balls);

        assertThat(ballsSet.size()).isEqualTo(3);
    }

}
