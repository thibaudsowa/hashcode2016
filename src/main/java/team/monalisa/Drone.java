package team.monalisa;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by thibaudsowa on 11/02/2016.
 */
public class Drone extends Coordinate {
    
    int id;
    boolean busy;
    HashMap<ProductType, Integer> inventory = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer load(WareHouse wareHouse, ProductType productType, Integer nbItems) {

        Utils.removeFromInventory(wareHouse.getInventory(), productType, nbItems);
        Utils.addToInventory(inventory, productType, nbItems);

        String cmd = id + " L " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);

        return Utils.getDistance(this, wareHouse) + 1;
    }
    
    public Integer unLoad(WareHouse wareHouse, ProductType productType, Integer nbItems) {

        Utils.removeFromInventory(inventory, productType, nbItems);
        Utils.addToInventory(wareHouse.getInventory(), productType, nbItems);

        String cmd = id + " U " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);

        return Utils.getDistance(this, wareHouse) + 1;
    }
    
    public Integer deliver(Order order, ProductType productType, Integer nbItems) {

        Utils.removeFromInventory(inventory, productType, nbItems);
        Utils.removeFromInventory(order.getItems(), productType, nbItems);

        String cmd = id + " D " + order.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);

        return Utils.getDistance(this, order) + 1;
    }
    
    public Integer waitD(Integer nbTurn) {
        String cmd = id + " W " + nbTurn;
        App.addToOutput(cmd);
        
        return nbTurn;
    }
    
    public HashMap<ProductType, Integer> getInventory() {
        return inventory;
    }
    
    public void setInventory(HashMap<ProductType, Integer> inventory) {
        this.inventory = inventory;
    }
    
    public Boolean isEmpty(){
        final Set<ProductType> productTypes = inventory.keySet();
        Boolean isEmpty = true;
        for (ProductType productType : productTypes) {
            if (this.inventory.get(productType)>0){
                isEmpty=false;
            }
        }
        return isEmpty;
    }
}
