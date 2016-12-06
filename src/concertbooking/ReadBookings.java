package concertbooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ciaran Jordan B00663523 Patrick Crossan B00663255
 */
public class ReadBookings extends ReadFile
{
    private String[] bookings;
    private int numBooked;
    
    //Constructor setting up file path
    public ReadBookings(String filePath)
    {
        super(filePath);
    }
    
    /*Reads from the bookings file and populates an 
    array matching the size of the number of stored
    records
    */
    @Override
    public void openFile()
            throws IOException
    {
        FileReader reader =  new FileReader(path);
        BufferedReader textReader = new BufferedReader(reader);
        
        int fileLength = numLines();
        bookings = new String[fileLength];
        
        for(int i = 0; i < fileLength; i++)
        {
            bookings[i] = textReader.readLine();
        }
        
        textReader.close();
    }
    
    /*Finds the rows and columns coordinates of 
    booked seats and stores them in a 2D array
    */
    @Override
    public int[][] findBookedSeats()
    {
        int[][] seatPositions = new int[bookings.length][2];
        
        for(int i = 0; i < bookings.length; i++)
        {
            seatPositions[i][0] = getRow(bookings[i]);
            seatPositions[i][1] = getColumn(bookings[i]);
        }
        
        return seatPositions;
    }
    
    //Returns number of gold seats booked
    public int getNumOfGoldBooked()
    {
        int counter = 0;
        
        for(int i = 0; i < bookings.length; i++)
        {
            String seatType = bookings[i].substring(0, 1);
            
            switch(seatType)
            {
                case "A":
                    counter++;
                    break;
                case "B":
                    counter++;
                    break;
                case "C":
                    counter++;
                    break;
            }
        }
        
        return counter;
    }
    
    //Returns number of silver seats booked
    public int getNumOfSilverBooked()
    {
        int counter = 0;
        
        for(int i = 0; i < bookings.length; i++)
        {
            String seatType = bookings[i].substring(0, 1);
            
            switch(seatType)
            {
                case "D":
                    counter++;
                    break;
                case "E":
                    counter++;
                    break;
                case "F":
                    counter++;
                    break;
            }
        }
        
        return counter;
    }
    
    //Returns number of bronze seats booked
    public int getNumOfBronzeBooked()
    {
        int counter = 0;
        
        for(int i = 0; i < bookings.length; i++)
        {
            String seatType = bookings[i].substring(0, 1);
            
            switch(seatType)
            {
                case "G":
                    counter++;
                    break;
                case "H":
                    counter++;
                    break;
                case "I":
                    counter++;
                    break;
            }
        }
        
        return counter;
    }
    
    //Clears a file and enters the seats still booked excluding unbooked seat
    public void unbookSeat(int row, int column)
    {
        WriteFile revisedBookings = new WriteFile("Bookings.txt");
        String seatToUnbook;
        
        try
        {
            revisedBookings.clearFile();
        }catch(IOException e)
        {
            e.getMessage();
        }
        
        String strRow = getRow(row);
        String strColumn = getColumn(column);
        seatToUnbook = strRow + strColumn;
        
        for(int i = 0; i < bookings.length; i++)
        {
            String[] parts = bookings[i].split(" ");
            String currentSeat = parts[0];
            if(!currentSeat.equals(seatToUnbook))
            {
                revisedBookings.printToFile(bookings[i]);
            }
        }
    }
    
    //Finds the row of a booked seat
    private int getRow(String seat)
    {
        String strRow = seat.substring(0, 1);
        int row = 0;
        
        switch(strRow)
        {
            case "A": 
                row = 0;
                break;
            case "B":
                row = 1;
                break;
            case "C":
                row = 2;
                break;
            case "D":
                row = 3;
                break;
            case "E":
                row = 4;
                break;
            case "F":
                row = 5;
                break;
            case "G":
                row = 6;
                break;
            case "H":
                row = 7;
                break;
            case "I":
                row = 8;
                break;
        }
        
        return row;
    }
    
    //Returns array index based on seat row
    private String getRow(int row)
    {
        String strRow = "A";
        
        switch(row)
        {
            case 0:
                strRow = "A";
                break;
            case 1:
                strRow = "B";
                break;
            case 2:
                strRow = "C";
                break;
            case 3:
                strRow = "D";
                break;
            case 4:
                strRow = "E";
                break;
            case 5:
                strRow = "F";
                break;
        }
        
        return strRow;
    }
    
    //Finds the column of a booked seat
    private int getColumn(String seat)
    {
        String strColumn = seat.substring(1, 3);
        int column = 0;
        
        switch(strColumn)
        {
            case "1 ":
                column = 9;
                break;
            case "2 ":
                column = 8;
                break;
            case "3 ":
                column = 7;
                break;
            case "4 ":
                column = 6;
                break;
            case "5 ":
                column = 5;
                break;
            case "6 ":
                column = 4;
                break;
            case "7 ":
                column = 3;
                break;
            case "8 ":
                column = 2;
                break;
            case "9 ":
                column = 1;
                break;
            case "10":
                column = 0;
                break;
        }
        
        return column;
    }
    
    //Returns array index based on seat column
    private String getColumn(int column)
    {
        String strColumn = "1";
        
        switch(column)
        {
            case 0:
                strColumn = "10";
                break;
            case 1:
                strColumn = "9";
                break;
            case 2:
                strColumn = "8";
                break;
            case 3:
                strColumn = "7";
                break;
            case 4:
                strColumn = "6";
                break;
            case 5:
                strColumn = "5";
                break;
            case 6:
                strColumn = "4";
                break;
            case 7:
                strColumn = "3";
                break;
            case 8:
                strColumn = "2";
                break;
            case 9:
                strColumn = "1";
                break;
        }
        
        return strColumn;
    }
    
    //Uses customer name to search for booked seat. If no match alerts admin.
    public void searchForSeat(String searchedName)
    {
        boolean customerExists = false;
        
        for(int i=0; i < bookings.length; i++)
        {
            if(bookings[i] != null)
            {
                if(bookings[i].contains(searchedName))
                {
                    String[] parts = bookings[i].split(" ");
                    JOptionPane.showMessageDialog(null, searchedName + " has booked " + parts[0]);
                    customerExists = true;
                }
            }
        }
        
        if(customerExists == false)
        {
            JOptionPane.showMessageDialog(null, "Person hasn't booked any seats");
        }
    }
    
    //Searches for details on seat and returns info if booked, if not alerts admin
    public void searchForCustomer(String searchedSeat)
    {
        boolean isBooked = false;
        
        for(int i=0; i < bookings.length; i++)
        {
            if(bookings[i] != null)
            {
                if(bookings[i].contains(searchedSeat))
                {
                    int startPos = bookings[i].indexOf(" ");
                    JOptionPane.showMessageDialog(null, searchedSeat + " has been booked by " + bookings[i].substring(startPos + 1));
                    isBooked = true;
                }
            }
        }
        
        if(isBooked == false)
        {
            JOptionPane.showMessageDialog(null, "Seat isn't booked");
        }
    }
    
    //This method returns the amount of booked seats
    public int bookedCount()
    {
        numBooked = bookings.length;
        return numBooked;
    }
    
    //This method returns the amount of unbooked seats
    public int unbookedCount()
    {
        return 90 - numBooked;
    }
}
