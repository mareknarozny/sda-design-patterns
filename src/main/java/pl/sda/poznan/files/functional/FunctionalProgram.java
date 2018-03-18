package pl.sda.poznan.files.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalProgram {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("plik.txt"));

        Map<String, Long> collect = lines.stream()
                .flatMap(line -> Stream.of(line.split("\\s|\\, |\\. |\\.")))
                .map(word -> word.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((key, value) -> System.out.println(key + "--------->" + value));
    }
}
