package team.monalisa;

import java.util.HashMap;

/**
 * Created by gbilley on 11/02/2016.
 */
public class WareHouse {
    Integer id;
    HashMap<ProductType, Integer> inventory = new HashMap<>();
    Integer row;
    Integer col;

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
