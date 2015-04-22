package team.monalisa;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigourous Test :-)
     */
    @Test
    @Ignore
    public void testApp() throws IOException
    {
        List<String> lines = new ArrayList<>();
        lines.add("2 5 1 2 5");
        lines.add("0 0");
        lines.add("3 10");
        lines.add("3 10");
        lines.add("2 5");
        lines.add("1 5");
        lines.add("1 1");
        DataCenter dataCenter = new DataCenter(lines);

        assert(dataCenter.getR().equals(2));
        assert(dataCenter.getS().equals(5));
        assert(dataCenter.getU().equals(1));
        assert(dataCenter.getP().equals(2));
        assert(dataCenter.getM().equals(5));

//        assertThat(dataCenter.getRaws().get(0));
        Assertions.assertThat(dataCenter.getRaws().get(0)).containsExactly(false,true,true,true,true);
        Assertions.assertThat(dataCenter.getRaws().get(1)).containsExactly(true, true, true, true, true);

    }
}
