package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @DisplayName("두 Balls를 비교해서 Reulst를 반환한다.")
    @Test
    void judgment() {
        Result result = Referee.judgment(Balls.from("345"), Balls.from("415"));
        assertAll(
                () -> assertThat(result.countType(BallType.STRIKE)).isEqualTo(1),
                () -> assertThat(result.countType(BallType.BALL)).isEqualTo(1),
                () -> assertThat(result.countType(BallType.NONE)).isEqualTo(1)
        );
    }

}
