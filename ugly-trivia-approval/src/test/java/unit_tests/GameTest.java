package unit_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ugly_trivia.Game;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void simulation_with_three_players() {
        var answerIsRightList = Arrays.asList(false, false, false, false, true, true, false, false, false, true, true, false, false, false, false, true, false, true, false, false, true, false, false, false, true, false, false, false, false, false, false);
        var rollResults = Arrays.asList(4, 2, 4, 4, 5, 5, 2, 3, 4, 2, 5, 5, 2, 4, 2, 4, 2, 2, 4, 4, 3, 5, 5, 5, 4, 3, 4, 1, 2, 1, 5);
        var aGame = new GameForTesting(rollResults, answerIsRightList);

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");
        aGame.run();

        assertThat(aGame.messagesShown).isEqualTo(expectedMessagesWithThreePlayers());
    }

    @Test
    void simulation_with_five_players() {
        var answerIsRightList = Arrays.asList(false, false, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
        var rollResults = Arrays.asList(4, 4, 1, 2, 2, 5, 4, 5, 5, 4, 1, 1, 5, 2, 5, 2, 4, 3, 1, 1, 5, 4, 5, 5, 2, 5, 5, 1, 1);
        var aGame = new GameForTesting(rollResults, answerIsRightList);

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");
        aGame.add("Peter");
        aGame.add("JAckson");
        aGame.run();

        assertThat(aGame.messagesShown).isEqualTo(expectedMessagesWithFivePlayers());
    }

    @ParameterizedTest
    @CsvSource({"12, 0", "11, 11"})
    void rounding_place(int place, int newPlace) {
        var currentPlayerIndex = 0;
        var places = new int[1];
        places[currentPlayerIndex] = place;
        Game.roundPlace(places, currentPlayerIndex);
        assertThat(places[currentPlayerIndex]).isEqualTo(newPlace);
    }

    private List<String> expectedMessagesWithFivePlayers() {
        return Arrays.asList("Chet was added", "They are player number 1", "Pat was added", "They are player number 2", "Sue was added", "They are player number 3", "Peter was added", "They are player number 4", "JAckson was added", "They are player number 5", "Chet is the current player", "They have rolled a 4", "Chet's new location is 4", "The category is Pop", "Pop Question 0", "Answer was correct!!!!", "Chet now has 1 Gold Coins.", "Pat is the current player", "They have rolled a 4", "Pat's new location is 4", "The category is Pop", "Pop Question 1", "Answer was correct!!!!", "Pat now has 1 Gold Coins.", "Sue is the current player", "They have rolled a 1", "Sue's new location is 1", "The category is Science", "Science Question 0", "Question was incorrectly answered", "Sue was sent to the penalty box", "Peter is the current player", "They have rolled a 2", "Peter's new location is 2", "The category is Sports", "Sports Question 0", "Answer was correct!!!!", "Peter now has 1 Gold Coins.", "JAckson is the current player", "They have rolled a 2", "JAckson's new location is 2", "The category is Sports", "Sports Question 1", "Answer was correct!!!!", "JAckson now has 1 Gold Coins.", "Chet is the current player", "They have rolled a 5", "Chet's new location is 9", "The category is Science", "Science Question 1", "Answer was correct!!!!", "Chet now has 2 Gold Coins.", "Pat is the current player", "They have rolled a 4", "Pat's new location is 8", "The category is Pop", "Pop Question 2", "Answer was correct!!!!", "Pat now has 2 Gold Coins.", "Sue is the current player", "They have rolled a 5", "Sue is getting out of the penalty box", "Sue's new location is 6", "The category is Sports", "Sports Question 2", "Answer was correct!!!!", "Sue now has 1 Gold Coins.", "Peter is the current player", "They have rolled a 5", "Peter's new location is 7", "The category is Rock", "Rock Question 0", "Answer was correct!!!!", "Peter now has 2 Gold Coins.", "JAckson is the current player", "They have rolled a 4", "JAckson's new location is 6", "The category is Sports", "Sports Question 3", "Question was incorrectly answered", "JAckson was sent to the penalty box", "Chet is the current player", "They have rolled a 1", "Chet's new location is 10", "The category is Sports", "Sports Question 4", "Question was incorrectly answered", "Chet was sent to the penalty box", "Pat is the current player", "They have rolled a 1", "Pat's new location is 9", "The category is Science", "Science Question 2", "Question was incorrectly answered", "Pat was sent to the penalty box", "Sue is the current player", "They have rolled a 5", "Sue is getting out of the penalty box", "Sue's new location is 11", "The category is Rock", "Rock Question 1", "Answer was correct!!!!", "Sue now has 2 Gold Coins.", "Peter is the current player", "They have rolled a 2", "Peter's new location is 9", "The category is Science", "Science Question 3", "Answer was correct!!!!", "Peter now has 3 Gold Coins.", "JAckson is the current player", "They have rolled a 5", "JAckson is getting out of the penalty box", "JAckson's new location is 11", "The category is Rock", "Rock Question 2", "Answer was correct!!!!", "JAckson now has 2 Gold Coins.", "Chet is the current player", "They have rolled a 2", "Chet is not getting out of the penalty box", "Pat is the current player", "They have rolled a 4", "Pat is not getting out of the penalty box", "Sue is the current player", "They have rolled a 3", "Sue is getting out of the penalty box", "Sue's new location is 2", "The category is Sports", "Sports Question 5", "Answer was correct!!!!", "Sue now has 3 Gold Coins.", "Peter is the current player", "They have rolled a 1", "Peter's new location is 10", "The category is Sports", "Sports Question 6", "Answer was correct!!!!", "Peter now has 4 Gold Coins.", "JAckson is the current player", "They have rolled a 1", "JAckson is getting out of the penalty box", "JAckson's new location is 0", "The category is Pop", "Pop Question 3", "Answer was correct!!!!", "JAckson now has 3 Gold Coins.", "Chet is the current player", "They have rolled a 5", "Chet is getting out of the penalty box", "Chet's new location is 3", "The category is Rock", "Rock Question 3", "Answer was correct!!!!", "Chet now has 3 Gold Coins.", "Pat is the current player", "They have rolled a 4", "Pat is not getting out of the penalty box", "Sue is the current player", "They have rolled a 5", "Sue is getting out of the penalty box", "Sue's new location is 7", "The category is Rock", "Rock Question 4", "Answer was correct!!!!", "Sue now has 4 Gold Coins.", "Peter is the current player", "They have rolled a 5", "Peter's new location is 3", "The category is Rock", "Rock Question 5", "Answer was correct!!!!", "Peter now has 5 Gold Coins.", "JAckson is the current player", "They have rolled a 2", "JAckson is not getting out of the penalty box", "Chet is the current player", "They have rolled a 5", "Chet is getting out of the penalty box", "Chet's new location is 8", "The category is Pop", "Pop Question 4", "Answer was correct!!!!", "Chet now has 4 Gold Coins.", "Pat is the current player", "They have rolled a 5", "Pat is getting out of the penalty box", "Pat's new location is 2", "The category is Sports", "Sports Question 7", "Answer was correct!!!!", "Pat now has 3 Gold Coins.", "Sue is the current player", "They have rolled a 1", "Sue is getting out of the penalty box", "Sue's new location is 8", "The category is Pop", "Pop Question 5", "Answer was correct!!!!", "Sue now has 5 Gold Coins.", "Peter is the current player", "They have rolled a 1", "Peter's new location is 4", "The category is Pop", "Pop Question 6", "Answer was correct!!!!", "Peter now has 6 Gold Coins.");
    }

    private List<String> expectedMessagesWithThreePlayers() {
        return Arrays.asList("Chet was added", "They are player number 1", "Pat was added", "They are player number 2", "Sue was added", "They are player number 3", "Chet is the current player", "They have rolled a 4", "Chet's new location is 4", "The category is Pop", "Pop Question 0", "Answer was correct!!!!", "Chet now has 1 Gold Coins.", "Pat is the current player", "They have rolled a 2", "Pat's new location is 2", "The category is Sports", "Sports Question 0", "Answer was correct!!!!", "Pat now has 1 Gold Coins.", "Sue is the current player", "They have rolled a 4", "Sue's new location is 4", "The category is Pop", "Pop Question 1", "Answer was correct!!!!", "Sue now has 1 Gold Coins.", "Chet is the current player", "They have rolled a 4", "Chet's new location is 8", "The category is Pop", "Pop Question 2", "Answer was correct!!!!", "Chet now has 2 Gold Coins.", "Pat is the current player", "They have rolled a 5", "Pat's new location is 7", "The category is Rock", "Rock Question 0", "Question was incorrectly answered", "Pat was sent to the penalty box", "Sue is the current player", "They have rolled a 5", "Sue's new location is 9", "The category is Science", "Science Question 0", "Question was incorrectly answered", "Sue was sent to the penalty box", "Chet is the current player", "They have rolled a 2", "Chet's new location is 10", "The category is Sports", "Sports Question 1", "Answer was correct!!!!", "Chet now has 3 Gold Coins.", "Pat is the current player", "They have rolled a 3", "Pat is getting out of the penalty box", "Pat's new location is 10", "The category is Sports", "Sports Question 2", "Answer was correct!!!!", "Pat now has 2 Gold Coins.", "Sue is the current player", "They have rolled a 4", "Sue is not getting out of the penalty box", "Chet is the current player", "They have rolled a 2", "Chet's new location is 0", "The category is Pop", "Pop Question 3", "Question was incorrectly answered", "Chet was sent to the penalty box", "Pat is the current player", "They have rolled a 5", "Pat is getting out of the penalty box", "Pat's new location is 3", "The category is Rock", "Rock Question 1", "Question was incorrectly answered", "Pat was sent to the penalty box", "Sue is the current player", "They have rolled a 5", "Sue is getting out of the penalty box", "Sue's new location is 2", "The category is Sports", "Sports Question 3", "Answer was correct!!!!", "Sue now has 2 Gold Coins.", "Chet is the current player", "They have rolled a 2", "Chet is not getting out of the penalty box", "Pat is the current player", "They have rolled a 4", "Pat is not getting out of the penalty box", "Sue is the current player", "They have rolled a 2", "Sue is not getting out of the penalty box", "Chet is the current player", "They have rolled a 4", "Chet is not getting out of the penalty box", "Question was incorrectly answered", "Chet was sent to the penalty box", "Pat is the current player", "They have rolled a 2", "Pat is not getting out of the penalty box", "Sue is the current player", "They have rolled a 2", "Sue is not getting out of the penalty box", "Question was incorrectly answered", "Sue was sent to the penalty box", "Chet is the current player", "They have rolled a 4", "Chet is not getting out of the penalty box", "Pat is the current player", "They have rolled a 4", "Pat is not getting out of the penalty box", "Sue is the current player", "They have rolled a 3", "Sue is getting out of the penalty box", "Sue's new location is 5", "The category is Science", "Science Question 1", "Question was incorrectly answered", "Sue was sent to the penalty box", "Chet is the current player", "They have rolled a 5", "Chet is getting out of the penalty box", "Chet's new location is 5", "The category is Science", "Science Question 2", "Answer was correct!!!!", "Chet now has 4 Gold Coins.", "Pat is the current player", "They have rolled a 5", "Pat is getting out of the penalty box", "Pat's new location is 8", "The category is Pop", "Pop Question 4", "Answer was correct!!!!", "Pat now has 3 Gold Coins.", "Sue is the current player", "They have rolled a 5", "Sue is getting out of the penalty box", "Sue's new location is 10", "The category is Sports", "Sports Question 4", "Answer was correct!!!!", "Sue now has 3 Gold Coins.", "Chet is the current player", "They have rolled a 4", "Chet is not getting out of the penalty box", "Question was incorrectly answered", "Chet was sent to the penalty box", "Pat is the current player", "They have rolled a 3", "Pat is getting out of the penalty box", "Pat's new location is 11", "The category is Rock", "Rock Question 2", "Answer was correct!!!!", "Pat now has 4 Gold Coins.", "Sue is the current player", "They have rolled a 4", "Sue is not getting out of the penalty box", "Chet is the current player", "They have rolled a 1", "Chet is getting out of the penalty box", "Chet's new location is 6", "The category is Sports", "Sports Question 5", "Answer was correct!!!!", "Chet now has 5 Gold Coins.", "Pat is the current player", "They have rolled a 2", "Pat is not getting out of the penalty box", "Sue is the current player", "They have rolled a 1", "Sue is getting out of the penalty box", "Sue's new location is 11", "The category is Rock", "Rock Question 3", "Answer was correct!!!!", "Sue now has 4 Gold Coins.", "Chet is the current player", "They have rolled a 5", "Chet is getting out of the penalty box", "Chet's new location is 11", "The category is Rock", "Rock Question 4", "Answer was correct!!!!", "Chet now has 6 Gold Coins.");
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