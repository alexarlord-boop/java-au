package generator2;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IOUtil {

    static List<String> readData(String inPath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inPath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file found.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    static void writeData(String outPath, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
