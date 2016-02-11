package team.monalisa;

/**
 * Created by gbilley on 11/02/2016.
 */
public class Utils {
    
    public static Integer getDistance(Coordinate from, Coordinate to) {
        final Long distance = Math
            .round(Math.sqrt(Math.abs(to.getRow() - from.getRow()) ^ 2 + Math.abs(to.getCol() - from.getCol()) ^ 2));
        return distance.intValue();
    }
}
