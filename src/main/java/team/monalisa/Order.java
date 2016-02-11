package team.monalisa;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by gbilley on 11/02/2016.
 */
public class Order extends Coordinate {
    Integer id;
    HashMap<ProductType, Integer> items = new HashMap<>();
    Integer nbItems;
    Boolean busy=false;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getNbItems() {
        return nbItems;
    }
    
    public void setNbItems(Integer nbItems) {
        this.nbItems = nbItems;
    }
    
    public HashMap<ProductType, Integer> getItems() {
        return items;
    }
    
    public void setItems(HashMap<ProductType, Integer> items) {
        this.items = items;
    }
    
    public Integer getWeight(){
        Integer weight = 0;
        final Set<ProductType> productTypes = items.keySet();
        for (ProductType productType : productTypes) {
            weight += productType.getWeigth()*items.get(productType);
        }
        return weight;   
    }
    
    public Boolean getBusy() {
        return busy;
    }
    
    public void setBusy(Boolean busy) {
        this.busy = busy;
    }
}
