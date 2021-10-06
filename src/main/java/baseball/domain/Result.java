package baseball.domain;

import java.util.Collections;
import java.util.List;

public final class Result {

    private final List<BallType> results;

    private Result(final List<BallType> results) {
        this.results = results;
    }

    public static Result from(final List<BallType> results) {
        return new Result(results);
    }

    public boolean hasType(final BallType type) {
        return results.contains(type);
    }

    public int countType(final BallType type) {
        return Collections.frequency(results, type);
    }

    public boolean isContinue() {
        return countType(BallType.STRIKE) != 3;
    }

}
