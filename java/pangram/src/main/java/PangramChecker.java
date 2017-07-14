public class PangramChecker {

    private static String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

    public boolean isPangram(String input) {

        return isAlphabetInInput(input);
    }

    private boolean isAlphabetInInput(String input) {
        for (String ch : alphabet) {
            if (!input.toLowerCase().contains(ch)) {
                return false;
            }
        }
        return true;
    }
}