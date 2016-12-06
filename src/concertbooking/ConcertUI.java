package concertbooking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/**
 *
 * @author Ciaran Jordan B00663523 Patrick Crossan B00663255
 */
public class ConcertUI extends javax.swing.JFrame
{ 
    private JButton[][] buttons = new JButton[9][10];
    private double totalPrice;
    private double goldPrice;
    private double silverPrice;
    private double bronzePrice;
    private int goldCounter = 0;
    private int silverCounter = 0;
    private int bronzeCounter = 0;
    private WriteFile newBooking = new WriteFile("Bookings.txt");
    
    /**Constructor that creates the UI and checks how many of each seat is booked
     * and what the current prices are for each type of seat
     */
    public ConcertUI()
    {
        JPanel goldPanelSet1 = new JPanel();
        JPanel goldPanelSet2 = new JPanel();
        JPanel goldSeats = new JPanel();
        JPanel silverPanelSet1 = new JPanel();
        JPanel silverPanelSet2 = new JPanel();
        JPanel silverSeats = new JPanel();
        JPanel bronzePanelSet1 = new JPanel();
        JPanel bronzePanelSet2 = new JPanel();
        JPanel bronzeSeats = new JPanel();
        
        JPanel mainPanel = new JPanel();
        
        JLabel[] seatRows = new JLabel[9];
        JPanel row = new JPanel();
        JLabel[] seatColumns = new JLabel[10];
        JPanel column = new JPanel();
        
        JLabel stage = new JLabel("STAGE");
        JLabel fireExit1 = new JLabel("FIRE EXIT");
        JLabel fireExit2 = new JLabel("FIRE EXIT");
        JLabel mainEntrance = new JLabel("ENTRANCE");
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newConcert = new JMenuItem("New Concert");
        JMenuItem showReport = new JMenuItem("Show Report");
        JMenuItem querySeatPurchaser = new JMenuItem("Query Seat Purchaser");
        JMenuItem querySeatStatus = new JMenuItem("Query Seat Status");
        
        //Checks for current prices if a concert exists
        ReadConcert currentPrice = new ReadConcert("ConcertDetails.txt");
        try
        {
            currentPrice.openFile();
            boolean concertExists = currentPrice.isConcertOn();
            if(concertExists == true)
            {
                goldPrice = currentPrice.getGoldPrice();
                silverPrice = currentPrice.getSilverPrice();
                bronzePrice = currentPrice.getBronzePrice();
            }
        }catch(IOException e)
        {
            e.getMessage();
        }
        
        //Checks number of each seat type
        ReadBookings currentNumSeatType = new ReadBookings("Bookings.txt");
        try
        {
            currentNumSeatType.openFile();
        }catch(IOException e)
        {
            e.getMessage();
        }
        goldCounter = currentNumSeatType.getNumOfGoldBooked();
        silverCounter = currentNumSeatType.getNumOfSilverBooked();
        bronzeCounter = currentNumSeatType.getNumOfBronzeBooked();
        
        //Fills button array with button objects
        createButtons();
        
        //Fills label array with label objects and sets the text in each label
        for(int i = 0; i < 9; i++)
        {
            seatRows[i] = new JLabel();
        }
        seatRows[0].setText("A");
        seatRows[1].setText("B");
        seatRows[2].setText("C");
        seatRows[3].setText("D");
        seatRows[4].setText("E");
        seatRows[5].setText("F");
        seatRows[6].setText("G");
        seatRows[7].setText("H");
        seatRows[8].setText("I");
        
        //Fills label array with label objects and sets the text in each label
        for(int i = 0; i < 10; i++)
        {
            seatColumns[i] = new JLabel();
            seatColumns[i].setText(Integer.toString(i+1));
        }
        
        /*Adds menu with each option in the menu. Adds listeners to each menu
        button.*/
        newConcert.addActionListener(new newConcertListener());
        showReport.addActionListener(new showReportListener());
        querySeatPurchaser.addActionListener(new querySeatPurchaserListener());
        querySeatStatus.addActionListener(new querySeatStatusListener());
        fileMenu.add(newConcert);
        fileMenu.add(showReport);
        fileMenu.add(querySeatPurchaser);
        fileMenu.add(querySeatStatus);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        /**GUI Builder creates layered panels and adds them to a frame. A Panel
         * will contain 15 buttons each. Then depending 2 panels of 15 buttons are
         * grouped under a larger panel. The 3 panels containing 30 buttons are then
         * added to the main panel which is then added to the frame. There are 2 other panels
         * in which one contains the labels for the rows and the other for the columns.
         */
// <editor-fold defaultstate="collapsed" desc=" GUI Builder ">
        //Sets up panel of 15 buttons
        GroupLayout goldSet1Layout = new GroupLayout(goldPanelSet1);
        goldPanelSet1.setLayout(goldSet1Layout);
        goldSet1Layout.setAutoCreateGaps(true);
        goldSet1Layout.setAutoCreateContainerGaps(true);
        goldSet1Layout.setHorizontalGroup(
                goldSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(goldSet1Layout.createSequentialGroup()
                                .addComponent(buttons[0][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(goldSet1Layout.createSequentialGroup()
                                .addComponent(buttons[1][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(goldSet1Layout.createSequentialGroup()
                                .addComponent(buttons[2][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        goldSet1Layout.setVerticalGroup(
                goldSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(goldSet1Layout.createSequentialGroup()
                                .addGroup(goldSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[0][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(goldSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[1][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(goldSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[2][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        //Sets up panel of 15 buttons
        GroupLayout goldSet2Layout = new GroupLayout(goldPanelSet2);
        goldPanelSet2.setLayout(goldSet2Layout);
        goldSet2Layout.setAutoCreateGaps(true);
        goldSet2Layout.setAutoCreateContainerGaps(true);
        goldSet2Layout.setHorizontalGroup(
                goldSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(goldSet2Layout.createSequentialGroup()
                                .addComponent(buttons[0][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[0][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(goldSet2Layout.createSequentialGroup()
                                .addComponent(buttons[1][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[1][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(goldSet2Layout.createSequentialGroup()
                                .addComponent(buttons[2][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[2][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        goldSet2Layout.setVerticalGroup(
                goldSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(goldSet2Layout.createSequentialGroup()
                                .addGroup(goldSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[0][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[0][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(goldSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[1][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[1][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(goldSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[2][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[2][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        //Adds 2 sets of 15 button panels to a single panel
        GroupLayout goldSeatsLayout = new GroupLayout(goldSeats);
        goldSeats.setLayout(goldSeatsLayout);
        goldSeatsLayout.setHorizontalGroup(
                goldSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(goldSeatsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(goldPanelSet1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(goldPanelSet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        
        goldSeatsLayout.setVerticalGroup(
                goldSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, goldSeatsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(goldSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(goldPanelSet1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goldPanelSet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        
        //Sets up panel of 15 buttons
        GroupLayout silverSet1Layout = new GroupLayout(silverPanelSet1);
        silverPanelSet1.setLayout(silverSet1Layout);
        silverSet1Layout.setAutoCreateGaps(true);
        silverSet1Layout.setAutoCreateContainerGaps(true);
        silverSet1Layout.setHorizontalGroup(
                silverSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(silverSet1Layout.createSequentialGroup()
                                .addComponent(buttons[3][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(silverSet1Layout.createSequentialGroup()
                                .addComponent(buttons[4][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(silverSet1Layout.createSequentialGroup()
                                .addComponent(buttons[5][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        silverSet1Layout.setVerticalGroup(
                silverSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(silverSet1Layout.createSequentialGroup()
                                .addGroup(silverSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[3][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(silverSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[4][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(silverSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[5][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        //Sets up panel of 15 buttons
        GroupLayout silverSet2Layout = new GroupLayout(silverPanelSet2);
        silverPanelSet2.setLayout(silverSet2Layout);
        silverSet2Layout.setAutoCreateGaps(true);
        silverSet2Layout.setAutoCreateContainerGaps(true);
        silverSet2Layout.setHorizontalGroup(
                silverSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(silverSet2Layout.createSequentialGroup()
                                .addComponent(buttons[3][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[3][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(silverSet2Layout.createSequentialGroup()
                                .addComponent(buttons[4][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[4][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(silverSet2Layout.createSequentialGroup()
                                .addComponent(buttons[5][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[5][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        silverSet2Layout.setVerticalGroup(
                silverSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(silverSet2Layout.createSequentialGroup()
                                .addGroup(silverSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[3][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[3][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(silverSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[4][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[4][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(silverSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[5][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[5][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        //Adds 2 sets of 15 button panels to a single panel
        GroupLayout silverSeatsLayout = new GroupLayout(silverSeats);
        silverSeats.setLayout(silverSeatsLayout);
        silverSeatsLayout.setHorizontalGroup(
                silverSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(silverSeatsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(silverPanelSet1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(silverPanelSet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        
        silverSeatsLayout.setVerticalGroup(
                silverSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, silverSeatsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(silverSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(silverPanelSet1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(silverPanelSet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        
        //Sets up panel of 15 buttons
        GroupLayout bronzeSet1Layout = new GroupLayout(bronzePanelSet1);
        bronzePanelSet1.setLayout(bronzeSet1Layout);
        bronzeSet1Layout.setAutoCreateGaps(true);
        bronzeSet1Layout.setAutoCreateContainerGaps(true);
        bronzeSet1Layout.setHorizontalGroup(
                bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bronzeSet1Layout.createSequentialGroup()
                                .addComponent(buttons[6][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(bronzeSet1Layout.createSequentialGroup()
                                .addComponent(buttons[7][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(bronzeSet1Layout.createSequentialGroup()
                                .addComponent(buttons[8][0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        bronzeSet1Layout.setVerticalGroup(
                bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bronzeSet1Layout.createSequentialGroup()
                                .addGroup(bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[6][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[7][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[8][0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        //Sets up panel of 15 buttons
        GroupLayout bronzeSet2Layout = new GroupLayout(bronzePanelSet2);
        bronzePanelSet2.setLayout(bronzeSet2Layout);
        bronzeSet2Layout.setAutoCreateGaps(true);
        bronzeSet2Layout.setAutoCreateContainerGaps(true);
        bronzeSet2Layout.setHorizontalGroup(
                bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bronzeSet2Layout.createSequentialGroup()
                                .addComponent(buttons[6][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[6][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(bronzeSet2Layout.createSequentialGroup()
                                .addComponent(buttons[7][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[7][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGroup(bronzeSet2Layout.createSequentialGroup()
                                .addComponent(buttons[8][5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttons[8][9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        bronzeSet2Layout.setVerticalGroup(
                bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bronzeSet2Layout.createSequentialGroup()
                                .addGroup(bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[6][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[6][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[7][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[7][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttons[8][5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttons[8][9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        //Adds 2 sets of 15 button panels to single panel
        GroupLayout bronzeSeatsLayout = new GroupLayout(bronzeSeats);
        bronzeSeats.setLayout(bronzeSeatsLayout);
        bronzeSeatsLayout.setHorizontalGroup(
                bronzeSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bronzeSeatsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bronzePanelSet1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bronzePanelSet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        
        bronzeSeatsLayout.setVerticalGroup(
                bronzeSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, bronzeSeatsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(bronzeSeatsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(bronzePanelSet1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bronzePanelSet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        
        //Sets up panel containing numbers listing seat columns
        GroupLayout columnLayout = new GroupLayout(column);
        column.setLayout(columnLayout);
        columnLayout.setHorizontalGroup(
                columnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(columnLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(seatColumns[9])
                                .addGap(50)
                                .addComponent(seatColumns[8])
                                .addGap(52, 52, 52)
                                .addComponent(seatColumns[7])
                                .addGap(49, 49, 49)
                                .addComponent(seatColumns[6])
                                .addGap(52, 52, 52)
                                .addComponent(seatColumns[5])
                                .addGap(80)
                                .addComponent(seatColumns[4])
                                .addGap(50)
                                .addComponent(seatColumns[3])
                                .addGap(52, 52, 52)
                                .addComponent(seatColumns[2])
                                .addGap(50)
                                .addComponent(seatColumns[1])
                                .addGap(47, 47, 47)
                                .addComponent(seatColumns[0])
                                .addGap(31, 31, 31))
        );
        
        columnLayout.setVerticalGroup(
                columnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, columnLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(columnLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(seatColumns[9])
                                        .addComponent(seatColumns[8])
                                        .addComponent(seatColumns[7])
                                        .addComponent(seatColumns[6])
                                        .addComponent(seatColumns[5])
                                        .addComponent(seatColumns[4])
                                        .addComponent(seatColumns[3])
                                        .addComponent(seatColumns[2])
                                        .addComponent(seatColumns[1])
                                        .addComponent(seatColumns[0]))
                                .addContainerGap())
        );
        
        //Sets up panel containing letters listing seat rows
        GroupLayout rowLayout = new GroupLayout(row);
        row.setLayout(rowLayout);
        rowLayout.setHorizontalGroup(
                rowLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(rowLayout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addGroup(rowLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[0], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[1], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[2], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[3], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[4], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[5], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[6], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[7], GroupLayout.Alignment.TRAILING)
                                        .addComponent(seatRows[8], GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        
        rowLayout.setVerticalGroup(
                rowLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(rowLayout.createSequentialGroup()
                                .addGap(30)
                                .addComponent(seatRows[0])
                                .addGap(26, 26, 26)
                                .addComponent(seatRows[1])
                                .addGap(27, 27, 27)
                                .addComponent(seatRows[2])
                                .addGap(80)
                                .addComponent(seatRows[3])
                                .addGap(27, 27, 27)
                                .addComponent(seatRows[4])
                                .addGap(27, 27, 27)
                                .addComponent(seatRows[5])
                                .addGap(80)
                                .addComponent(seatRows[6])
                                .addGap(27, 27, 27)
                                .addComponent(seatRows[7])
                                .addGap(26, 26, 26)
                                .addComponent(seatRows[8])
                                .addGap(19, 19, 19))
        );
        
        //All panels and labels are added to the main panel
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(100)
                                .addComponent(fireExit1)
                                .addGap(530)
                                .addComponent(fireExit2))
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(405)
                                        .addComponent(stage)))
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(115)
                                        .addComponent(column)))
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(100)
                                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(goldSeats)
                                                .addComponent(silverSeats)
                                                .addComponent(bronzeSeats))))
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(750)
                                        .addComponent(row)
                                        .addGap(100)))
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(390)
                                        .addComponent(mainEntrance)))
        );
        
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(25)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fireExit1)
                                        .addComponent(fireExit2)
                                        .addGap(50))
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(stage)
                                        .addGap(50))
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(column))
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(row)
                                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(mainPanelLayout.createSequentialGroup()
                                                        .addComponent(goldSeats)
                                                        .addGap(18)
                                                        .addComponent(silverSeats)
                                                        .addGap(18)
                                                        .addComponent(bronzeSeats))))
                                .addGap(25)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mainEntrance))
                                .addGap(25))
        );
        
        mainLayout(mainPanel);

// </editor-fold>
    }
    
    /**Populates button array and sets colour of button to gold, silver and bronze
     * every 30 buttons.
     */
    private void createButtons()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new GoldButtonAction());
                buttons[i][j].setBackground(Color.decode("#FFD700"));
            }
        }

        for(int i = 3; i < 6; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new SilverButtonAction());
                buttons[i][j].setBackground(Color.decode("#C0C0C0"));  
            }
        }

        for(int i = 6; i < 9; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new BronzeButtonAction());
                buttons[i][j].setBackground(Color.decode("#D2691E")); 
            }  
        }
    }
    
    //Creates the lines showing the stage and surrounding walls
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.blue);
        g.drawLine(40,100,110,100);
        g.drawLine(180,100,300,100);
        g.drawLine(300,100,300,160);
        g.drawLine(300,160,575,160);
        g.drawLine(575,160,575,100);
        g.drawLine(575,100,690,100);
        g.drawLine(760,100,850,100);
        g.drawLine(40,780,400,780);
        g.drawLine(480,780,850,780);
    }
    
    //Lays out the main panel on to the frame. 
    private void mainLayout(JPanel mainPanel)
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    /** Gold buttons perform actions based on colour. If gold then a customer 
     * will be booked to that seat. If red the admin will be prompted to unbook
     * that seat. There's a 1 in 10 chance to win a backstage pass.
     */
    private class GoldButtonAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {           
            JButton source = (JButton)e.getSource();
            if(source.getBackground() == Color.RED)
            {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you wish to unbook seat?");
                if(choice == 0)
                {
                    ReadBookings currentSeat = new ReadBookings("Bookings.txt");
                    int row;
                    int column;
                    
                    try
                    {
                        currentSeat.openFile();
                    }catch(IOException error)
                    {
                        System.out.println(error.getMessage());
                    }
                    
                    for(int i = 0; i < 3; i++)
                    {
                        for(int j = 0; j < 10; j++)
                        {
                            if(source == buttons[i][j])
                            {
                                row = i;
                                column = j;
                                System.out.println(row);
                                System.out.println(column);
                                
                                currentSeat.unbookSeat(row, column);
                            }
                        }
                    }
                    source.setBackground(Color.decode("#FFD700"));
                    goldCounter--;
                }
            }else
            {
                int randomNumber = (int) (Math.random() * 10 + 1);
                if(randomNumber == 5)
                {
                    JOptionPane.showMessageDialog (null, "Customer entitiled to backstage pass", "Backstage Pass", JOptionPane.INFORMATION_MESSAGE);
                    storeCustomerDetails(true);
                }else
                {
                    storeCustomerDetails();
                }
                goldCounter++;
                source.setBackground(Color.RED);
            }
        }
    }
    
    /**Similar to gold actions performed based on colour. All silver seats
     * entitle the customer a programme.
     */
    private class SilverButtonAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton source = (JButton)e.getSource();
            if(source.getBackground() == Color.RED)
            {
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you wish to unbook seat?");
                if(choice == 0)
                {
                    ReadBookings currentSeat = new ReadBookings("Bookings.txt");
                    int row;
                    int column;
                    
                    try
                    {
                        currentSeat.openFile();
                    }catch(IOException error)
                    {
                        System.out.println(error.getMessage());
                    }
                    
                    for(int i = 3; i < 6; i++)
                    {
                        for(int j = 0; j < 10; j++)
                        {
                            if(source == buttons[i][j])
                            {
                                row = i;
                                column = j;
                                currentSeat.unbookSeat(row, column);
                            }
                        }
                    }
                    source.setBackground(Color.decode("#C0C0C0"));  
                    silverCounter--;
                }
            }else
            {
                storeCustomerDetails("Free Programme");
                JOptionPane.showMessageDialog (null, "Customer is entitled to a free programme", "Free Programme", JOptionPane.INFORMATION_MESSAGE);
                silverCounter++;
                source.setBackground(Color.RED);
            }
        }
    }
    
    //Similar to gold and silver. However can't be unbooked.
    private class BronzeButtonAction implements ActionListener
    {  
        @Override
        public void actionPerformed(ActionEvent e)
        {           
            JButton source = (JButton)e.getSource();
            if(source.getBackground() == Color.RED)
            {
                JOptionPane.showMessageDialog (null, "Bronze seats cannot be unbooked", "Already Booked", JOptionPane.INFORMATION_MESSAGE);   
            }else
            {
                storeCustomerDetails();
                bronzeCounter++;
                source.setBackground(Color.RED);
            }
        }
    }
    
    //Marks the seats that are already booked red
    public final void isBooked(int row, int column)
    {
        buttons[row][column].setBackground(Color.RED);
    }
    
    /** When a new concert is created the pricing and number of seats booked is
     * reset. The files containing the current concert and bookings are emptied. 
     */
    private class newConcertListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            WriteFile newConcert = new WriteFile("ConcertDetails.txt");
            totalPrice = 0;
            goldCounter = 0;
            silverCounter = 0;
            bronzeCounter = 0;
            try {
                newConcert.clearFile();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConcertUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            String concert = JOptionPane.showInputDialog("What is this concert called?");
            String concertDate = JOptionPane.showInputDialog("What is the date of the concert?");
            goldPrice = Double.parseDouble((String)JOptionPane.showInputDialog("Please enter the gold seat price:"));
            silverPrice = Double.parseDouble((String)JOptionPane.showInputDialog("Please enter the silver seat price:"));
            bronzePrice = Double.parseDouble((String)JOptionPane.showInputDialog("Please enter the bronze seat price:"));
            newConcert.printToFile(concert,concertDate,goldPrice,silverPrice,bronzePrice);
            
            resetSeats();
        }
    }
    
    //When a new concert is made all seats are made their default colour
    private void resetSeats()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(buttons[i][j].getBackground() == Color.RED)
                {
                    buttons[i][j].setBackground(Color.decode("#FFD700"));
                }
            }
        }
        
        for(int i = 3; i < 6; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(buttons[i][j].getBackground() == Color.RED)
                {
                    buttons[i][j].setBackground(Color.decode("#C0C0C0"));
                }
            }
        }
        
        for(int i = 6; i < 9; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(buttons[i][j].getBackground() == Color.RED)
                {
                    buttons[i][j].setBackground(Color.decode("#D2691E"));
                }
            }
        }
    }
    
    // Enter a seat to find info about its purchaser
    private class querySeatStatusListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String searchedSeat = JOptionPane.showInputDialog("Please enter a seat to search for");
            ReadBookings seatOwner = new ReadBookings("Bookings.txt");
            try
            {
                seatOwner.openFile();
            }catch(IOException e)
            {
                e.getMessage();
            }
            
            seatOwner.searchForCustomer(searchedSeat);
        }
    }
    
    //Enter a purchasers name to get info about the seat they've booked
    private class querySeatPurchaserListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String searchedName = JOptionPane.showInputDialog("Please Enter a name to search for");
            ReadBookings customerSeat = new ReadBookings("Bookings.txt");
            try
            {
                customerSeat.openFile();
            }catch(IOException e)
            {
                e.getMessage();
            }
            customerSeat.searchForSeat(searchedName);
        }
    }

    /**Displays the current number of seats that are booked, how many are 
     * remaining and the total price achieved so far.
     */
    private class showReportListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            ReadBookings report = new ReadBookings("Bookings.txt");
            try
            {
                report.openFile();
            }catch(IOException e)
            {
                e.getMessage();
            }
            int bookedAmount = report.bookedCount();
            int unbookedAmount = report.unbookedCount();
            JOptionPane.showMessageDialog(null,"There are "+bookedAmount+" seats booked for this concert");
            JOptionPane.showMessageDialog(null,"There are "+unbookedAmount+" seats Available for this concert");
            totalPrice = ((goldPrice*goldCounter)+(silverPrice*silverCounter)+(bronzePrice*bronzeCounter));
            JOptionPane.showMessageDialog(null,"The total value of sales for this concert is £"+totalPrice);
        }
    }
    
    //Stores customer name and seat
    private void storeCustomerDetails()
    {
        String name = JOptionPane.showInputDialog("Please enter your name");
        while(name.length() > 30)
        {
            name = JOptionPane.showInputDialog("Please enter a name with less than 30 characters");
        }
        String seat = JOptionPane.showInputDialog("Please enter your Seat");
        String seatAndName = (seat + " " + name);
        newBooking.printToFile(seatAndName);
    }
    
    //Stores customer name and seat and that they have a backstage pass
    private void storeCustomerDetails(boolean hasBackstagePass)
    {
        String name = JOptionPane.showInputDialog("Please enter your name");
        while(name.length() > 30)
        {
            name = JOptionPane.showInputDialog("Please enter a name with less than 30 characters");
        }
        String seat = JOptionPane.showInputDialog("Please enter your Seat");
        String seatAndName = (seat + " " + name);
        newBooking.printToFile(seatAndName, hasBackstagePass);
    }
    
    //Stores customer name and seat and that they have a programme
    private void storeCustomerDetails(String hasProgramme)
    {
        String name = JOptionPane.showInputDialog("Please enter your name");
        while(name.length() > 30)
        {
            name = JOptionPane.showInputDialog("Please enter a name with less than 30 characters");
        }
        String seat = JOptionPane.showInputDialog("Please enter your Seat");
        String seatAndName = (seat + " " + name);
        newBooking.printToFile(seatAndName, "With Programme");
    }
}
