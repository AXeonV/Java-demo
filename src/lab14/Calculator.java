package lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Calculator extends JFrame {

    private JTextField field1;
    private JTextField field2;
    private JLabel result;
    private ButtonGroup operation;
    private char op = '+';


    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with vertical stacking
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Row 1: input fields
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        field1 = new JTextField(8);
        field2 = new JTextField(8);
        row1.add(field1);
        row1.add(field2);
        mainPanel.add(row1);

        // Row 2: Radio buttons
        JPanel row2 = new JPanel(new GridLayout(1, 4, 10, 10));
        JRadioButton add = new JRadioButton("+", true);
        JRadioButton minus = new JRadioButton("-");
        JRadioButton multiply = new JRadioButton("*");
        JRadioButton divide = new JRadioButton("/");
        operation = new ButtonGroup(); // Grouping radio buttons so only one can be selected
        operation.add(add);
        operation.add(minus);
        operation.add(multiply);
        operation.add(divide);
        row2.add(add);
        row2.add(minus);
        row2.add(multiply);
        row2.add(divide);
        mainPanel.add(row2);

        // Radio button listener
        ItemListener listener = e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                op = ((JRadioButton) e.getSource()).getText().charAt(0);
                System.out.println("Selected operation: " + op);
            }
        };
        add.addItemListener(listener);
        minus.addItemListener(listener);
        multiply.addItemListener(listener);
        divide.addItemListener(listener);


        // Row 3: Calculate button and result label
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton calculate = new JButton("Calculate");
        result = new JLabel("Result = ");
        result.setPreferredSize(new Dimension(120, 25));
        row3.add(calculate);
        row3.add(result);
        mainPanel.add(row3);

        calculate.addActionListener(e -> {
            try {
                double first = Double.parseDouble(field1.getText());
                double second = Double.parseDouble(field2.getText());
                double result = switch (op) {
                  case '+' -> first + second;
                  case '-' -> first - second;
                  case '*' -> first * second;
                  case '/' -> first / second;
                  default -> 0;
                };
                this.result.setText("Result = " + result);
                this.repaint();
            } catch (NumberFormatException ex) {
                this.result.setText("Invalid input");
                this.repaint();
            }
        });

        add(mainPanel);
        pack();
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
}