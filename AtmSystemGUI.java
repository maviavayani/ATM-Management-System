import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AtmSystemGUI extends JFrame implements ActionListener {
    private static int balance = 1000;
    public JLabel balanceLabel;

    public AtmSystemGUI() {
        setTitle("Mavia ATM System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setBackground(Color.LIGHT_GRAY);  
        JLabel welcomeLabel = new JLabel("Welcome to the Mavia ATM system!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel);

        JButton viewBalanceButton = new JButton("View Balance");
        viewBalanceButton.setActionCommand("View Balance");
        viewBalanceButton.addActionListener(this);
        viewBalanceButton.setBackground(Color.CYAN);  
        panel.add(viewBalanceButton);

        JButton withdrawButton = new JButton("Withdraw Money");
        withdrawButton.setActionCommand("Withdraw Money");
        withdrawButton.addActionListener(this);
        withdrawButton.setBackground(Color.LIGHT_GRAY); 
        panel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit Money");
        depositButton.setActionCommand("Deposit Money");
        depositButton.addActionListener(this);
        depositButton.setBackground(Color.CYAN);  
        panel.add(depositButton);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AtmSystemGUI();
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "View Balance":
                viewBalance();
                break;
            case "Withdraw Money":
                withdrawMoney();
                break;
            case "Deposit Money":
                depositMoney();
                break;
        }
    }

    private void viewBalance() {
        JOptionPane.showMessageDialog(this, "Your current balance is: " + balance);
        if(balance <= 10) {
            JOptionPane.showMessageDialog(this, "Your balance is very low 😥😥😥");
        }
    }

    private void withdrawMoney() {
        String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        if (input == null || input.isEmpty()) {
            return;
        }
        int amount = Integer.parseInt(input);
        if (amount > balance) {
            JOptionPane.showMessageDialog(this, "Insufficient balance!");
            JOptionPane.showMessageDialog(this, "You are Broke!");
            return;
        }
        balance -= amount;
        JOptionPane.showMessageDialog(this, "Please collect your cash.\nNow you have " + balance + " Rupees.\nHave a Great Day Ahead.😃");
    }

    private void depositMoney() {
        String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        if (input == null || input.isEmpty()) {
            return;
        }
        int amount = Integer.parseInt(input);
        balance += amount;
        JOptionPane.showMessageDialog(this, "Your updated balance is: " + balance);
    }
}