import javax.swing.*;
import java.awt.*;

public class SignUpHelper
{
    private JFrame mainFrame;
    private JPanel mainPanel;

    public SignUpHelper(JFrame mainFrame, JPanel mainPanel)
    {
        GridLayout gridLayout2 = new GridLayout(6,2);
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;

        //Remove old components
        this.mainPanel.removeAll();

        JLabel fNameLabel = new JLabel("first name: ");
        JTextField fName = new JTextField("");

        JLabel lNameLabel = new JLabel("last name");
        JTextField lName = new JTextField("");

        JLabel addressLabel = new JLabel("address");
        JTextField address = new JTextField("");

        JLabel phoneLabel = new JLabel("phone number");
        JTextField phoneNum = new JTextField("");

        JLabel ageLabel = new JLabel("age");
        JTextField age = new JTextField("");

        JButton signUp = new JButton("Sign Up");
        JLabel error = new JLabel("",SwingConstants.CENTER);

        this.mainPanel.add(fNameLabel);
        this.mainPanel.add(fName);
        this.mainPanel.add(lNameLabel);
        this.mainPanel.add(lName);
        this.mainPanel.add(addressLabel);
        this.mainPanel.add(address);
        this.mainPanel.add(phoneLabel);
        this.mainPanel.add(phoneNum);
        this.mainPanel.add(ageLabel);
        this.mainPanel.add(age);
        this.mainPanel.add(signUp);
        this.mainPanel.add(error);

        this.mainPanel.setLayout(gridLayout2);
        mainFrame.setSize(400,500);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
