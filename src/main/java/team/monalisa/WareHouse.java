package team.monalisa;

import java.util.HashMap;

/**
 * Created by gbilley on 11/02/2016.
 */
public class WareHouse {
    HashMap<ProductType, Integer> inventory = new HashMap<>();
    
    public HashMap<ProductType, Integer> getInventory() {
        return inventory;
    }
    
    public void setInventory(HashMap<ProductType, Integer> inventory) {
        this.inventory = inventory;
    }
}
