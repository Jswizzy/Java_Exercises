import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime birthDay;
    private static final long GIGA = 1000000000L;

    Gigasecond(LocalDate birthDate) {
        this.birthDay = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDay = birthDateTime;
    }

    LocalDateTime getDate() {
        return birthDay.plusSeconds(GIGA);
    }

}
