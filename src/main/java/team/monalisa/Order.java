package team.monalisa;

import java.util.HashMap;

/**
 * Created by gbilley on 11/02/2016.
 */
public class Order extends Coordinate {
    Integer id;
    HashMap<ProductType, Integer> items = new HashMap<>();
    Integer row;
    Integer col;
    Integer nbItems;
    
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
    
    public Integer getRow() {
        return row;
    }
    
    public void setRow(Integer row) {
        this.row = row;
    }
    
    public Integer getCol() {
        return col;
    }
    
    public void setCol(Integer col) {
        this.col = col;
    }
}
