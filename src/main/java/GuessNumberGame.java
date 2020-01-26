/**
 * @author jiahuan.yang
 */
public class GuessNumberGame {

    private int[] answers;
    private int[] guessNumbers;
    private NumberGenerator generator;
    private NumberComparor comparor;

    public GuessNumberGame(NumberGenerator generator) {
        this.generator = generator;
    }

    public void start() {
        this.answers = generator.getNumbers();
    }

    public void guess(int[] guessNums) {
        this.guessNumbers = guessNums;
    }

    public String getResult() {
        comparor = new NumberComparor(guessNumbers, answers);
        return comparor.getResult();
    }

    public int[] getAnswers() {
        return answers;
    }
}
