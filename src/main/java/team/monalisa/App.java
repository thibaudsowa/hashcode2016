package team.monalisa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            int cursor = 0;
            final String[] firstRow = lines.get(cursor).split(" ");
            Integer mapRow = Integer.valueOf(firstRow[0]);
            Integer mapCol = Integer.valueOf(firstRow[0]);
            Integer nbDrones = Integer.valueOf(firstRow[0]);
            Integer deadLine = Integer.valueOf(firstRow[0]);
            Integer maxLoad = Integer.valueOf(firstRow[0]);
    
            cursor++;
            Integer nbProduit = Integer.valueOf(lines.get(1));
            
            cursor++;
            List<ProductType> productTypes = new ArrayList<>();
            final String[] productTypesWeigth = lines.get(cursor).split(" ");
            for (int i = 0; i < nbProduit; i++) {
                ProductType productType = new ProductType();
                productType.setWeigth(Integer.valueOf(productTypesWeigth[i]));
                productTypes.add(productType);
            }
            
            cursor++;
            Integer nbWareHouse = Integer.valueOf(lines.get(cursor));
            
            cursor++;
            List<WareHouse> wareHouses = new ArrayList<>();
            for (int i = 0; i < nbWareHouse; i++) {
                lines.get(cursor).split(" ");
            }
            
            
            
        } catch (IOException e) {
            System.out.println("Le fichier " + args[0] + " ne semble pas exister.");
            System.out.println("Usage : java -jar hashcode.jar file");
        }
    }

}
