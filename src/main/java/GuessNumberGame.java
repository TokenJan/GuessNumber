import java.util.Arrays;
import java.util.Random;

/**
 * @author jiahuan.yang
 */
public class GuessNumberGame {

    private int[] answers;
    private static final int MAX = 10;

    public GuessNumberGame() {
        this.answers = new int[4];
    }

    public void start() {
        for (int i = 0; i < answers.length; i++) {
            Random random = new Random();
            answers[i] = random.nextInt(MAX);
            for (int j = 0; j < i; j++) {
                if (answers[j] == answers[i]) {
                    i--;
                }
            }
        }
    }

    public int[] getAnswers() {
        return answers;
    }
}
