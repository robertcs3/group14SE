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
        mainFrame.setLocationRelativeTo(null);//Set location of window to middle of screen
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       //Add function to button
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginHelper loginHelper = new LoginHelper(mainFrame, mainPanel);
            }
        });

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpHelper signUpHelper = new SignUpHelper(mainFrame, mainPanel);
            }
        });
    }
    public static void main(String args[])
    {
        Library library = new Library();
    }
}