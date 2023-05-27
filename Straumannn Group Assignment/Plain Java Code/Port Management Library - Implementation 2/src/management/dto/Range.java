package management.dto;

import management.exception.InvalidPortRangeException;

public class Range {

    private final int rangeStartsWith;
    private final int rangeEndsWith;

    public Range(int start, int end) {
        validateRangeOfPorts(start, end);

        this.rangeStartsWith = start;
        this.rangeEndsWith = end;
    }

    public int getRangeStartsWith() {
        return rangeStartsWith;
    }

    public int getRangeEndsWith() {
        return rangeEndsWith;
    }

    private void validateRangeOfPorts(int rangeStartsWith, int rangeEndsWith) {
        if (rangeStartsWith < 10000 || rangeStartsWith > rangeEndsWith) {
            System.out.println("Invalid port range");
            throw new InvalidPortRangeException();
        }
    }
}
