package team.monalisa;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by thibaudsowa on 11/02/2016.
 */
public class DroneTest {
    @Test
    public void testDrone() throws IOException {

        Drone drone = new Drone();
        drone.setId(1);

        Order order = new Order();
        order.setId(5);

        ProductType productType = new ProductType();
        productType.setId(8);

        WareHouse wareHouse = new WareHouse();
        wareHouse.setId(25);

        drone.deliver(order, productType, 15);
        drone.load(wareHouse, productType, 125);

        Drone drone2 = new Drone();
        drone2.setId(2);

        drone2.unLoad(wareHouse, productType, 999);
        drone2.waitD(100);

        assertThat(App.output).isEqualTo("1 D 5 8 15\n"
                + "1 L 25 8 125\n"
                + "2 U 25 8 999\n"
                + "2 W 100\n");
    }
}
