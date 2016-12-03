package concertbooking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private double totalPrice;
    private double goldPrice;
    private double silverPrice;
    private double bronzePrice;
    private int goldCounter = 0;
    private int silverCounter = 0;
    private int bronzeCounter = 0;
    FileAccess fileAccessor = new FileAccess();
    
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
        
        JButton[] buttons = new JButton[90];
        for(int i = 0; i < 30; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new GoldButtonAction());
            buttons[i].setBackground(Color.decode("#FFD700"));
        }
        for(int i = 30; i < 60; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new SilverButtonAction());
            buttons[i].setBackground(Color.decode("#C0C0C0"));
        }
        for(int i = 60; i < 90; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(new BronzeButtonAction());
            buttons[i].setBackground(Color.decode("#D2691E"));
        }
        
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
        
        for(int i = 0; i < 10; i++)
        {
            seatColumns[i] = new JLabel();
            seatColumns[i].setText(Integer.toString(i+1));
        }
        
        newConcert.addActionListener(new newConcertListener());
        showReport.addActionListener(new showReportListener());
        fileMenu.add(newConcert);
        fileMenu.add(showReport);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        GroupLayout goldSet1Layout = new GroupLayout(goldPanelSet1);
        goldPanelSet1.setLayout(goldSet1Layout);
        goldSet1Layout.setAutoCreateGaps(true);
        goldSet1Layout.setAutoCreateContainerGaps(true);
        goldSet1Layout.setHorizontalGroup(
            goldSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(goldSet1Layout.createSequentialGroup()
                .addComponent(buttons[0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[1], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(goldSet1Layout.createSequentialGroup()
                .addComponent(buttons[5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(goldSet1Layout.createSequentialGroup()
                .addComponent(buttons[10], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[11], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[12], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[13], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[14], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        goldSet1Layout.setVerticalGroup(
            goldSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(goldSet1Layout.createSequentialGroup()
                .addGroup(goldSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[0], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[1], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[2], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[3], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[4], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(goldSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[5], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[6], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[7], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[8], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[9], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(goldSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[10], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[11], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[12], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[13], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[14], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        GroupLayout goldSet2Layout = new GroupLayout(goldPanelSet2);
        goldPanelSet2.setLayout(goldSet2Layout);
        goldSet2Layout.setAutoCreateGaps(true);
        goldSet2Layout.setAutoCreateContainerGaps(true);
        goldSet2Layout.setHorizontalGroup(
            goldSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(goldSet2Layout.createSequentialGroup()
                .addComponent(buttons[15], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[16], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[17], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[18], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[19], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(goldSet2Layout.createSequentialGroup()
                .addComponent(buttons[20], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[21], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[22], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[23], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[24], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(goldSet2Layout.createSequentialGroup()
                .addComponent(buttons[25], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[26], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[27], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[28], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[29], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        goldSet2Layout.setVerticalGroup(
            goldSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(goldSet2Layout.createSequentialGroup()
                .addGroup(goldSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[15], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[16], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[17], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[18], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[19], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(goldSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[20], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[21], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[22], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[23], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[24], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(goldSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[25], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[26], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[27], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[28], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[29], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
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
        
        GroupLayout silverSet1Layout = new GroupLayout(silverPanelSet1);
        silverPanelSet1.setLayout(silverSet1Layout);
        silverSet1Layout.setAutoCreateGaps(true);
        silverSet1Layout.setAutoCreateContainerGaps(true);
        silverSet1Layout.setHorizontalGroup(
            silverSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(silverSet1Layout.createSequentialGroup()
                .addComponent(buttons[30], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[31], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[32], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[33], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[34], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(silverSet1Layout.createSequentialGroup()
                .addComponent(buttons[35], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[36], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[37], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[38], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[39], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(silverSet1Layout.createSequentialGroup()
                .addComponent(buttons[40], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[41], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[42], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[43], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[44], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        silverSet1Layout.setVerticalGroup(
            silverSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(silverSet1Layout.createSequentialGroup()
                .addGroup(silverSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[30], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[31], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[32], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[33], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[34], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(silverSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[35], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[36], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[37], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[38], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[39], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(silverSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[40], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[41], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[42], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[43], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[44], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        GroupLayout silverSet2Layout = new GroupLayout(silverPanelSet2);
        silverPanelSet2.setLayout(silverSet2Layout);
        silverSet2Layout.setAutoCreateGaps(true);
        silverSet2Layout.setAutoCreateContainerGaps(true);
        silverSet2Layout.setHorizontalGroup(
            silverSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(silverSet2Layout.createSequentialGroup()
                .addComponent(buttons[45], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[46], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[47], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[48], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[49], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(silverSet2Layout.createSequentialGroup()
                .addComponent(buttons[50], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[51], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[52], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[53], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[54], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(silverSet2Layout.createSequentialGroup()
                .addComponent(buttons[55], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[56], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[57], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[58], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[59], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        silverSet2Layout.setVerticalGroup(
            silverSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(silverSet2Layout.createSequentialGroup()
                .addGroup(silverSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[45], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[46], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[47], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[48], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[49], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(silverSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[50], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[51], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[52], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[53], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[54], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(silverSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[55], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[56], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[57], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[58], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[59], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
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
        
        GroupLayout bronzeSet1Layout = new GroupLayout(bronzePanelSet1);
        bronzePanelSet1.setLayout(bronzeSet1Layout);
        bronzeSet1Layout.setAutoCreateGaps(true);
        bronzeSet1Layout.setAutoCreateContainerGaps(true);
        bronzeSet1Layout.setHorizontalGroup(
            bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bronzeSet1Layout.createSequentialGroup()
                .addComponent(buttons[60], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[61], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[62], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[63], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[64], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(bronzeSet1Layout.createSequentialGroup()
                .addComponent(buttons[65], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[66], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[67], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[68], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[69], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(bronzeSet1Layout.createSequentialGroup()
                .addComponent(buttons[70], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[71], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[72], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[73], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[74], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        bronzeSet1Layout.setVerticalGroup(
            bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bronzeSet1Layout.createSequentialGroup()
                .addGroup(bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[60], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[61], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[62], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[63], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[64], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[65], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[66], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[67], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[68], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[69], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bronzeSet1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[70], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[71], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[72], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[73], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[74], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
        GroupLayout bronzeSet2Layout = new GroupLayout(bronzePanelSet2);
        bronzePanelSet2.setLayout(bronzeSet2Layout);
        bronzeSet2Layout.setAutoCreateGaps(true);
        bronzeSet2Layout.setAutoCreateContainerGaps(true);
        bronzeSet2Layout.setHorizontalGroup(
            bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bronzeSet2Layout.createSequentialGroup()
                .addComponent(buttons[75], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[76], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[77], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[78], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[79], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(bronzeSet2Layout.createSequentialGroup()
                .addComponent(buttons[80], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[81], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[82], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[83], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[84], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
            .addGroup(bronzeSet2Layout.createSequentialGroup()
                .addComponent(buttons[85], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[86], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[87], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[88], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttons[89], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        );
        
        bronzeSet2Layout.setVerticalGroup(
            bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bronzeSet2Layout.createSequentialGroup()
                .addGroup(bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[75], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[76], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[77], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[78], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[79], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[80], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[81], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[82], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[83], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[84], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bronzeSet2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[85], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[86], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[87], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[88], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttons[89], GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        );
        
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
        
        javax.swing.GroupLayout columnLayout = new javax.swing.GroupLayout(column);
        column.setLayout(columnLayout);
        columnLayout.setHorizontalGroup(
            columnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
            columnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, columnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(columnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        
        javax.swing.GroupLayout rowLayout = new javax.swing.GroupLayout(row);
        row.setLayout(rowLayout);
        rowLayout.setHorizontalGroup(
            rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(rowLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[0], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[1], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[2], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[3], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[4], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[5], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[6], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[7], javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatRows[8], javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        
        rowLayout.setVerticalGroup(
            rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addGap(27 ,27 ,27)
                .addComponent(seatRows[7])
                .addGap(26, 26, 26)
                .addComponent(seatRows[8])
                .addGap(19, 19, 19))
        );
        
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
    }
    
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
    
    private void mainLayout(JPanel mainPanel)
    {
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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
    
    private class GoldButtonAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {           
            JButton source = (JButton)e.getSource();
            if(source.getBackground() == Color.RED)
            {
                String unbookSeat = JOptionPane.showInputDialog("Do you want to unbook this seat?");
                if(unbookSeat == "yes")
                {
                    source.setBackground(Color.decode("#FFD700"));   
                }
            }else
            {
                int randomNumber = (int) (Math.random() * 10 + 1);
                if(randomNumber == 5)
                {
                    JOptionPane.showMessageDialog (null, "You've got a backstage pass", "Backstage Pass", JOptionPane.INFORMATION_MESSAGE);
                }
                storeCustomerDetails();
                goldCounter++;
                source.setBackground(Color.RED);
            }
        }
    }
    
    private class SilverButtonAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {          
            JButton source = (JButton)e.getSource();
            if(source.getBackground() == Color.RED)
            {
                source.setBackground(Color.decode("#C0C0C0"));
            }else
            {
                storeCustomerDetails();
                JOptionPane.showMessageDialog (null, "You are Entitled to a free programme", "Free Programme", JOptionPane.INFORMATION_MESSAGE);
                silverCounter++;
                source.setBackground(Color.RED);
            }
        }
    }
    
    private class BronzeButtonAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {           
            JButton source = (JButton)e.getSource();
            if(source.getBackground() == Color.RED)
            {
                JOptionPane.showMessageDialog (null, "Bronze seats cannot be unbooked", "Already Booked", JOptionPane.INFORMATION_MESSAGE);
                //source.setBackground(Color.decode("#D2691E"));
            }else
            {
                storeCustomerDetails();
                bronzeCounter++;
                source.setBackground(Color.RED);
            }
        }
    }
    
    private class newConcertListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //FileAccess fileAccessor = new FileAccess();
            
            String concert = JOptionPane.showInputDialog("What is this concert called?");
            String concertDate = JOptionPane.showInputDialog("What is the date of the concert?");
            goldPrice = Double.parseDouble((String)JOptionPane.showInputDialog("Please enter the gold seat price:"));
            silverPrice = Double.parseDouble((String)JOptionPane.showInputDialog("Please enter the silver seat price:"));
            bronzePrice = Double.parseDouble((String)JOptionPane.showInputDialog("Please enter the bronze seat price:"));
            fileAccessor.printToConcertDetails(concert,concertDate,goldPrice,silverPrice,bronzePrice);
        }
    }

    private class showReportListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            int bookedAmount = fileAccessor.bookedCount();
            int unbookedAmount = fileAccessor.unbookedCount();
            JOptionPane.showMessageDialog(null,"There are "+bookedAmount+" seats booked for this concert");
            JOptionPane.showMessageDialog(null,"There are "+unbookedAmount+" seats Available for this concert");
            totalPrice = ((goldPrice*goldCounter)+(silverPrice*silverCounter)+(bronzePrice*bronzeCounter));
            JOptionPane.showMessageDialog(null,"The total value of sales for this concert is £"+totalPrice);
        }
        
    }
    
    private void storeCustomerDetails()
    {
        //FileAccess fileAccessor = new FileAccess();
        
        String name = JOptionPane.showInputDialog("Please enter your name");
        while(name.length() > 30)
        {
            name = JOptionPane.showInputDialog("Please enter a name with less than 30 characters");
        }
        String seat = JOptionPane.showInputDialog("Please enter your Seat");
        fileAccessor.printToBookings(name,seat);
    }
}
