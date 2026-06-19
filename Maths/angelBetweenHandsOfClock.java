package Maths;

public class angelBetweenHandsOfClock {
    class Solution {
    public double angleClock(int hour, int minutes) {
        double min = 6 * minutes;
        double h = 30 * hour + 0.5 * minutes;

        double diff = Math.abs(h - min);

        return Math.min(diff, 360 - diff);
    }
}
    
}
