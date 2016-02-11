package team.monalisa;

import java.util.HashMap;
import java.util.List;

/**
 * Created by gbilley on 11/02/2016.
 */
public class Utils {
    
    public static Integer getDistance(Coordinate from, Coordinate to) {
        final Long distance = Math
            .round(Math.sqrt(Math.abs(to.getRow() - from.getRow()) ^ 2 + Math.abs(to.getCol() - from.getCol()) ^ 2));
        return distance.intValue();
    }
    
    public static void addToInventory(HashMap<ProductType, Integer> inventory, ProductType productType,
                                      Integer nbItems) {
        if (inventory.containsKey(productType)) {
            inventory.put(productType, inventory.get(productType) + nbItems);
        } else {
            inventory.put(productType, nbItems);
        }
    }
    
    public static void removeFromInventory(HashMap<ProductType, Integer> inventory, ProductType productType,
                                           Integer nbItems) {
        if (inventory.containsKey(productType)) {
            inventory.put(productType, inventory.get(productType) - nbItems);
        }
    }
    
    public static List<Order> getBestOrders(Coordinate coordinate, List<Order> orders) {
        orders.sort((o1, o2) -> o1.getNbItems().compareTo(o2.getNbItems()));
        
        return orders;
    }
    
    public static void loadFromClosestWarehouse(Drone drone, List<ProductType> productTypes, Integer integer,
                                                List<WareHouse> wareHouses) {
        for (WareHouse wareHouse : wareHouses) {
            if (wareHouse.contains(ProductType pro))
        }
        
    }
    
    public static Order getBestOrder(Drone drone, List<Order> orders) {
        
        return null;
    }
}
