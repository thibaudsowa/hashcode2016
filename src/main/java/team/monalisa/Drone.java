package team.monalisa;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by thibaudsowa on 11/02/2016.
 */
public class Drone extends Coordinate {
    
    int id;
    boolean busy = false;
    HashMap<ProductType, Integer> inventory = new HashMap<>();
    int tTotal = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean isFinish() {
        return tTotal >= App.deadLine;
    }

    public Integer load(WareHouse wareHouse, ProductType productType, Integer nbItems, Integer maxLoad) {


        if (getWeight() + productType.getWeigth()*nbItems >= maxLoad){
            return 0;
        }
        Utils.removeFromInventory(wareHouse.getInventory(), productType, nbItems);
        Utils.addToInventory(inventory, productType, nbItems);

        updateCoordinate(wareHouse);

        String cmd = id + " L " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);

        int t = Utils.getDistance(this, wareHouse) + 1;
        tTotal += t;

        return t;
    }
    
    public Integer unLoad(WareHouse wareHouse, ProductType productType, Integer nbItems) {

        if (inventory.get(productType) < nbItems){
            return 0;
        }

        Utils.removeFromInventory(inventory, productType, nbItems);
        Utils.addToInventory(wareHouse.getInventory(), productType, nbItems);
    
        updateCoordinate(wareHouse);
        
        String cmd = id + " U " + wareHouse.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);

        if (isEmpty()) {
            busy=false;
        }


        int t = Utils.getDistance(this, wareHouse) + 1;
        tTotal += t;

        return t;
    }
    
    public Integer deliver(Order order, ProductType productType, Integer nbItems) {

        if (!inventory.containsKey(productType) || inventory.get(productType) < nbItems){
            return 0;
        }

        Utils.removeFromInventory(inventory, productType, nbItems);
        Utils.removeFromInventory(order.getItems(), productType, nbItems);
    
        updateCoordinate(order);
        
        String cmd = id + " D " + order.getId() + " " + productType.getId() + " " + nbItems;
        App.addToOutput(cmd);
    
        if (isEmpty()) {
            busy = false;
        }

        int t = Utils.getDistance(this, order) + 1;
        tTotal += t;

        return t;
    }
    
    public boolean isBusy() {
        return busy;
    }
    
    public void setBusy(boolean busy) {
        this.busy = busy;
    }
    
    private void updateCoordinate(Coordinate wareHouse) {
        this.setRow(wareHouse.getRow());
        this.setCol(wareHouse.getCol());
    }
    
    public Integer waitD(Integer nbTurn) {
        String cmd = id + " W " + nbTurn;
        App.addToOutput(cmd);

        tTotal += nbTurn;

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

    public Integer getWeight() {
        Integer weight = 0;
        final Set<ProductType> productTypes = inventory.keySet();
        for (ProductType productType : productTypes) {
            weight += productType.getWeigth() * inventory.get(productType);
        }
        return weight;
    }
}
