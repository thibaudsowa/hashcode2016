package team.monalisa;

import java.util.HashMap;

/**
 * Created by thibaudsowa on 11/02/2016.
 */
public class Drone {

    int id;
    HashMap<ProductType, Integer> inventory = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void load(WareHouse wareHouse, ProductType productType, Integer nbItems) {

        Utils.removeFromInventory(wareHouse.getInventory(), productType, nbItems);
        Utils.addToInventory(inventory, productType, nbItems);

        String cmd = id + " L " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    }

    public void unLoad(WareHouse wareHouse, ProductType productType, Integer nbItems) {

        Utils.removeFromInventory(inventory, productType, nbItems);
        Utils.addToInventory(wareHouse.getInventory(), productType, nbItems);

        String cmd = id + " U " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    }

    public void deliver(Order order, ProductType productType, Integer nbItems) {

        Utils.removeFromInventory(inventory, productType, nbItems);
        Utils.removeFromInventory(order.getItems(), productType, nbItems);

        String cmd = id + " D " + order.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    }


    public void waitD(Integer nbTurn) {
        String cmd = id + " W " + nbTurn;
        App.addToOutput(cmd);
    }


}
