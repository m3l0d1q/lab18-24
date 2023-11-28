package lab22.task2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton decimalButton;
    private JButton clearButton;

    public CalculatorView() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (JButton operatorButton : operatorButtons) {
            buttonPanel.add(operatorButton);
        }

        equalsButton = new JButton("=");
        buttonPanel.add(equalsButton);

        decimalButton = new JButton(".");
        buttonPanel.add(decimalButton);

        clearButton = new JButton("C");
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
        pack();
    }

    public void setNumberButtonListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
    }

    public void setOperatorButtonListener(ActionListener listener) {
        for (JButton button : operatorButtons) {
            button.addActionListener(listener);
        }
    }

    public void setEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public void setDecimalButtonListener(ActionListener listener) {
        decimalButton.addActionListener(listener);
    }

    public void setClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public void setTextFieldText(String text) {
        textField.setText(text);
    }

    public String getTextFieldText() {
        return textField.getText();
    }
}
