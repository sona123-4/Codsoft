import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMInterface_Task2 extends JFrame implements ActionListener {
    private ATM atm;
    private JTextField amountField;
    private JTextArea outputField;
    private JButton[] numpadButtons;
    private JButton depositButton, withdrawButton, checkBalanceButton, exitButton, deleteButton, backspaceButton;

    Font f = new Font("Chalkboard", Font.BOLD, 15);
    Color c = new Color(0x4567b7);
    Color blue = new Color(0x6495ED);

    public ATMInterface_Task2(Bankaccount account) {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mini-bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 250);
        add(image);


        atm = new ATM(account);
        setLayout(null);
        setTitle("ATM");
        setBackground(c); // Set background color of JFrame

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Create numpad
        JPanel numpadPanel = new JPanel(new GridLayout(4, 3));
        numpadPanel.setBounds(600, 50, 230, 180);
        numpadPanel.setBackground(blue); // Set background color of numpad panel
        add(numpadPanel);

        numpadButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numpadButtons[i] = new JButton(String.valueOf(i == 11 ? "0" : i));
            numpadButtons[i].setFont(f);
            numpadButtons[i].addActionListener(this);
            numpadPanel.add(numpadButtons[i]);
        }

        // Create delete button
        deleteButton = new JButton("Delete");
        deleteButton.setFont(f);
        deleteButton.addActionListener(this);
        deleteButton.setBounds(900, 50, 130, 40);
        deleteButton.setBackground(blue); // Set background color of delete button
        add(deleteButton);

        backspaceButton = new JButton("X");
        backspaceButton.setFont(f);
        backspaceButton.addActionListener(this);
        backspaceButton.setBounds(900, 100, 130, 40);
        backspaceButton.setBackground(blue); // Set background color of backspace button
        add(backspaceButton);

        // Create amount field
        amountField = new JTextField();
        amountField.setFont(f);
        amountField.setBounds(600, 270, 230, 50);
        amountField.setBackground(Color.WHITE); // Set background color of amount field
        add(amountField);

        // Create output field
        outputField = new JTextArea(10, 20);
        outputField.setFont(f);
        outputField.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputField);
        outputScrollPane.setBounds(400, 350, 600, 200);
        add(outputScrollPane); // Add the scroll pane to the frame
        outputField.append("Balance: $1000\n");
        outputField.setBackground(Color.WHITE); // Set background color of output field

        // Create option buttons
        depositButton = new JButton("Deposit");
        depositButton.setFont(f);
        depositButton.addActionListener(this);
        depositButton.setBounds(800, 630, 150, 50);
        depositButton.setBackground(blue); // Set background color of deposit button
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(f);
        withdrawButton.addActionListener(this);
        withdrawButton.setBounds(800, 700, 150, 50);
        withdrawButton.setBackground(blue); // Set background color of withdraw button
        add(withdrawButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setFont(f);
        checkBalanceButton.addActionListener(this);
        checkBalanceButton.setBounds(450, 630, 150, 50);
        checkBalanceButton.setBackground(blue); // Set background color of check balance button
        add(checkBalanceButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(f);
        exitButton.addActionListener(this);
        exitButton.setBounds(450, 700, 150, 50);
        exitButton.setBackground(blue); // Set background color of exit button
        add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == depositButton) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    atm.deposit(amount);
                    outputField.append("Deposited $" + amount + "\n");
                } catch (NumberFormatException ex) {
                    outputField.append("Invalid input. Please enter a valid amount.\n");
                }
            } else if (button == withdrawButton) {
                try {
                    double amount = Double.parseDouble(amountField.getText());

                    if(atm.withdraw(amount))
                    outputField.append("Remaining amount $" +atm.checkBalance() + "\n");

                    else outputField.append("Insufficent Amount\n");
                }
                 catch (NumberFormatException ex) {
                    outputField.append("Invalid input. Please enter a valid amount.\n");
                }
            } else if (button == checkBalanceButton) {
                outputField.append("Current balance: $" + atm.checkBalance() + "\n");
            } else if (button == exitButton) {
                System.exit(0);
            } else if (button == deleteButton) {
                amountField.setText("");
            }
            else if (button == backspaceButton) {
                String text = amountField.getText();
                if (text.length() > 0) {
                    amountField.setText(text.substring(0, text.length() - 1));
                }
            } else {
                // Numpad button pressed
                String buttonText = button.getText();
                amountField.setText(amountField.getText() + buttonText);
            }
        }
    }

    public static void main(String[] args) {

        Bankaccount account = new Bankaccount(1000.0); // initial balance
        ATMInterface_Task2 atmInterface = new ATMInterface_Task2(account);
        atmInterface.setSize(300, 500);
        atmInterface.setVisible(true);
    }
}