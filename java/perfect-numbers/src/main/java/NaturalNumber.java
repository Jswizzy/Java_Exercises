import org.jetbrains.annotations.Contract;

class NaturalNumber {


    private int number;

    public NaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.number = number;
    }

    public Classification getClassification() {

        int aliquotSum = findAliquotSum();

        Classification classification;
        if (aliquotSum == number) {
            classification = Classification.PERFECT;
        } else if (aliquotSum > number) {
            classification = Classification.ABUNDANT;
        } else {
            classification = Classification.DEFICIENT;
        }

        return classification;
    }

    @Contract(pure = true)
    private int findAliquotSum() {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
