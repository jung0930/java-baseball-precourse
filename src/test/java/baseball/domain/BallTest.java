package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class BallTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void create(int input) {
        assertThat(Ball.from(input)).isInstanceOf(Ball.class);
    }

    @DisplayName("숫자가 1~9 사이가 아닐 경우 exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 10})
    void validate_숫자범위(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Ball.from(input));
    }

    @DisplayName("같은 번호로 생성된 Ball 이 같은 객체인지 확인")
    @Test
    void equals() {
        assertThat(Ball.from(5)).isEqualTo(Ball.from(5));
    }

}
