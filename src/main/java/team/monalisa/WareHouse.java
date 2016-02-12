package team.monalisa;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by gbilley on 11/02/2016.
 */
public class WareHouse extends Coordinate {
    Integer id;
    HashMap<ProductType, Integer> inventory = new HashMap<>();
    HashMap<ProductType, Integer> previsionalInventory = new HashMap<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<ProductType, Integer> getInventory() {
        return inventory;
    }
    
    public void setInventory(HashMap<ProductType, Integer> inventory) {
        this.inventory = inventory;
    }

    public HashMap<ProductType, Integer> getPrevisionalInventory() {
        return previsionalInventory;
    }

    public void setPrevisionalInventory(HashMap<ProductType, Integer> previsionalInventory) {
        this.previsionalInventory = previsionalInventory;
    }
    
    public Boolean containsAll(Order bestOrder) {
        final Set<ProductType> productTypes = bestOrder.getItems().keySet();
        for (ProductType productType : productTypes) {
            if (this.getInventory().get(productType) < bestOrder.getItems().get(productType)){
                return false;
            }
        }
        return true;
    }
}
