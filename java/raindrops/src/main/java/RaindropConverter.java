import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


class RaindropConverter {

    private StringBuilder raindropMessage;

    private static final Map<Integer, String> raindrops;

    static {
        raindrops = new HashMap<>();
        raindrops.put(3, "Pling");
        raindrops.put(5, "Plang");
        raindrops.put(7, "Plong");
    }

    public RaindropConverter() {
        this.raindropMessage = new StringBuilder();
    }


    public String convert(int inputNumber) {

        Predicate<Integer> isFactor = f -> inputNumber % f == 0;

        Consumer<Integer> addRaindropMessage = f ->
                raindropMessage.append(raindrops.get(f));

        raindrops.keySet().stream()
                .filter(isFactor)
                .forEach(addRaindropMessage);
        
        return raindropMessage.length() == 0 ?
                String.valueOf(inputNumber)
                : raindropMessage.toString();
    }
}

