import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Library
{
    public Library()
    {
        //Initialize Library System
        librarySystem system = new librarySystem();
        //GUI
        //Initialize layout
        GridLayout gridLayout = new GridLayout(3,1);

        //Initialize components
        JFrame mainFrame = new JFrame("Main");
        JPanel mainPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Library", SwingConstants.CENTER);
        JButton login = new JButton("Log In");
        JButton signUp = new JButton("Sign Up");

        //Set layout
        mainPanel.setLayout(gridLayout);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 52));
        login.setFont(new Font("Times New Roman", Font.BOLD, 42));
        signUp.setFont(new Font("Times New Roman", Font.BOLD, 42));

        //Add components
        mainPanel.add(welcomeLabel);
        mainPanel.add(login);
        mainPanel.add(signUp);
        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
        mainFrame.setSize(700,600);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       //Add function to button
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GridLayout gridLayout1 = new GridLayout(3,2);
                JFrame subFrame = new JFrame("Log in");
                JPanel subPanel = new JPanel();
                JLabel userNameLabel = new JLabel("username: ");
                JTextField userName = new JTextField("");
                JLabel passwordLabel = new JLabel("password");
                JTextField password = new JTextField("");
                JButton login = new JButton("Log in");
                JLabel error = new JLabel("",SwingConstants.CENTER);

                subPanel.add(userNameLabel);
                subPanel.add(userName);
                subPanel.add(passwordLabel);
                subPanel.add(password);
                subPanel.add(login);
                subPanel.add(error);

                subPanel.setLayout(gridLayout1);
                subFrame.add(subPanel);
                subFrame.setVisible(true);
                subFrame.setSize(400,100);
                subFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GridLayout gridLayout2 = new GridLayout(6,2);
                JFrame subFrame = new JFrame("Log in");
                JPanel subPanel = new JPanel();
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

                subPanel.add(fNameLabel);
                subPanel.add(fName);
                subPanel.add(lNameLabel);
                subPanel.add(lName);
                subPanel.add(addressLabel);
                subPanel.add(address);
                subPanel.add(phoneLabel);
                subPanel.add(phoneNum);
                subPanel.add(ageLabel);
                subPanel.add(age);
                subPanel.add(signUp);
                subPanel.add(error);

                subPanel.setLayout(gridLayout2);
                subFrame.add(subPanel);
                subFrame.setVisible(true);
                subFrame.setSize(400,500);
                subFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                signUp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
            }
        });



    }



    public static void main(String args[])
    {
        Library library = new Library();
    }
}