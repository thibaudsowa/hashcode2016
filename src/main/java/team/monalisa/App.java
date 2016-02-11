package team.monalisa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
        } catch (IOException e) {
            System.out.println("Le fichier " + args[0] + " ne semble pas exister.");
            System.out.println("Usage : java -jar hashcode.jar file");
        }
    }

}
