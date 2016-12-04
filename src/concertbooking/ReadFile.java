package concertbooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ciaran Jordan B00663523 Patrick Crossan B00663255
 */
public class ReadFile 
{
    private final String path;
    
    //Constructor containg pathway for file being accessed
    public ReadFile(String filePath)
    {
        path = filePath;
    }

    //Access the file and read in data
    public String[] OpenFile() 
        throws IOException
    {
        FileReader reader =  new FileReader(path);
        BufferedReader textReader = new BufferedReader(reader);
        
        int numOfLines = numLines();
        /*If amount of data is greater than 1 then it must contain
        customer details as the concert file will only store one concert
        at a time.
        */
        if(numOfLines > 1)
        {
            String[] bookings = new String[90];
            for(int i = 0; i < numOfLines; i++)
            {
                bookings[i] = textReader.readLine();
            }
            
            //Close file after access
            textReader.close();
            return bookings;
        }else
        {
            /*String of size 1, not sure how to convert to an Array to String
            so just done this. Might change.
            */
            String[] concertDetails = new String[1];
            concertDetails[0] = textReader.readLine(); 
            
            textReader.close();
            return concertDetails;
        }
    }
    
    //Count the number of data items in the file
    private int numLines()
            throws IOException
    {
        FileReader reader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(reader);
        
        String aLine;
        int numOfLines = 0;
        
        //While the next line isn't empty increment numOfLines
        while((aLine = textReader.readLine()) != null)
        {
            numOfLines++;
        }
        
        textReader.close();
        return numOfLines;
    }
}
