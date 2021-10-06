package baseball.view;

import baseball.domain.BallType;
import baseball.domain.Result;

public final class ResultView {

    private ResultView() {
    }

    public static void printBallTypes(final Result result) {
        if (result.hasType(BallType.STRIKE)) {
            System.out.print(result.countType(BallType.STRIKE) + "스트라이크 ");
        }
        if (result.hasType(BallType.BALL)) {
            System.out.print(result.countType(BallType.BALL) + "볼");
        }
        if (result.countType(BallType.NONE) == 3) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

}
