package matc.madjava.util;

public class Functions {

    public long calculatePlayerPoints(int points, int assists, int rebounds, int steals, int blocks, int turnovers) {
        long total = (long) (points + (assists * 1.2) + (rebounds *1.5) + (steals * 3) + (blocks * 3) - turnovers);
        return total;
    }

    public long calculateTotalPoints(long pgPoints, long sgPoints, long sfPoints, long pfPoints, long cPoints) {
        long total = pgPoints + sgPoints + sfPoints + pfPoints + cPoints;
        return total;
    }

}
