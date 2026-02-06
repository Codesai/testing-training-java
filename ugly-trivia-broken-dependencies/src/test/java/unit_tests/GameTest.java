package unit_tests;

import org.junit.jupiter.api.Test;
import ugly_trivia.Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    public void canary_test() {
        assertThat(true).isEqualTo(true);
    }

    private static class GameForTesting extends Game {
        public final List<String> messagesShown;
        private final Queue<Integer> rollResults;
        private final Queue<Boolean> answerIsRightList;

        public GameForTesting(List<Integer> rollResults, List<Boolean> answerIsRightList) {
            this.messagesShown = new ArrayList<>();
            this.rollResults = new LinkedList<>(rollResults);
            this.answerIsRightList = new LinkedList<>(answerIsRightList);
        }

        @Override
        protected boolean isAnswerRight() {
            return answerIsRightList.remove();
        }

        @Override
        protected int getRollResult() {
            return rollResults.remove();
        }

        @Override
        protected void showMessage(String message) {
            this.messagesShown.add(message);
        }
    }
}

