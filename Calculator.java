import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.JTextField;



public class Calculator {
    static int operation;

    public static void main(String[] args) {
        JFrame calculatorFrame = new JFrame("Calculator");
        calculatorFrame.setResizable(false);
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setLayout(new BorderLayout()); // Set BorderLayout for the frame

        JPanel inputFields = new JPanel();
        inputFields.setLayout(new BoxLayout(inputFields, BoxLayout.X_AXIS));
        JTextField textField = new JTextField(20); // Create a JTextField for input
        JTextField textFieldtwo = new JTextField(20); // Create another JTextField for input
        JTextField mods = new JTextField(5); // Create another JTextField for input
        JTextField outputField = new JTextField(30);
        inputFields.add(textField); // Add the first text field
        inputFields.add(mods); // Add the first text field
        inputFields.add(textFieldtwo); // Add the second text field
        inputFields.add(outputField);
        outputField.setBorder(null);			//https://stackoverflow.com/questions/2281937/swing-jtextfield-how-to-remove-the-border
        outputField.setHorizontalAlignment(JTextField.CENTER);	//http://www.java2s.com/Code/Java/Swing-JFC/AligningtheTextinaJTextFieldComponent.htm

        
        JPanel outputFields = new JPanel();
        outputFields.add(outputField);
        calculatorFrame.add(outputFields, BorderLayout.SOUTH);		//https://coderanch.com/t/649426/java/Java-GUI-BorderLayout-application-buttons
        calculatorFrame.add(inputFields, BorderLayout.NORTH); // Add inputFields panel to the top

        outputField.setEditable(false);
        mods.setEditable(false);
        mods.setHorizontalAlignment(SwingConstants.CENTER);


        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        calculatorFrame.add(buttonPanel, BorderLayout.CENTER); // Add buttonPanel to the center

        JButton plusButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton enter = new JButton("Enter");
        JButton mulButton = new JButton("x");
        JButton devButton = new JButton("/");
        JButton clear = new JButton("Clear");
        
        plusButton.setBackground(new Color(255, 255, 255));
        subButton.setBackground(new Color(255, 255, 255));
        enter.setBackground(new Color(255, 255, 255));
        mulButton.setBackground(new Color(255, 255, 255));
        devButton.setBackground(new Color(255, 255, 255));
        clear.setBackground(new Color(255, 255, 255));
        //https://stackoverflow.com/questions/4172940/how-to-set-background-color-of-a-button-in-java-gui

        buttonPanel.add(plusButton);
        buttonPanel.add(subButton);
        buttonPanel.add(enter);
        buttonPanel.add(mulButton);
        buttonPanel.add(devButton);
        buttonPanel.add(clear);

        plusButton.addActionListener(new ActionListener() {		//https://www.javatpoint.com/java-actionlistener
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = 1;
                mods.setText("+");
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = 2;
                mods.setText("-");
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = 3;
                mods.setText("x");
            }
        });

        devButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = 4;
                mods.setText("/");
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String two = textField.getText();
            	String one = textField.getText();
            	String userInput = two + one;
            	
            	if (userInput.matches("(?i).*[a-z].*")) {
            	    outputField.setText("Contains Letters, Please try again");
            	    
            	} else {

            		if(operation == 1) {
                		double inOne = Integer.parseInt(textField.getText());
                		double inTwo = Integer.parseInt(textFieldtwo.getText());
                		double result = inOne + inTwo;
                		outputField.setText(String.valueOf(result));
                	}
                	else if (operation == 2){
                		double inOne = Integer.parseInt(textField.getText());
                		double inTwo = Integer.parseInt(textFieldtwo.getText());
                		double result = inOne - inTwo;
                		outputField.setText(String.valueOf(result));
                	} else if (operation == 3){
                		double inOne = Integer.parseInt(textField.getText());
                		double inTwo = Integer.parseInt(textFieldtwo.getText());
                		double result = inOne * inTwo;
                		outputField.setText(String.valueOf(result));
                	}else if (operation == 4){
                		double inOne = Integer.parseInt(textField.getText());
                		double inTwo = Integer.parseInt(textFieldtwo.getText());
                		double result = inOne / inTwo;
                		outputField.setText(String.valueOf(result));
                	}}}});
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to clear the text fields or perform any clear operation
                textField.setText("");
                textFieldtwo.setText("");
                outputField.setText("");
                mods.setText("");
            }
        });


        calculatorFrame.pack();
        calculatorFrame.setSize(400,300);
        calculatorFrame.setVisible(true);
    }


}
