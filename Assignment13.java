import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assignment13 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt"; 
        String outputFilePath = "output.txt"; 
        Map<String, Integer> wordCounts = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase(); 
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
        }
        
        System.out.println("Word counts written to " + outputFilePath);
    }
}
