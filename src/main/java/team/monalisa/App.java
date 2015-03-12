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
            List<List<Character>> characters = splitFile(args);
            characters.forEach(l -> System.out.println(l));
        } catch (IOException e) {
            System.out.println("Le fichier "+args[0]+" ne semble pas exister.");
            System.out.println("Usage : java -jar hashcode.jar file");
        }
    }

    private static List<List<Character>> splitFile(String[] args) throws IOException {
        Stream<String> inputLines;
        List<List<Character>> characters = new ArrayList<>();

        inputLines = Files.lines(Paths.get(args[0]));

        inputLines.forEach(l -> {
            List<Character> charLine = new ArrayList<>();
            l.chars().forEach(c -> charLine.add(Character.valueOf((char) c)));
            characters.add(charLine);
        });

        return characters;
    }


}
