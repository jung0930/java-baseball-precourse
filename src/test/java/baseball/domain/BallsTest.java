package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
class BallsTest {

    @DisplayName("입력값이 빈값, null 일 경우 exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validate_빈값(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.from(input));
    }

    @DisplayName("입력값이 3자리의 1-9까지의 숫자가 아닐 경우 exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "-123", "가나다라", "012"})
    void validate_3자리숫자(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.from(input));
    }

    @DisplayName("중복된 숫자가 있을 경우 exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"122", "919"})
    void validate_중복된_숫자(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.from(input));
    }

    @DisplayName("Balls의 특정 순서에 해당 Ball이 있을 경우 true")
    @Test
    void isEquals_true() {
        Balls balls = Balls.from("456");
        assertAll(
                () -> assertThat(balls.isEquals(Ball.from(4), 0)).isTrue(),
                () -> assertThat(balls.isEquals(Ball.from(5), 1)).isTrue(),
                () -> assertThat(balls.isEquals(Ball.from(6), 2)).isTrue()
        );
    }

    @DisplayName("Balls의 특정 순서에 해당 Ball이 없을 경우 false")
    @Test
    void isEquals_false() {
        Balls balls = Balls.from("456");
        assertAll(
                () -> assertThat(balls.isEquals(Ball.from(7), 0)).isFalse(),
                () -> assertThat(balls.isEquals(Ball.from(8), 1)).isFalse(),
                () -> assertThat(balls.isEquals(Ball.from(9), 2)).isFalse()
        );
    }

    @DisplayName("Balls에 해당 Ball이 포함되어 있을 경우 true")
    @Test
    void isContains_true() {
        Balls balls = Balls.from("456");
        assertAll(
                () -> assertThat(balls.isContains(Ball.from(4))).isTrue(),
                () -> assertThat(balls.isContains(Ball.from(5))).isTrue(),
                () -> assertThat(balls.isContains(Ball.from(6))).isTrue()
        );
    }

    @DisplayName("Balls에 해당 Ball이 포함되어 있지 않을 경우 false")
    @Test
    void isContains_false() {
        Balls balls = Balls.from("456");
        assertAll(
                () -> assertThat(balls.isContains(Ball.from(7))).isFalse(),
                () -> assertThat(balls.isContains(Ball.from(8))).isFalse(),
                () -> assertThat(balls.isContains(Ball.from(9))).isFalse()
        );
    }

}
