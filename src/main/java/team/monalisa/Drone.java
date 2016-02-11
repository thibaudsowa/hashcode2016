package team.monalisa;

import java.util.List;

/**
 * Created by thibaudsowa on 11/02/2016.
 */
public class Drone {

    int id;
    List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void load(WareHouse wareHouse, ProductType productType, Integer nbItems) {
        String cmd = id + " L " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    }

    public void unLoad(WareHouse wareHouse, ProductType productType, Integer nbItems) {
        String cmd = id + " U " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    }

    public void deliver(Order order, ProductType productType, Integer nbItems) {
        String cmd = id + " D " + order.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    }


    public void waitD(Integer nbTurn) {
        String cmd = id + " W " + nbTurn;
        App.addToOutput(cmd);
    }


}
