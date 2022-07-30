import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Library
{
    private ArrayList<Integer> userIDList = new ArrayList<Integer>();
    private ArrayList<String> passwordList = new ArrayList<String>();
    String fines = "";
    //currentUser
    int currentUserID = 0;
    //Initialize Library System
    librarySystem system = new librarySystem();
    public Library()
    {
        //Parse data for log in and sign up
        inforParse();

        //GUI START--------------------------------------------------------------------------------------

        //Initialize layout
        GridLayout gridLayout = new GridLayout(3,1);
        CardLayout cardLayout = new CardLayout();//For multiple menus

        //Initialize components
        JFrame mainFrame = new JFrame("Main Menu");
        JPanel mainPanel = new JPanel();
        JPanel mainMenuPanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        mainMenuPanel.setLayout(gridLayout);

        JLabel welcomeLabel = new JLabel("Welcome to the Library", SwingConstants.CENTER);
        JButton login = new JButton("Log In");
        JButton signUp = new JButton("Sign Up");

        //Set layout
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 52));
        login.setFont(new Font("Times New Roman", Font.BOLD, 42));
        signUp.setFont(new Font("Times New Roman", Font.BOLD, 42));

        //Add components
        mainMenuPanel.add(welcomeLabel);
        mainMenuPanel.add(login);
        mainMenuPanel.add(signUp);

        //Add panels into cardlayout
        mainPanel.add(mainMenuPanel, "Main");//Add main menu to card layout with name "Main"
        mainFrame.add(mainPanel);

        //Set mainFrame visible and normal operations
        mainFrame.setVisible(true);
        mainFrame.setSize(700,600);
        mainFrame.setLocationRelativeTo(null);//Set location of window to middle of screen
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set GUI to show main menu GUI first
        cardLayout.show(mainPanel, "Main");

        //GUI END--------------------------------------------------------------------------------------



        //Set buttons function
        login.addActionListener(new ActionListener() { //LOG IN
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(loginMenuGUI(mainFrame, mainPanel, cardLayout), "Log In");
                mainFrame.setSize(600,200);
                mainFrame.setTitle("Log In");
                cardLayout.show(mainPanel,"Log In");
            }
        });

        signUp.addActionListener(new ActionListener() { //SIGN UP
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(signUpMenuGUI(mainFrame, mainPanel, cardLayout), "Sign Up");
                mainFrame.setTitle("Sign Up");
                mainFrame.setSize(400,500);
                cardLayout.show(mainPanel, "Sign Up");
            }
        });


    }

    private JPanel loginMenuGUI(JFrame mainFrame, JPanel mainPanel, CardLayout cardLayout)
    {
        //GUI START--------------------------------------------------------------------------------------

        GridLayout loginLayout = new GridLayout(3,2);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(loginLayout);// Set layout for panel

        JLabel userIDLabel = new JLabel("User ID: ", SwingConstants.CENTER);
        JTextField userID = new JTextField("");
        JLabel passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        JTextField password = new JTextField("");
        JButton login = new JButton("Log In:");
        JButton backToMain = new JButton("Back to Main Menu");

        loginPanel.add(userIDLabel);
        loginPanel.add(userID);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);
        loginPanel.add(login);
        loginPanel.add(backToMain);


        //GUI END--------------------------------------------------------------------------------------

        //Set function for buttons
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(isNumber(userID.getText())) {
                        int id = Integer.parseInt(userID.getText());
                        //validate id
                        if(userIDList.contains(id))
                        {
                            //validate password
                            String pass = password.getText();
                            if(passwordList.contains(pass))//Everything pass validation
                            {
                                //LOG IN SUCCESSFUL++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                                //Set current user
                                currentUserID = Integer.parseInt(userID.getText());
                                system.setCurrentUser(currentUserID);
                                fines = ""+system.outStandingFine(currentUserID);

                                //Clear text fields
                                userID.setText("");
                                password.setText("");

                                //Set main frame size and set menu to User Menu
                                mainPanel.add(userMenuGUI(mainFrame, mainPanel, cardLayout), "User");
                                mainFrame.setTitle("User Menu");
                                mainFrame.setSize(700,600);
                                cardLayout.show(mainPanel, "User");
                                //LOG IN SUCCESSFUL++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            }
                            else//wrong password
                            {
                                JOptionPane.showMessageDialog(mainFrame, "Invalid Password\nPlease try again");
                            }
                        }
                        else//ID does not exist
                        {
                            JOptionPane.showMessageDialog(mainFrame, "ID does not exist\nPlease try again");
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(mainFrame, "No characters should be in user ID\n");
                    }

                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        });
        backToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setTitle("Main Menu");
                mainFrame.setSize(700,600);
                cardLayout.show(mainPanel, "Main");
            }
        });

        return loginPanel;
    }

    private JPanel signUpMenuGUI(JFrame mainFrame, JPanel mainPanel, CardLayout cardLayout)
    {
        //GUI START--------------------------------------------------------------------------------------

        GridLayout signUpLayout = new GridLayout(7,2);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(signUpLayout);//Set layout for panel

        JLabel fNameLabel = new JLabel("First Name: ", SwingConstants.CENTER);
        JTextField fName = new JTextField("");

        JLabel lNameLabel = new JLabel("Last Name:", SwingConstants.CENTER);
        JTextField lName = new JTextField("");

        JLabel passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        JTextField password = new JTextField("");

        JLabel addressLabel = new JLabel("Address:", SwingConstants.CENTER);
        JTextField address = new JTextField("");

        JLabel phoneLabel = new JLabel("Phone Number:", SwingConstants.CENTER);
        JTextField phoneNum = new JTextField("");

        JLabel ageLabel = new JLabel("Age:", SwingConstants.CENTER);
        JTextField age = new JTextField("");

        JButton signUp = new JButton("Sign Up");
        JButton backToMain = new JButton("Back to Main Menu");

        signUpPanel.add(fNameLabel);
        signUpPanel.add(fName);
        signUpPanel.add(lNameLabel);
        signUpPanel.add(lName);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(password);
        signUpPanel.add(addressLabel);
        signUpPanel.add(address);
        signUpPanel.add(phoneLabel);
        signUpPanel.add(phoneNum);
        signUpPanel.add(ageLabel);
        signUpPanel.add(age);
        signUpPanel.add(signUp);
        signUpPanel.add(backToMain);

        //GUI END--------------------------------------------------------------------------------------

        //Set function for buttons
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Generate ID
                boolean sameId = true;
                int id = (int)(Math.random()*10000000);
                //Check if id already exist
                while(sameId)
                {
                    if(userIDList.contains(id))
                        id = (int)(Math.random()*10000000);
                    else
                        sameId = false;
                }

                //Check if password exist
                if(passwordList.contains(password.getText()))
                    JOptionPane.showMessageDialog(mainPanel, "Password already exist");
                else // Generate a new user and add into login.csv and user.csv files
                {
                    try
                    {
                        //Get values to save
                        String firstName = fName.getText();
                        String lastName = lName.getText();
                        String passWd = password.getText();
                        String phoneNumber = phoneNum.getText();
                        String addressString = address.getText();
                        int userAge = Integer.parseInt(age.getText());

                        //Write to login.csv
                        BufferedWriter fileToWrite = new BufferedWriter(new FileWriter("login.csv", true));
                        fileToWrite.write("\n"+id +", "+password.getText());
                        fileToWrite.close();

                        //Write to login.csv
                        system.signUp(id, firstName, lastName, passWd, addressString, phoneNumber, userAge);

                        //set current user
                        currentUserID = id;
                        system.setCurrentUser(currentUserID);

                        //LOG IN SUCCESSFUL++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                        //Clear text fields
                        fName.setText("");
                        lName.setText("");
                        address.setText("");
                        phoneNum.setText("");
                        age.setText("");

                        //Set size and swap to User Menu
                        mainPanel.add(userMenuGUI(mainFrame, mainPanel, cardLayout), "User");
                        mainFrame.setTitle("User Menu");
                        mainFrame.setSize(700,600);
                        cardLayout.show(mainPanel, "User");

                        //LOG IN SUCCESSFUL++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                }
            }
        });
        backToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setTitle("Main Menu");
                mainFrame.setSize(700,600);
                cardLayout.show(mainPanel, "Main");
            }
        });

        return signUpPanel;
    }

    private JPanel userMenuGUI(JFrame mainFrame, JPanel mainPanel, CardLayout cardLayout)
    {
        //GUI START--------------------------------------------------------------------------------------

        GridLayout userLayout = new GridLayout(6,3);
        //Initialize new components
        JPanel userPanel = new JPanel();
        userPanel.setLayout(userLayout);//Set layout for panel

        //Functions
        JLabel welcomeLabel = new JLabel("Welcome Back" + currentUserID, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("", Font.BOLD, 25));
        JButton requestRenew = new JButton("Request Renew");
        JButton checkoutItem = new JButton("Checkout Item");
        JButton returnItem = new JButton("Return Item");
        JButton requestItem = new JButton("Request Item");
        JButton payFine = new JButton("Pay Fines");
        JButton getInfo = new JButton("User Info");
        JButton LogOut = new JButton("Log Out");
        JLabel finesOwn = new JLabel("Outstanding Fine: $"+fines, SwingConstants.CENTER);

        //Add new components
        userPanel.add(new JLabel());//Blank component for padding
        userPanel.add(welcomeLabel);
        userPanel.add(new JLabel());//Blank component for padding
        userPanel.add(requestRenew);
        userPanel.add(new JLabel());//Blank component for padding
        userPanel.add(checkoutItem);
        userPanel.add(returnItem);
        userPanel.add(new JLabel());//Blank component for padding
        userPanel.add(requestItem);
        userPanel.add(payFine);
        userPanel.add(new JLabel());//Blank component for padding
        userPanel.add(getInfo);
        userPanel.add(new JLabel());
        userPanel.add(LogOut);
        userPanel.add(new JLabel());
        userPanel.add(new JLabel());//Blank component for padding
        userPanel.add(finesOwn);

        //GUI END--------------------------------------------------------------------------------------

        //Set function for buttons
        //Return Item -_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-
        returnItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //List of checkout items
                ArrayList<CheckOutAble> itemList = system.getCheckoutItems(currentUserID);
                HashMap<Integer, CheckOutAble> itemLookupMap = new HashMap<Integer,CheckOutAble>();

                for(CheckOutAble item: itemList)
                {
                    itemLookupMap.put(item.getID(), item);
                }

                JFrame returnItemFrame = new JFrame("Return Item Frame");
                JPanel returnItemPanel = new JPanel();
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

                DefaultListModel listModel = new DefaultListModel();
                JList list = new JList(listModel);
                JScrollPane listScrollPane = new JScrollPane(list);

                //Add checkout items into the list
                for(CheckOutAble item: itemList)
                {
                    String itemString = item.getID() + " " +item.getName();
                    listModel.addElement(itemString);
                }
                //Buttons
                JButton getInfoButton = new JButton("Get Info");
                JButton returnItemButton = new JButton("Return Item");

                buttonPanel.add(getInfoButton);
                buttonPanel.add(returnItemButton);
                buttonPanel.add(Box.createHorizontalStrut(5));
                buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

                //Add list into scroll pane
                list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                list.setSelectedIndex(0);
                list.setVisibleRowCount(5);

                //Add scroll pane to checkoutItemPanel
                returnItemPanel.add(listScrollPane, BorderLayout.CENTER);
                returnItemPanel.add(buttonPanel, BorderLayout.PAGE_END);

                returnItemFrame.add(returnItemPanel);
                returnItemFrame.pack();
                returnItemFrame.setVisible(true);
                returnItemFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                getInfoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        //Get item information
                        String itemID = list.getSelectedValue().toString();
                        itemID = itemID.substring(0,5);
                        CheckOutAble item = itemLookupMap.get(Integer.parseInt(itemID));
                        boolean bestSeller = false;
                        if(itemID.charAt(4) != '0')
                        {
                            bestSeller = true;
                        }
                        //Get due date
                        Date currentDate = new Date();
                        Date dueDate = new Date(item.getDateCheckout().getTime() + TimeUnit.DAYS.toMillis(item.getDurationLimit()));//Due date

                        //GUI--------------------------------------------------------------------

                        //Components
                        JFrame tempFrame = new JFrame(item.getName() +" Information");
                        JPanel tempPanel = new JPanel();
                        tempPanel.setLayout(new GridLayout(5,1));
                        Font font = new Font("Arial", Font.BOLD, 25);

                        JLabel idLabel, nameLabel, bestSellerLabel, checkoutLabel, dueDateLabel;
                        idLabel = new JLabel("ID:        " + item.getID());
                        idLabel.setFont(font);
                        nameLabel = new JLabel("Name:        " + item.getName());
                        nameLabel.setFont(font);
                        bestSellerLabel = new JLabel("Best Seller:        " + bestSeller);
                        bestSellerLabel.setFont(font);
                        checkoutLabel = new JLabel("Date Checkout:        " + item.getDateCheckout());
                        checkoutLabel.setFont(font);
                        dueDateLabel = new JLabel("Due Date:        " + dueDate);
                        dueDateLabel.setFont(font);

                        //Add to frame and panel
                        tempPanel.add(idLabel);
                        tempPanel.add(nameLabel);
                        tempPanel.add(bestSellerLabel);
                        tempPanel.add(checkoutLabel);
                        tempPanel.add(dueDateLabel);

                        tempFrame.add(tempPanel);
                        tempFrame.setSize(600,400);

                        tempFrame.setVisible(true);
                        tempFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        //GUI--------------------------------------------------------------------
                    }
                });

                //Return Item -_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-

                returnItemButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get item ID
                        String itemID = list.getSelectedValue().toString();
                        itemID = itemID.substring(0,5);
                        listModel.remove(list.getSelectedIndex());
                        list.repaint();
                        list.revalidate();

                        //Return item
                        system.returnItem(Integer.parseInt(itemID), currentUserID);
                    }
                });
            }
        });

        //Checkout Item================================================================================

        checkoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //GUI START--------------------------------------------------------------------------------------

                ArrayList <CheckOutAble> itemList = system.getItemList();

                JFrame checkoutFrame = new JFrame("Checkout Item");
                JPanel checkoutPanel = new JPanel();
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

                DefaultListModel listModel = new DefaultListModel();
                JList list = new JList(listModel);
                list.setPreferredSize(new Dimension(300,300));
                JScrollPane listScrollPane = new JScrollPane(list);

                //Add checkout items into the list
                for(CheckOutAble item: itemList)
                {
                    String itemString = item.getID() + " " +item.getName();
                    listModel.addElement(itemString);
                }
                //Buttons
                JButton getInfoButton = new JButton("Get Info");
                JButton returnItemButton = new JButton("Checkout Item");

                buttonPanel.add(getInfoButton);
                buttonPanel.add(returnItemButton);
                buttonPanel.add(Box.createHorizontalStrut(5));
                buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

                //Add list into scroll pane
                list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                list.setSelectedIndex(0);
                list.setVisibleRowCount(5);

                //Add scroll pane to checkoutItemPanel
                checkoutPanel.add(listScrollPane, BorderLayout.CENTER);
                checkoutPanel.add(buttonPanel, BorderLayout.PAGE_END);

                checkoutFrame.add(checkoutPanel);
                checkoutFrame.pack();
                checkoutFrame.setVisible(true);
                checkoutFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                //GUI END--------------------------------------------------------------------------------------

                checkoutItem.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String itemID = list.getSelectedValue().toString();
                        itemID = itemID.substring(0,5);
                        system.checkOutItem(currentUserID, Integer.parseInt(itemID));
                    }
                });

                getInfoButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        //Get item information
                        String itemID = list.getSelectedValue().toString();
                        itemID = itemID.substring(0,5);
                        CheckOutAble item = null;
                        for(CheckOutAble checkoutItem: system.getItemList())
                        {
                            if(checkoutItem.getID() == Integer.parseInt(itemID))
                            {
                                item = checkoutItem;
                                break;
                            }
                        }

                        boolean bestSeller = false;
                        if(itemID.charAt(4) != '0')
                        {
                            bestSeller = true;
                        }

                        //GUI--------------------------------------------------------------------

                        //Components
                        JFrame tempFrame = new JFrame(item.getName() +" Information");
                        JPanel tempPanel = new JPanel();
                        tempPanel.setLayout(new GridLayout(5,1));
                        Font font = new Font("Arial", Font.BOLD, 25);

                        JLabel idLabel, nameLabel, bestSellerLabel, valueLabel, copiesLabel;
                        idLabel = new JLabel("ID:        " + item.getID());
                        idLabel.setFont(font);
                        nameLabel = new JLabel("Name:        " + item.getName());
                        nameLabel.setFont(font);
                        bestSellerLabel = new JLabel("Best Seller:        " + bestSeller);
                        bestSellerLabel.setFont(font);
                        copiesLabel = new JLabel("Copies:        " + item.getCopies());
                        copiesLabel.setFont(font);
                        valueLabel = new JLabel("Value:        $" + item.getValue());
                        valueLabel.setFont(font);

                        //Add to frame and panel
                        tempPanel.add(idLabel);
                        tempPanel.add(nameLabel);
                        tempPanel.add(bestSellerLabel);
                        tempPanel.add(valueLabel);
                        tempPanel.add(copiesLabel);

                        tempFrame.add(tempPanel);
                        tempFrame.setSize(600,400);

                        tempFrame.setVisible(true);
                        tempFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    }
                });
            }
        });

        //Checkout Item================================================================================


        getInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GridLayout infoLayout =  new GridLayout(4,2);

                JFrame subFrame = new JFrame(system.getCurrentUser().getLastName() +" Info");
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(infoLayout);

                //Components
                JLabel firstName, lastName, phoneNumberLabel, isChildLabel, idLabel;
                idLabel = new JLabel("ID Number: "+ system.getCurrentUser().getID()+"");
                firstName = new JLabel( "First Name: " + system.getCurrentUser().getFirstName());
                lastName = new JLabel("Last Name: " + system.getCurrentUser().getLastName());
                JTextArea addressLabel = new JTextArea();
                phoneNumberLabel = new JLabel("Phone Number: " + system.getCurrentUser().getPhoneNumber());
                isChildLabel = new JLabel("Child: " + system.getCurrentUser().isChild()+"");

                //Configure jtextarea
                addressLabel.setWrapStyleWord(true);
                addressLabel.setLineWrap(true);
                addressLabel.setOpaque(false);
                addressLabel.setEditable(false);
                addressLabel.setFocusable(false);
                addressLabel.setText("Address: " +system.getCurrentUser().getAddress().substring(1,system.getCurrentUser().getAddress().length()-1));
                addressLabel.setFont(new Font("", Font.BOLD, 12));

                infoPanel.add(idLabel);
                infoPanel.add(phoneNumberLabel);
                infoPanel.add(firstName);
                infoPanel.add(lastName);
                infoPanel.add(addressLabel);
                infoPanel.add(isChildLabel);

                subFrame.add(infoPanel);
                subFrame.setVisible(true);
                subFrame.setSize(300,400);
                subFrame.setLocationRelativeTo(null);//Set location of window to middle of screen
                subFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            }
        });

        LogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setTitle("Main Menu");
                mainFrame.setSize(700,600);
                cardLayout.show(mainPanel, "Main");
            }
        });

        return userPanel;
    }

    //Add userID and password for log in and sign up
    private void inforParse()
    {
        try
        {
            String line = "";
            BufferedReader fileReader = new BufferedReader(new FileReader("login.csv"));
            while((line = fileReader.readLine()) != null)
            {
                String[] user = line.split(",");
                userIDList.add(Integer.parseInt(user[0]));
                passwordList.add(user[1]);
            }
            fileReader.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    private boolean isNumber(String value)
    {
        return value.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String args[])
    {
        Library library = new Library();
    }
}