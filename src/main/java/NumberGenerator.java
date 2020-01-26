import java.util.Random;

/**
 * @author jiahuan.yang
 */
public class NumberGenerator {

    private int[] numbers;

    private static final int MAX = 10;

    public NumberGenerator() {
        this.numbers = new int[4];
    }

    public int[] getNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(MAX);
            for (int j = 0; j < i; j++) {
                if (numbers[j] == numbers[i]) {
                    i--;
                }
            }
        }
        return numbers;
    }
}
