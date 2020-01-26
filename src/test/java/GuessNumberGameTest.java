import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GuessNumberGameTest {

    @Test
    public void should_return_4_different_numbers_when_generate_answer() {
        // given:
        GuessNumberGame game = new GuessNumberGame();

        // when:
        game.start();

        // then:
        int[] answers = game.getAnswers();
        assert Arrays.stream(answers).distinct().count() == 4;
        assert Arrays.stream(answers).allMatch(num -> num <= 9 && num >= 0);
    }

    @Test
    public void should_return_4A0B_given_all_correct_answers() {
        // given:
        GuessNumberGame game = new GuessNumberGame();

        // when:
        game.start();

        // then:
        int[] answers = game.getAnswers();

    }
}