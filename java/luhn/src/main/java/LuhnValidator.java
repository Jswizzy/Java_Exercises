class LuhnValidator {

    private static final String NONE_DIGIT = ".*\\D.*";

    boolean isValid(String candidate) {
        candidate = stripSpaces(candidate);

        if (isNotLongEnough(candidate) || containsNoneDigit(candidate)) {
            return false;
        }

        int luhn = getLuhn(candidate);

        return isLuhnDivisbileByTen(luhn);
    }

    private boolean isLuhnDivisbileByTen(int luhn) {
        return luhn % 10 == 0;
    }

    private int getLuhn(String candidate) {
        String digits[] = candidate.split("");

        int luhn = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            Integer integer = Integer.valueOf(digits[i]);

            if (isEvenFromRight(digits, i)) {
                luhn += doubleLuhn(integer);
            } else {
                luhn += integer;
            }
        }
        return luhn;
    }

    private int doubleLuhn(Integer integer) {
        integer *= 2;
        if (integer > 9) {
            return integer - 9;
        } else {
            return integer;
        }
    }

    private boolean isEvenFromRight(String[] digits, int i) {
        return i % 2 == digits.length % 2;
    }

    private boolean containsNoneDigit(String candidate) {
        return candidate.matches(NONE_DIGIT);
    }

    private boolean isNotLongEnough(String candidate) {
        return candidate.length() < 2;
    }

    private String stripSpaces(String candidate) {
        return candidate.replace(" ", "");
    }
}
