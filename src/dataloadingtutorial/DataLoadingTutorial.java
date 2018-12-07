package dataloadingtutorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataLoadingTutorial
{

    public final static String PATH = "C:\\Users\\Samson\\Documents\\NetBeansProjects\\DataLoadingTutorial\\src\\";

    public static void saveData(ArrayList<String> data, String filePath)
    {
        try
        {
            PrintWriter writer = new PrintWriter(filePath, "UTF-8");
            for (String line : data)
            {
                writer.println(line);
            }
            writer.close();
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
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(DataLoadingTutorial.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
