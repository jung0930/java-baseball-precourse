package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.domain.strategy.generationStrategy.AutoGenerateBallStrategy;
import baseball.view.InputView;
import baseball.view.ResultView;

public final class BaseBallGame {

    public void playGame() {
        do {
            startGame();
        } while (InputView.inputCommand());
    }

    private void startGame() {
        Balls computerBalls = Balls.from(new AutoGenerateBallStrategy());
        while (tryGame(computerBalls)) ;
        ResultView.printEndMessage();
    }

    private boolean tryGame(final Balls computerBalls) {
        try {
            String playerNumbers = InputView.inputNumber();
            Result result = Referee.judgment(computerBalls, Balls.from(playerNumbers));
            ResultView.printBallTypes(result);
            return result.isContinue();
        } catch (IllegalArgumentException e) {
            ResultView.printErrorMessage(e.getMessage());
        }
        return true;
    }

}
