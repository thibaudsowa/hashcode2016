package team.monalisa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Stream<String> inputLines = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            DataCenter dataCenter = new DataCenter(lines);
        } catch (IOException e) {
            System.out.println("Le fichier "+args[0]+" ne semble pas exister.");
            System.out.println("Usage : java -jar hashcode.jar file");
        }
    }

}
