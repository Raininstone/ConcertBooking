package concertbooking;

import java.io.IOException;

/**
 *
 * @authors Patrick Crossan B00663255 Ciaran Jordan B00663523
 */
public class ConcertBooking
{
    static String[] bookings = new String[90];
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)
            throws IOException
    {
        /*Adding temp change to get this to commit
        */
        try
        {
            ReadFile bookingsFile = new ReadBookings("Bookings.txt");
            String [] currentBookings = bookingsFile.openFile();
            for(int i = 0; i < currentBookings.length; i++)
            {
                bookings[i] = currentBookings[i];
            }
            /*THIS WILL CAUSE AN EXCEPTION ERROR WHEN ADDING A BOOKING NOT SURE
            * HOW TO FIX IT YET
            /if(bookings.length != 0);
            {
                concertHall.transferArray(bookings);
            }*/
            
            /* Just used this for testing to check data was being read in
            properly.
            */
            /*for(int i = 0; i < bookings.length; i++)
            {
                System.out.println(bookings[i]);
            }*/
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            ReadFile concertFile = new ReadConcert("ConcertDetails.txt");
            String[] concertDetails = concertFile.openFile();
            //Just testing again
            //System.out.println(concertDetails[0]);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        ConcertUI concertHall = new ConcertUI();
        concertHall.setTitle("Button Array Test");
        concertHall.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        concertHall.pack();
        concertHall.setVisible(true);
    }
}
