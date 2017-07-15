import java.util.Arrays;
import java.util.Collection;

class RaindropConverter {

    private static final Collection<Object[]> FACTORS = Arrays.asList(new Object[][]{
            {3, "Pling"},
            {5, "Plang"},
            {7, "Plong"},
    });
    private StringBuilder raindropMessage;

    public RaindropConverter() {
        this.raindropMessage = new StringBuilder();
    }

    String convert(int number) {

        for (Object[] factor : FACTORS) {
            if (isFactor(number, (int) factor[0])) {
                raindropMessage.append(factor[1]);
            }
        }

        if (isEmpty()) return String.valueOf(number);
        else return raindropMessage.toString();
    }

    private boolean isEmpty() {
        return raindropMessage.toString().isEmpty();
    }

    private boolean isFactor(int number, int factor) {
        return number % factor == 0;
    }

}
