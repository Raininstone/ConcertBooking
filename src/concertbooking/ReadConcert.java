package concertbooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ciaran Jordan B00663523 Patrick Crossan B00663255
 */
public class ReadConcert extends ReadFile
{
    public ReadConcert(String filePath)
    {
        super(filePath);
    }
    
    /* Reads from concert file and populates an array
    of size 1
    */
    @Override
    public String[] openFile()
            throws IOException
    {
        FileReader reader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(reader);
        
        String[] currentConcert = new String[1];
        currentConcert[0] = textReader.readLine();
        
        textReader.close();
        return currentConcert;
    }
}
