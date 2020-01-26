import java.util.Arrays;

/**
 * @author jiahuan.yang
 */
public class GuessNumberGame {

    private int[] answers;
    private int[] guessNumbers;
    private NumberGenerator generator;

    public GuessNumberGame(NumberGenerator generator) {
        this.generator = generator;
    }

    public void start() {
        this.answers = generator.getNumbers();
    }

    public String guess(int[] guessNums) {
        this.guessNumbers = guessNums;
        return getResult();
    }

    private String getResult() {
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

    public int[] getAnswers() {
        return answers;
    }
}
