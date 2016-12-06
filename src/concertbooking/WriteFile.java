package concertbooking;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @authors Patrick Crossan B00663255 Ciaran Jordan B00663523
 */
public class WriteFile
{
    private PrintWriter out = null;
    private String path;
    
    //Constructor that sets up file path
    public WriteFile(String filePath)
    {
        path = filePath;
    }
    
    //Empties bookings file 
    public void clearFile() throws FileNotFoundException
    {
        PrintWriter printer = new PrintWriter("Bookings.txt");
        printer.close();
    }
    
    //Stores customer seat and name
    public void printToFile(String seatAndName)
    {
        String record = seatAndName;
        try 
        {
            FileWriter myWriter = new FileWriter(path,true);
            out = new PrintWriter(myWriter);
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage()); 
        } 
        
        out.println(record);
        System.out.println("Booking added to file");
        out.close();
    }
    
    //Stores customer seat, name and that they have a backstage pass
    public void printToFile(String seatAndName, Boolean hasBackstagePass)
    {
        String record = (seatAndName + " " + "Has Backstage Pass");
        try 
        {
            FileWriter myWriter = new FileWriter(path,true);
            out = new PrintWriter(myWriter);
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage()); 
        } 
        
        out.println(record);
        System.out.println("Booking added to file");
        out.close();
    }
    
    //Stores customer seat, name and that they have a programme
    public void printToFile(String seatAndName, String hasProgramme)
    {
        String record = (seatAndName + " " + hasProgramme);
        try 
        {
            FileWriter myWriter = new FileWriter(path,true);
            out = new PrintWriter(myWriter);
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage()); 
        } 
        
        out.println(record);
        System.out.println("Booking added to file");
        out.close();
    }
    
    //Print record to ConcertDetails
    public void printToFile(String concert,String concertDate,double goldPrice,double silverPrice,double bronzePrice)
    {
        String record = concert + " " + concertDate + " " + goldPrice + " " + silverPrice + " " + bronzePrice;
        try 
        {
            out = new PrintWriter(path);
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage()); 
        } 
        
        out.println(record);
        System.out.println("New concert entered");
        out.close();
    }
}

