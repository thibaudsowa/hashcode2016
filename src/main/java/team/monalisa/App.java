package team.monalisa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {

    public static Integer deadLine = 0;
    static String output = "";

    public static void addToOutput(String stringToAdd) {
        output += stringToAdd + "\n";
    }

    public static void main(String[] args) {
        process("redundancy");
        process("busy_day");
        process("mother_of_all_warehouses");
    }

    public static void process(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName + ".in"));
            int cursor = 0;
            final String[] firstRow = lines.get(cursor).split(" ");
            Integer mapRow = Integer.valueOf(firstRow[0]);
            Integer mapCol = Integer.valueOf(firstRow[1]);
            Integer nbDrones = Integer.valueOf(firstRow[2]);
            deadLine = Integer.valueOf(firstRow[3]);
            Integer maxLoad = Integer.valueOf(firstRow[4]);

            cursor++;
            Integer nbProduit = Integer.valueOf(lines.get(1));

            cursor++;
            List<ProductType> productTypes = new ArrayList<>();
            final String[] productTypesWeigth = lines.get(cursor).split(" ");
            for (int i = 0; i < nbProduit; i++) {
                ProductType productType = new ProductType();
                productType.setId(i);
                productType.setWeigth(Integer.valueOf(productTypesWeigth[i]));
                productTypes.add(productType);
            }

            cursor++;
            Integer nbWareHouse = Integer.valueOf(lines.get(cursor));

            cursor++;
            List<WareHouse> wareHouses = new ArrayList<>();
            for (int i = 0; i < nbWareHouse; i++) {
                WareHouse wareHouse = new WareHouse();
                wareHouse.setId(i);
                final String[] wareHouseCoordinate = lines.get(cursor).split(" ");
                wareHouse.setRow(Integer.valueOf(wareHouseCoordinate[0]));
                wareHouse.setCol(Integer.valueOf(wareHouseCoordinate[1]));
                cursor++;

                final String[] productQuantity = lines.get(cursor).split(" ");
                for (int j = 0; j < productTypes.size(); j++) {
                    wareHouse.getInventory().put(productTypes.get(j), Integer.valueOf(productQuantity[j]));
                    wareHouse.getPrevisionalInventory().put(productTypes.get(j), Integer.valueOf(productQuantity[j]));
                }
                wareHouses.add(wareHouse);
                cursor++;
            }
            List<Drone> drones = new ArrayList<>();

            for (int i = 0; i < nbDrones; i++) {
                Drone drone = new Drone();
                drone.setId(i);
                drone.setRow(wareHouses.get(0).getRow());
                drone.setCol(wareHouses.get(0).getCol());
                drone.setInventory(new HashMap<>());
                drones.add(drone);
            }

            Integer nbOrders = Integer.valueOf(lines.get(cursor));
            List<Order> orders = new ArrayList<>();
            cursor++;
            for (int i = 0; i < nbOrders; i++) {
                Order order = new Order();
                order.setId(i);
                final String[] orderCoordinate = lines.get(cursor).split(" ");
                order.setRow(Integer.valueOf(orderCoordinate[0]));
                order.setCol(Integer.valueOf(orderCoordinate[1]));

                cursor++;
                Integer nbItems = Integer.valueOf(lines.get(cursor));
                order.setNbItems(nbItems);

                cursor++;
                final String[] typeOfItems = lines.get(cursor).split(" ");
                for (String typeOfItem : typeOfItems) {
                    ProductType productType = productTypes.get(Integer.valueOf(typeOfItem));
                    Integer nbOfItem = 1;
                    if (order.getItems().containsKey(productType)) {
                        nbOfItem = order.getItems().get(productType) + 1;
                    }
                    order.getItems().put(productType, nbOfItem);
                }
                cursor++;
                orders.add(order);
            }

            final Compteur compteur = new Compteur();
            int finished = 0;
            boolean noMoreOrder = false;
            while (finished < nbDrones && !noMoreOrder) {
                finished = 0;
                for (Drone drone : drones) {
                    if (Utils.getBestOrders(drone, orders).isEmpty()) {
                        noMoreOrder = true;
                        break;
                    }
                    if (!drone.isFinish()) {
                        drone.setBusy(true);
                        Order bestOrder = Utils.getBestOrders(drone, orders).get(0);
                        bestOrder.setFinished(true);

                        final Set<ProductType> orderProductTypes = bestOrder.getItems().keySet();
                        final WareHouse optimalWareHouse = Utils.getOptimalWareHouse(drone, bestOrder, wareHouses);
                        if (optimalWareHouse != null) {
                            for (ProductType orderProductType : orderProductTypes) {
                                compteur.add(
                                        drone.load(optimalWareHouse, orderProductType,
                                                bestOrder.getItems().get(orderProductType), maxLoad));
                            }
                            for (ProductType orderProductType : orderProductTypes) {
                                compteur.add(
                                        drone.deliver(bestOrder, orderProductType, bestOrder.getItems().get(orderProductType)));
                            }
                        }
                    } else {
                        finished++;
                    }
                }
            }
            output = compteur.getNbAction() + "\n" + output;
            System.out.println(output);
            Files.write(Paths.get(fileName + ".out"), output.getBytes());

            //RAZ
            
            output = "";

        } catch (IOException e) {
            //            System.out.println("Le fichier " + args[0] + " ne semble pas exister.");
            System.out.println("Usage : java -jar hashcode.jar file");
        }
    }

}
