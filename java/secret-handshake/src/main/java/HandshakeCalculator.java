import java.util.*;

class HandshakeCalculator {

    private static final int REVERSE = 0b10000;
    private static final Message[] MESSAGES = {
            new Message(0b1, Signal.WINK),
            new Message(0b10, Signal.DOUBLE_BLINK),
            new Message(0b100, Signal.CLOSE_YOUR_EYES),
            new Message(0b1000, Signal.JUMP),
    };

    List<Signal> calculateHandshake(int number) {

        List<Signal> signals = new LinkedList<>();

        for (Message msg : MESSAGES) {
            if (checkBitSet(number, msg.getBitMask())) {
                signals.add(msg.getSignal());
            }
        }

        if (checkBitSet(number, REVERSE)) {
            Collections.reverse(signals);
        }

        return signals;
    }

    private boolean checkBitSet(int number, int bitMask) {
        return (number & bitMask) != 0;
    }

    private static class Message {
        private final int bitMask;
        private final Signal signal;

        Message(int bitMask, Signal signal) {
            this.bitMask = bitMask;
            this.signal = signal;
        }

        int getBitMask() {
            return bitMask;
        }

        Signal getSignal() {
            return signal;
        }
    }
}
