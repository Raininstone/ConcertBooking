package concertbooking;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @authors Patrick Crossan B00663255 Ciaran Jordan B00663523
 */
public class FileAccess
{
    /*Changed name of array to bookings, keep it general
    Also need to find a way to use single array for storing bookings across 
    multiple classes.
    */
    private String[] bookings = new String[90];
    /*Need to change arraySize to accomodate for the data that already
    exists in and will be loaded from the text file. 
    */
    private int arraySize = 0;
    private PrintWriter out = null;
    private String path;
    
    /*Removed concert given only 1 concert needs to exist at any given
    time, so any booking is associated with that concert. No need for 
    specifying.
    */
    
    //This method returns the amount of booked seats
    public int bookedCount()
    {
        return arraySize;
    }
    
    //This method returns the amount of unbooked seats
    public int unbookedCount()
    {
        return 90 - arraySize;
    }
    
    public void resetArray()
    {
        arraySize = 0;
        Arrays.fill(bookings, null);
    }
    
    public void clearFile() throws FileNotFoundException
    {
        PrintWriter printer = new PrintWriter("Bookings.txt");
        printer.close();
    }
    
    public void continueTransfer(String[] readArray)
    {
        //define a new array + allocate space
        bookings = new String[readArray.length];
 
        //copy values
        for(int i =0;i < readArray.length;i++)
        {
            bookings[i] = readArray[i];
            if(bookings[i] != null)
            {
                arraySize++;
            }
        }
    }
    
    public void printToBookings(String name,String seat)
    {
        bookings[arraySize] = name+" "+seat;
        try 
        {
            FileWriter myWriter = new FileWriter("Bookings.txt",true);
            out = new PrintWriter(myWriter);
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage()); 
        } 
        
        out.println(bookings[arraySize]);
        System.out.println("Booking added to file");
        out.close();
        arraySize++;
    }
    
    public void printToConcertDetails(String concert,String concertDate,double goldPrice,double silverPrice,double bronzePrice)
    {
        String concertInfo = concert+" "+concertDate+" "+goldPrice+" "+silverPrice+" "+bronzePrice;
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

