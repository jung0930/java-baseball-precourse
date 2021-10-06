package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {

    @DisplayName("STRIKE의 개수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"STRIKE:STRIKE:STRIKE:3", "STRIKE:BALL:STRIKE:2", "NONE:BALL:STRIKE:1", "NONE:NONE:NONE:0"}, delimiter = ':')
    void countType_STRIKE(String firstType, String secondType, String thirthType, int count) {
        List<BallType> types = Arrays.asList(BallType.valueOf(firstType), BallType.valueOf(secondType), BallType.valueOf(thirthType));
        Result result = Result.from(types);

        assertThat(result.countType(BallType.STRIKE)).isEqualTo(count);
    }

    @DisplayName("BALL의 개수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"BALL:BALL:BALL:3", "BALL:BALL:STRIKE:2", "NONE:BALL:STRIKE:1", "NONE:NONE:NONE:0"}, delimiter = ':')
    void countType_BALL(String firstType, String secondType, String thirthType, int count) {
        List<BallType> types = Arrays.asList(BallType.valueOf(firstType), BallType.valueOf(secondType), BallType.valueOf(thirthType));
        Result result = Result.from(types);

        assertThat(result.countType(BallType.BALL)).isEqualTo(count);
    }

    @DisplayName("NONE의 개수를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"NONE:NONE:NONE:3", "BALL:NONE:NONE:2", "NONE:BALL:STRIKE:1", "STRIKE:STRIKE:STRIKE:0"}, delimiter = ':')
    void countType_NONE(String firstType, String secondType, String thirthType, int count) {
        List<BallType> types = Arrays.asList(BallType.valueOf(firstType), BallType.valueOf(secondType), BallType.valueOf(thirthType));
        Result result = Result.from(types);

        assertThat(result.countType(BallType.NONE)).isEqualTo(count);
    }

    @DisplayName("해당 BallType을 가지고 있는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"STRIKE:STRIKE:STRIKE:STRIKE", "STRIKE:STRIKE:BALL:BALL", "STRIKE:STRIKE:NONE:NONE"}, delimiter = ':')
    void hasType(String firstType, String secondType, String thirthType, String findType) {
        List<BallType> types = Arrays.asList(BallType.valueOf(firstType), BallType.valueOf(secondType), BallType.valueOf(thirthType));
        Result result = Result.from(types);

        assertThat(result.hasType(BallType.valueOf(findType))).isTrue();
    }

}
