package pl.sda.poznan.files.fileopertion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHElper {

    //Old IO
    public static List<String> readAllLines(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            //w warunku pętli musimy przypsać wartość do zmiennej line i sprawdzić czy to co odczytaliśmy jest różne od null
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> splitLinesIntoWords(List<String> lines){
        List<String> wordsResult = new ArrayList<>();
        //przejsc  w petli przez liste lines,
        // dla każdego wykonuj rozdziel po spacji przecinku sredniku, wpisz wynik do listy words

        for(String line: lines){
            String[] words = line.split("\\s|\\, |\\. |\\.");
            wordsResult.addAll(Arrays.asList(words));
        }
        return wordsResult;
    }
}
