import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LoginHelper implements ActionListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    private JLabel userIDLabel, passwordLabel;
    private JButton login;
    private JTextField userID, password;
    private ArrayList<Integer> userIDList = new ArrayList<Integer>();
    private ArrayList<String> passwordList = new ArrayList<String>();
    public LoginHelper(JFrame mainFrame, JPanel mainPanel)
    {
        this.mainPanel = mainPanel;
        this.mainFrame = mainFrame;

        //Remove all old components
        mainPanel.removeAll();

        //Read in user login information from csv file
        //Store in 2 arraylist: userIDList and passwordList
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        GridLayout gridLayout = new GridLayout(3,2);
        mainFrame.setTitle("Log In");
        userIDLabel = new JLabel("userID: ");
        userID = new JTextField("");
        passwordLabel = new JLabel("password");
        password = new JTextField("");
        login = new JButton("Log in");


        mainPanel.add(userIDLabel);
        mainPanel.add(userID);
        mainPanel.add(passwordLabel);
        mainPanel.add(password);
        mainPanel.add(login);

        mainPanel.setLayout(gridLayout);
        mainFrame.setSize(600,200);
        mainPanel.revalidate();
        mainPanel.repaint();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String errorString = "";
            if(isNumber(userID.getText())) {
                int id = Integer.parseInt(userID.getText());
                //validate id
                if(checkID(id))
                {
                    //validate password
                    String pass = password.getText();
                    if(checkPassword(pass))
                    {
                        UserMenu user = new UserMenu(mainFrame, mainPanel);//Replace menu with user menu
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(mainFrame, "Invalid Password\nPlease try again");
                    }
                }
                else
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

    private boolean isNumber(String value)
    {
        return value.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean checkID(int userID)
    {
        if(userIDList.contains(userID))
            return true;
        else
            return false;
    }

    private boolean checkPassword(String password)
    {
        if(passwordList.contains(password))
            return true;
        else
            return false;
    }
}
