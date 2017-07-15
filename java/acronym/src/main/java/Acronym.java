import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Acronym {

    private static final Pattern ACRONYM_PATTERN = Pattern.compile("\\b(\\w)");

    private String phrase;
    private final StringBuilder acronym;

    Acronym(String phrase) {
        this.phrase = phrase;
        acronym = new StringBuilder();
    }

    String get() {
        if (isEmpty()) {
            buildAcronym();
        }

        return acronym
                .toString()
                .toUpperCase();
    }

    private boolean isEmpty() {
        return acronym.toString().isEmpty();
    }

    private void buildAcronym() {
        Matcher acronymMatcher = ACRONYM_PATTERN.matcher(phrase);

        while (acronymMatcher.find()) {
            acronym.append(acronymMatcher.group());
        }
    }
}
