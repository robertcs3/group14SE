import javax.swing.*;
import java.awt.*;

public class UserMenu
{

    public UserMenu(JFrame mainFrame, JPanel mainPanel)
    {
        GridLayout subLayout = new GridLayout(5,3);
        mainPanel.removeAll();
        //Initialize new components
        JLabel welcomeLabel = new JLabel("Welcome Back", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("", Font.BOLD, 30));
        JButton requestRenew = new JButton("Request Renew");
        JButton checkoutItem = new JButton("Checkout Item");
        JButton returnItem = new JButton("Return Item");
        JButton requestItem = new JButton("Request Item");
        JButton payFine = new JButton("Pay Fines");
        JButton LogOut = new JButton("Log Out");
        JLabel finesOwn = new JLabel("Fine: $0", SwingConstants.CENTER);

        //Add new components
        mainPanel.add(new JLabel());//Blank component for padding
        mainPanel.add(welcomeLabel);
        mainPanel.add(new JLabel());//Blank component for padding
        mainPanel.add(requestRenew);
        mainPanel.add(new JLabel());//Blank component for padding
        mainPanel.add(checkoutItem);
        mainPanel.add(returnItem);
        mainPanel.add(new JLabel());//Blank component for padding
        mainPanel.add(requestItem);
        mainPanel.add(payFine);
        mainPanel.add(new JLabel());//Blank component for padding
        mainPanel.add(LogOut);
        mainPanel.add(new JLabel());//Blank component for padding
        mainPanel.add(finesOwn);

        mainPanel.setLayout(subLayout);
        mainFrame.setSize(700,600);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
