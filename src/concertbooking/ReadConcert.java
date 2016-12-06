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
    private String currentConcert;
    private String[] parts;
    
    //Constructor setting up file path
    public ReadConcert(String filePath)
    {
        super(filePath);
    }
    
    //Opens concert file and stores the current concert
    @Override
    public void openFile()
            throws IOException
    {
        FileReader reader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(reader);
        
        currentConcert = textReader.readLine();
        
        textReader.close();
    }
    
    //Is a concert currently on
    public boolean isConcertOn()
    {
        boolean concertExists;
        if(currentConcert == null)
        {
            concertExists = false;
        }else
        {
            concertExists = true;
        }
        
        return concertExists;
    }
    
    //Return price of gold seats
    public double getGoldPrice()
    {
        parts = currentConcert.split(" ");
        double goldPrice = Double.parseDouble(parts[parts.length - 3]);
        
        return goldPrice;
    }
    
    //Return price of silver seats
    public double getSilverPrice()
    {
        parts = currentConcert.split(" ");
        double silverPrice = Double.parseDouble(parts[parts.length - 2]);
        
        return silverPrice;
    }
    
    //Return price of bronze seats
    public double getBronzePrice()
    {
        parts = currentConcert.split(" ");
        double bronzePrice = Double.parseDouble(parts[parts.length - 1]);
        
        return bronzePrice;
    }
    
    //Generic method to appease abstract class
    @Override
    public int[][] findBookedSeats()
    {
        int[][] seatPositions = new int[1][1];
        
        return seatPositions;
    }
}
