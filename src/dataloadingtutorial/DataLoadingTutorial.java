package dataloadingtutorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataLoadingTutorial
{

    public final static String PATH = "C:\\Users\\Samson\\Documents\\NetBeansProjects\\DataLoadingTutorial\\src\\";

    public static void saveData(ArrayList<String> data, String filePath)
    {
        try (PrintWriter writer = new PrintWriter(filePath, StandardCharsets.UTF_8.name()))
        {
            for (String line : data)
            {
                writer.println(line);
            }
        }
        catch (FileNotFoundException | UnsupportedEncodingException ex)
        {
            Logger.getLogger(DataLoadingTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<String> loadData(String filePath)
    {
        ArrayList<String> loadedData = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                loadedData.add(line);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(DataLoadingTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadedData;
    }

    public static void main(String[] args)
    {
        ArrayList<String> data = new ArrayList();
        data.add("test123");
        data.add("test456");
        saveData(data, PATH + "test.txt");
        System.out.println("Inhoud:");
        for (String line : loadData(PATH + "test.txt"))
        {
            System.out.println(line);
        }

        // Alternative: Java 8 way with Streams
        try
        {
            System.out.println("");
            System.out.println("Inhoud:");
            Files.lines(Paths.get(PATH + "test.txt")).forEach(System.out::println);
        }
        catch (IOException ex)
        {
            Logger.getLogger(DataLoadingTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
