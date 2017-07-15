import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private static Map<Character, Integer> letterScore;
    private static final Map<Character, Integer> LETTER_SCORE;
    static {
        letterScore = new HashMap<>();
        initLetterScores("AEIOULNRST", 1);
        initLetterScores("DG", 2);
        initLetterScores("BCMP", 3);
        initLetterScores("FHVWY", 4);
        initLetterScores("K", 5);
        initLetterScores("JX", 8);
        initLetterScores("QZ", 10);
        LETTER_SCORE = Collections.unmodifiableMap(letterScore);
    }

    private static void initLetterScores(String letters, int points) {
        for (char letter : letters.toCharArray()) {
            letterScore.put(letter,
                    points);
        }
    }

    private String word;

    Scrabble(String word) {

        this.word = word.toUpperCase();
    }

    int getScore() {
        int score = 0;

        for (char letter : word
                .toCharArray()) {

            score += LETTER_SCORE.get(letter);
        }

        return score;
    }
}
