public class DifferenceOfSquaresCalculator {
    public int computeSquareOfSumTo(int untilN) {

        int sum = 0;
        for (int i = untilN; i > 0; i--) {
            sum += i;
        }

        return sum * sum;
    }

    public int computeSumOfSquaresTo(int untilN) {

        int sum = 0;
        for (int i = untilN; i > 0; i--) {
             sum += i * i;
        }

        return sum;
    }

    public int computeDifferenceOfSquares(int untilN) {

        return Math.abs(computeSquareOfSumTo(untilN) - computeSumOfSquaresTo(untilN));
    }
}
