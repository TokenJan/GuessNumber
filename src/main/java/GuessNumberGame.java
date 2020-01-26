import java.util.Arrays;

/**
 * @author jiahuan.yang
 */
public class GuessNumberGame {

    private int[] answers;
    private NumberGenerator generator;
    private static final String WRONG_MESSAGE = "Wrong Input, input again";

    public GuessNumberGame(NumberGenerator generator) {
        this.generator = generator;
    }

    public void start() {
        this.answers = generator.getNumbers();
    }

    public String guess(int[] guessNumbers) {
        return getResult(guessNumbers);
    }

    private String getResult(int[] guessNumbers) {
        if (verifyInput(guessNumbers)) {
            return WRONG_MESSAGE;
        }

        int countA = 0;
        int countB = 0;
        for (int i = 0 ; i < answers.length; i++) {
            int guessNumber = guessNumbers[i];
            if ( guessNumber == answers[i]) {
                countA++;
            } else if (Arrays.stream(answers).anyMatch(num -> num == guessNumber)) {
                countB++;
            }
        }
        return String.format("%dA%dB", countA, countB);
    }

    private boolean verifyInput(int[] guessNumbers) {
        return Arrays.stream(guessNumbers).distinct().count() != 4;
    }


    public int[] getAnswers() {
        return answers;
    }
}
