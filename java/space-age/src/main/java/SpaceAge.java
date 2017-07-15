class SpaceAge {

    private double seconds;
    private static final double ORBITAL_PERIOD_EARTH = 365.25 * 24 * 60 * 60;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return secondsToEarthYears(1);
    }

    double onMercury() {
        return secondsToEarthYears(2.408467E-01);
    }

    double onVenus() {
        return secondsToEarthYears(6.1519726E-01);
    }

    double onMars() {
        return secondsToEarthYears(1.8808158E00);
    }

    double onJupiter() {
        return secondsToEarthYears(1.1862615E01);
    }

    double onSaturn() {
        return secondsToEarthYears(2.9447498E01);
    }

    double onUranus() {
        return secondsToEarthYears(8.4016846E01);
    }

    double onNeptune() {
        return secondsToEarthYears(1.6479132E02);
    }

    private double secondsToEarthYears(double orbitalPeriodEarthYears) {
        return seconds / (ORBITAL_PERIOD_EARTH * orbitalPeriodEarthYears);
    }

}
