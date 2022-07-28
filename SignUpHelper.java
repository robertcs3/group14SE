import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class SignUpHelper implements ActionListener
{
    private JFrame mainFrame;
    private JPanel mainPanel;

    private JTextField fName, lName, password, address, phoneNum, age;
    private ArrayList<Integer> userIDList = new ArrayList<Integer>();
    private ArrayList<String> passwordList = new ArrayList<String>();
    public SignUpHelper(JFrame mainFrame, JPanel mainPanel)
    {
        //Get existing id and password
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
            throw new RuntimeException(ex);
        }


        GridLayout gridLayout2 = new GridLayout(7,2);
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;

        //Remove old components
        this.mainPanel.removeAll();

        JLabel fNameLabel = new JLabel("first name: ");
        fName = new JTextField("");

        JLabel lNameLabel = new JLabel("last name");
        lName = new JTextField("");

        JLabel passwordLabel = new JLabel("Password");
        password = new JTextField("");

        JLabel addressLabel = new JLabel("address");
        address = new JTextField("");

        JLabel phoneLabel = new JLabel("phone number");
        phoneNum = new JTextField("");

        JLabel ageLabel = new JLabel("age");
        age = new JTextField("");

        JButton signUp = new JButton("Sign Up");

        this.mainPanel.add(fNameLabel);
        this.mainPanel.add(fName);
        this.mainPanel.add(lNameLabel);
        this.mainPanel.add(lName);
        this.mainPanel.add(passwordLabel);
        this.mainPanel.add(password);
        this.mainPanel.add(addressLabel);
        this.mainPanel.add(address);
        this.mainPanel.add(phoneLabel);
        this.mainPanel.add(phoneNum);
        this.mainPanel.add(ageLabel);
        this.mainPanel.add(age);
        this.mainPanel.add(signUp);

        this.mainPanel.setLayout(gridLayout2);
        mainFrame.setSize(400,500);
        mainPanel.revalidate();
        mainPanel.repaint();

        signUp.addActionListener(this);
    }

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
                //Check if user is a child
                boolean isChild = false;
                if(Integer.parseInt(age.getText()) <= 12)
                    isChild = true;

                //Write to login.csv
                BufferedWriter fileToWrite = new BufferedWriter(new FileWriter("login.csv", true));
                fileToWrite.write("\n"+id +", "+password.getText());
                fileToWrite.close();

                //Write to user.csv
                fileToWrite = new BufferedWriter(new FileWriter("user.csv", true));
                fileToWrite.write("\n" +id
                        + "," + fName.getText()
                        + "," + lName.getText()
                        + "," + password.getText()
                        + "," + phoneNum.getText()
                        + ", \"" + address.getText()+"\""
                        + "," + isChild
                );
                fileToWrite.close();
                UserMenu user = new UserMenu(mainFrame, mainPanel);//Sign in , Replace with userMenu

            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }






    }
}
