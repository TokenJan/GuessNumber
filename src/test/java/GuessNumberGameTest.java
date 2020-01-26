import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.mockito.*;

public class GuessNumberGameTest {

    @Test
    public void should_return_4_different_numbers_when_generate_answer() {
        // given:
        NumberGenerator generator = new NumberGenerator();
        GuessNumberGame game = new GuessNumberGame(generator);

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
        int[] answers = new int[] {1, 2, 3, 4};
        NumberGenerator generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.getNumbers()).thenReturn(answers);
        GuessNumberGame game = new GuessNumberGame(generator);

        // when:
        game.start();
        game.guess(answers);

        // then:
        assert "4A0B".equals(game.getResult());

    }

    @Test
    public void should_return_0A0B_given_all_wrong_answers() {
        // given:
        int[] answers = new int[] {1, 2, 3, 4};
        int[] guessNumbers = new int[] {5, 6, 7, 8};
        NumberGenerator generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.getNumbers()).thenReturn(answers);
        GuessNumberGame game = new GuessNumberGame(generator);

        // when:
        game.start();
        game.guess(guessNumbers);

        // then:
        assert "0A0B".equals(game.getResult());

    }

    @Test
    public void should_return_1A3B_given_all_wrong_answers() {
        // given:
        int[] answers = new int[] {1, 2, 3, 4};
        int[] guessNumbers = new int[] {1, 6, 7, 8};
        NumberGenerator generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.getNumbers()).thenReturn(answers);
        GuessNumberGame game = new GuessNumberGame(generator);

        // when:
        game.start();
        game.guess(guessNumbers);

        // then:
        assert "1A0B".equals(game.getResult());

    }

    @Test
    public void should_return_1A2B_given_all_wrong_answers() {
        // given:
        int[] answers = new int[] {1, 2, 3, 4};
        int[] guessNumbers = new int[] {1, 3, 4, 8};
        NumberGenerator generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.getNumbers()).thenReturn(answers);
        GuessNumberGame game = new GuessNumberGame(generator);

        // when:
        game.start();
        game.guess(guessNumbers);

        // then:
        assert "1A2B".equals(game.getResult());

    }
}