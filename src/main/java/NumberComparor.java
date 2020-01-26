import java.util.Arrays;

/**
 * @author jiahuan.yang
 */
public class NumberComparor {

    private int[] guessNumbers;
    private int[] answers;

    public NumberComparor(int[] guessNumbers, int[] answers) {
        this.guessNumbers = guessNumbers;
        this.answers = answers;
    }

    public String getResult() {
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
}
