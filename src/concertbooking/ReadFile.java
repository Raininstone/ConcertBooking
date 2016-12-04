package concertbooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ciaran Jordan B00663523 Patrick Crossan B00663255
 */
public abstract class ReadFile 
{
    protected final String path;
    
    //Constructor containg pathway for file being accessed
    public ReadFile(String filePath)
    {
        path = filePath;
    }

    //Abstract class for opening files
    abstract String[] openFile() 
        throws IOException;
    
    //Count the number of data items in the file
    protected int numLines()
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
