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
    /*Adding temp change to get this to commit
        */
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
    
    public void searchForSeat(String searchedName)
    {
        for(int i=0; i<=bookings.length; i++)
        {
            if(bookings[i] != null)
            {
                if(bookings[i].contains(searchedName))
                {
                    JOptionPane.showMessageDialog(null,searchedName+" has booked "+bookings[i].substring(bookings[i].lastIndexOf(' ')+ 1));
                }
            }
        }
    }
    
    public void searchForCustomer(String searchedSeat)
    {
        for(int i=0; i<bookings.length; i++)
        {
            if(bookings[i] != null)
            {
                if(bookings[i].contains(searchedSeat))
                {
                    JOptionPane.showMessageDialog(null,searchedSeat+" has been booked by "+bookings[i].substring(0,bookings[i].indexOf(" ", bookings[i].indexOf(" ",bookings[i].indexOf(" ",bookings[i].indexOf(" ",bookings[i].indexOf(" ",bookings[i].indexOf(" ")+1)+1)+1)+1)+1)));
                }
            }
        }
    }
    
    public void printToBookings(String name,String backstagePass,String freeProgramme,String seat)
    {
        bookings[arraySize] = name+" "+backstagePass+" "+freeProgramme+" "+seat;
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

