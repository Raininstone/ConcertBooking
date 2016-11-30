package concertbooking;

import java.io.IOException;

/**
 *
 * @authors Patrick Crossan B00663255 Ciaran Jordan B00663523
 */
public class ConcertBooking
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)
            throws IOException
    {
        try
        {
            ReadFile bookingsFile = new ReadFile("Bookings.txt");
            String [] bookings = bookingsFile.OpenFile();
            /* Just used this for testing to check data was being read in
            properly.
            */
            /**for(int i = 0; i < bookings.length; i++)
            {
                System.out.println(bookings[i]);
            }*/
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            ReadFile concertFile = new ReadFile("ConcertDetails.txt");
            String[] concertDetails = concertFile.OpenFile();
            //Just testing again
            //System.out.println(concertDetails[0]);
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        ConcertUI myUI = new ConcertUI();
        myUI.setVisible(true);
    }
}
