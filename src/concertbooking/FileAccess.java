package concertbooking;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @authors Patrick Crossan B00663255 Ciaran Jordan B00
 */
public class FileAccess
{
    private final String[] myBookings = new String[90];
    private int arraySize = 0;
    private PrintWriter out = null;
    
    public void printToBookings(String name,String seat,String concert)
    {
        myBookings[arraySize] = name+" "+seat+" "+concert;
        try 
        {
            FileWriter myWriter = new FileWriter("Bookings.txt",true);
            out = new PrintWriter(myWriter);
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage()); 
        } 
        
        out.println(myBookings[arraySize]);
        System.out.println("Booking added to file");
        out.close();
        arraySize++;
    }
    
    public void printToConcertDetails(String concert,String concertDate)
    {
        String concertInfo = concert+" "+concertDate;
        try 
        {
            out = new PrintWriter("ConcertDetails.txt");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage()); 
        } 
        
        out.println(concertInfo);
        System.out.println("New concert entered");
        out.close();
    }
}

