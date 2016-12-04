package concertbooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ciaran Jordan B00663523 Patrick Crossan B00663255
 */
public class ReadBookings extends ReadFile
{
    public ReadBookings(String filePath)
    {
        super(filePath);
    }
    
    /*Reads from the bookings file and populates an 
    array matching the size of the number of stored
    records
    */
    @Override
    public String[] openFile()
            throws IOException
    {
        FileReader reader =  new FileReader(path);
        BufferedReader textReader = new BufferedReader(reader);
        
        int fileLength = numLines();
        String[] bookings = new String[fileLength];
        
        for(int i = 0; i < fileLength; i++)
        {
            bookings[i] = textReader.readLine();
        }
        
        textReader.close();
        return bookings;
    }
}
