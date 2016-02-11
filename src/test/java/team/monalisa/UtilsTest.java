package team.monalisa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by gbilley on 11/02/2016.
 */
public class UtilsTest {
    
    @Test
    public void testGetDistance() throws Exception {
        Coordinate from = new Coordinate();
        from.setRow(1);
        from.setCol(1);
        
        Coordinate to = new Coordinate();
        to.setRow(1);
        to.setCol(3);
    
        assertThat(Utils.getDistance(from, to)).isEqualTo(2);
    
        from.setRow(1);
        from.setCol(3);
    
        to.setRow(1);
        to.setCol(4);
        
        assertThat(Utils.getDistance(from, to)).isEqualTo(1);
    
    }
}