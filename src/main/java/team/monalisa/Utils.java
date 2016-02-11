package team.monalisa;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        final Stream<Order> validOrder = orders.stream().filter(o -> !o.getBusy());
        final List<Order> sortedOrders = validOrder.collect(Collectors.toList());
        sortedOrders.sort((o1, o2) -> o1.getNbItems().compareTo(o2.getNbItems()));
        return sortedOrders;
        
    }
    
    public static WareHouse getOptimalWareHouse(Order bestOrder, List<WareHouse> wareHouses) {
        for (WareHouse wareHouse : wareHouses) {
            if (wareHouse.containsAll(bestOrder)){
                return wareHouse;
            }
        }
        return null;
    }
}
