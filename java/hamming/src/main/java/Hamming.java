public class Hamming {

    private char[] leftString;
    private char[] rightString;
    private int length;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftString = leftStrand.toCharArray();
        this.rightString = rightStrand.toCharArray();
        length = leftStrand.length();
    }

    int getHammingDistance() {
        int sum = 0;

        for (int i = 0; i < length; i++) {
             if (leftString[i] != rightString[i]) sum++;
        }

        return sum;
    }

}
