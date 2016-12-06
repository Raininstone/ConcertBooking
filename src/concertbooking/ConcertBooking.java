package concertbooking;

import java.io.IOException;

/**
 *
 * @authors Patrick Crossan B00663255 Ciaran Jordan B00663523
 */
public class ConcertBooking
{
    private static ReadFile accessFile;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)
            throws IOException
    {
        /*
        Creates the UI, sets the title, stops program when closes,
        sizes the frame to match what it contains, and makes it visible.
        */
        ConcertUI concertHall = new ConcertUI();
        concertHall.setTitle("Concert Seat Booking");
        concertHall.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        concertHall.pack();
        concertHall.setVisible(true);
        
        //Checks if a concert already exists
        try
        {
            ReadFile concertFile = new ReadConcert("ConcertDetails.txt");
            concertFile.openFile();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        //Checks if any seats are already booked.
        try
        {
            accessFile = new ReadBookings("Bookings.txt");
            accessFile.openFile();
            
            int[][] seatPositions = accessFile.findBookedSeats();
            for(int i = 0; i < seatPositions.length; i++)
            {
                concertHall.isBooked(seatPositions[i][0], seatPositions[i][1]);
            }
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
