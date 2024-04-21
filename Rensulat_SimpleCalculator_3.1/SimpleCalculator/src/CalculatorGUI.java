import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class CalculatorGUI implements ActionListener{
        
        JFrame mainFrame;
        JPanel butPanel, iconPanel, aboutPanel;
        JLabel heading, subheading, icon, deleteIcon, squareIcon, info, infoHeading;
        JTextField display, operandsDisplay;
        JButton[] numButtons = new JButton[10];
        JButton[] funcButtons = new JButton[14];
        JButton about = new JButton();
        JButton addButton, subButton, multButton, divButton, clear, equals, decimal, delete, square, root, modulo, factorial, reciprocal, negative;
        double firstNum,secondNum;
        char operand;
        boolean clearDisplay = false, syntaxFlag = false;
        Font montsFont;
        
        public CalculatorGUI(){
            
            try{
                InputStream regular = CalculatorGUI.class.getResourceAsStream("/Montserrat-Light.otf");
                montsFont = Font.createFont(Font.PLAIN, regular);
            }
            catch(FontFormatException | IOException e) {
                e.printStackTrace();
            }
            
            infoHeading = new JLabel();
            infoHeading.setVisible(true);
            infoHeading.setText("ABOUT");
            infoHeading.setFont(montsFont.deriveFont(Font.PLAIN,20));
            infoHeading.setForeground(Color.white);
            infoHeading.setBounds(80, -15, 100, 100);
            infoHeading.setBorder(BorderFactory.createEmptyBorder());
            
            info = new JLabel();
            ImageIcon infoAbout = new ImageIcon(getClass().getResource("/AboutInfo.png"));
            Image infos = infoAbout.getImage().getScaledInstance(160, 486, Image.SCALE_SMOOTH);
            info.setIcon(new ImageIcon(infos));
            info.setVisible(true);
            info.setBounds(20, 35, 300, 547);
            
            aboutPanel = new JPanel();
            aboutPanel.setBounds(185,-1,210,650);
            aboutPanel.setBackground(new Color(30,0,0));
            aboutPanel.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            aboutPanel.setVisible(false);
            aboutPanel.add(info);
            aboutPanel.add(infoHeading);
            aboutPanel.setLayout(null);
            
            ImageIcon calcIcon = new ImageIcon(getClass().getResource("/Icon.png"));
            Image resizedIcon = calcIcon.getImage().getScaledInstance(27, 37, Image.SCALE_SMOOTH);
            icon = new JLabel();
            icon.setIcon(new ImageIcon(resizedIcon));
            icon.setVisible(true);
            icon.setBounds(18, 12, 50, 50);
            
            ImageIcon squareIcon = new ImageIcon(getClass().getResource("/SquareIcon.png"));
            Image resizedSqrIcon = squareIcon.getImage().getScaledInstance(28, 45, Image.SCALE_SMOOTH);
            
            ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/DeleteIcon.png"));
            Image resizedDelIcon = deleteIcon.getImage().getScaledInstance(27, 19, Image.SCALE_SMOOTH);
            
            heading = new JLabel();
            heading.setVisible(true);
            heading.setText("SIMPLE CALCULATOR");
            heading.setBounds(50,10,355,40);
            heading.setBorder(BorderFactory.createEmptyBorder());
            heading.setBackground(Color.black);
            heading.setForeground(Color.white);
            heading.setHorizontalAlignment(JLabel.LEFT);
            heading.setFont(montsFont.deriveFont(Font.PLAIN,22));
            
            subheading = new JLabel();
            subheading.setVisible(true);
            subheading.setText("by Geoff Adrian M. Rensulat");
            subheading.setBounds(50,30,355,40);
            subheading.setBorder(BorderFactory.createEmptyBorder());
            subheading.setBackground(Color.black);
            subheading.setForeground(Color.white);
            subheading.setHorizontalAlignment(JLabel.LEFT);
            subheading.setFont(montsFont.deriveFont(Font.PLAIN,12));
            
            operandsDisplay = new JTextField();
            operandsDisplay.setBounds(8,10,340,20);
            operandsDisplay.setVisible(true);
            operandsDisplay.setBorder(BorderFactory.createEmptyBorder());
            operandsDisplay.setBackground(Color.black);
            operandsDisplay.setForeground(Color.white);
            operandsDisplay.setHorizontalAlignment(JTextField.RIGHT);
            operandsDisplay.setMargin(new Insets(5,5,5,50));
            operandsDisplay.setFont(new Font("Montserrat",Font.PLAIN,20));
            
            display = new JTextField();
            display.setBounds(18,80,350,100);
            display.setVisible(true);
            display.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1));
            display.setBackground(Color.black);
            display.setForeground(Color.white);
            display.setHorizontalAlignment(JTextField.RIGHT);
            display.setMargin(new Insets(5,5,5,50));
            display.setFont(new Font("Montserrat",Font.PLAIN,40));
            display.add(operandsDisplay);
            
            addButton = new JButton("+");
            subButton = new JButton("-");
            multButton = new JButton("x");
            divButton = new JButton("÷");
            clear = new JButton("C");
            equals = new JButton("=");
            decimal = new JButton(".");
            delete = new JButton();
            square = new JButton();
            root = new JButton("√x");
            modulo = new JButton("%");
            factorial = new JButton("fac");
            reciprocal = new JButton("1/x");
            negative = new JButton("+/-");
            
            funcButtons[0] = addButton;
            funcButtons[1] = subButton;
            funcButtons[2] = multButton;
            funcButtons[3] = divButton;
            funcButtons[4] = clear;
            funcButtons[5] = equals;
            funcButtons[6] = decimal;
            funcButtons[7] = delete;
            funcButtons[8] = square;
            funcButtons[9] = root;
            funcButtons[10] = modulo;
            funcButtons[11] = factorial;
            funcButtons[12] = reciprocal;
            funcButtons[13] = negative;
            
            ImageIcon aboutIcon = new ImageIcon(getClass().getResource("/AboutButton.png"));
            Image aboutButtonIcon = aboutIcon.getImage().getScaledInstance(20, 15, Image.SCALE_SMOOTH);
            
            about.setBounds(336,20,30,30);
            about.setIcon(new ImageIcon(aboutButtonIcon));
            about.addActionListener(this);
            about.setFocusable(false);
            about.setBorder(BorderFactory.createEmptyBorder());
            about.setBackground(Color.black);
            about.setVisible(true);
            
            for(int i = 0; i < 14 ; i++){
                funcButtons[i].setPreferredSize(new Dimension(80,55));
                funcButtons[i].setFocusable(false);
                funcButtons[i].setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1));
                funcButtons[i].addActionListener((ActionListener) this);
                funcButtons[i].setFont(new Font("Montserrat",Font.BOLD,30));
                funcButtons[i].setForeground(new Color(225,225,225));
                funcButtons[i].setVerticalTextPosition(JButton.CENTER);
                funcButtons[i].setHorizontalTextPosition(JButton.CENTER);
            }
            
            for(int i = 0; i < 10; i++){
                numButtons[i] = new JButton(String.valueOf(i));
                numButtons[i].setPreferredSize(new Dimension(80,55));
                numButtons[i].setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1));
                numButtons[i].setFocusable(false);
                numButtons[i].addActionListener((ActionListener)this);
                numButtons[i].setFont(new Font("Montserrat",Font.BOLD,30));
                numButtons[i].setForeground(new Color(225,225,225));
                numButtons[i].setBackground(new Color(68,68,68));
                numButtons[i].setVerticalTextPosition(JButton.CENTER);
                numButtons[i].setHorizontalTextPosition(JButton.CENTER);
            }
            
            butPanel = new JPanel();
            butPanel.setBackground(Color.black);
            butPanel.setBounds(14,230,360,400);
            butPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5,5,5,5);     
            
            //--------------------------------------------------------FUNCTION BUTTONS---------------------------------///
            gbc.gridx = 3;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            addButton.setBackground(new Color(168,0,0));
            butPanel.add(addButton, gbc);
            
            gbc.gridx = 3;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            subButton.setBackground(new Color(168,0,0));
            butPanel.add(subButton, gbc);
            
            gbc.gridx = 3;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            multButton.setBackground(new Color(168,0,0));
            butPanel.add(multButton, gbc);
            
            gbc.gridx = 3;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            divButton.setBackground(new Color(168,0,0));
            butPanel.add(divButton, gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            clear.setBackground(new Color(51,51,51));
            butPanel.add(clear, gbc);
            
            gbc.gridx = 3;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 2;
            equals.setBackground(new Color(255,0,0));
            butPanel.add(equals, gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            decimal.setBackground(new Color(51,51,51));
            butPanel.add(decimal, gbc);
            
            delete.setIcon(new ImageIcon(resizedDelIcon));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            delete.setBackground(new Color(51,51,51));
            butPanel.add(delete, gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            square.setIcon(new ImageIcon(resizedSqrIcon));
            square.setBackground(new Color(112,0,0));
            butPanel.add(square, gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            root.setBackground(new Color(112,0,0));
            butPanel.add(root, gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            modulo.setBackground(new Color(168,0,0));
            butPanel.add(modulo, gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            factorial.setBackground(new Color(112,0,0));
            factorial.setBounds(18, 196, 80, 34);
            
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            reciprocal.setBackground(new Color(112,0,0));
            butPanel.add(reciprocal, gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            negative.setBackground(new Color(112,0,0));
            butPanel.add(negative, gbc);
            
           //--------------------------------------------------------NUMBER BUTTONS---------------------------------///
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[1], gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[2], gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[3], gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[4], gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[5], gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[6], gbc);
            
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[7], gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[8], gbc);
            
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            butPanel.add(numButtons[9], gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.gridheight = 1;
            
            butPanel.add(numButtons[0], gbc);
            
            mainFrame = new JFrame("Simple Calculator by Geoff Rensulat");
            Image logo = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
            mainFrame.setIconImage(logo);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLayout(null);
            mainFrame.setSize(400,680);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.getContentPane().setBackground(new Color(0,0,0));
            mainFrame.add(about);
            mainFrame.add(aboutPanel);
            mainFrame.add(factorial, gbc);
            mainFrame.add(butPanel);
            mainFrame.add(display);
            mainFrame.add(heading);
            mainFrame.add(subheading);
            mainFrame.add(icon);
            mainFrame.add(factorial, gbc);
        }
        
	public static void main(String[] args) {
		
		CalculatorGUI simpleCalc = new CalculatorGUI();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        for (int i = 0; i < 10; i++){
            if (e.getSource() == numButtons[i]){
                if (clearDisplay==true){
                    display.setText("");
                    operandsDisplay.setText("");
                    clearDisplay = false;
                }
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        
        Calculator algorithm = new Calculator(firstNum, secondNum);
        
        try {
            if (e.getSource() == addButton){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "+"));
                display.setText("");
                operand = '+';
            }
            if (e.getSource() == subButton){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "-"));
                display.setText("");
                operand = '-';
            }
            if (e.getSource() == multButton){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "x"));
                display.setText("");
                operand = 'x';
            }
            if (e.getSource() == divButton){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "÷"));
                display.setText("");
                operand = '÷';
            }
            if (e.getSource() == square){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "^2"));
                display.setText("");
                operand = 's';
            }
            if (e.getSource() == factorial){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat("factorial(" + display.getText() + ")"));
                display.setText("");
                operand = 'f';
            }
            if (e.getSource() == root){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat("√(" + display.getText() + ")"));
                display.setText("");
                operand = 'r';
            }
            if (e.getSource() == modulo){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "%"));
                display.setText("");
                operand = '%';
            }
            if (e.getSource() == reciprocal){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                operandsDisplay.setText(operandsDisplay.getText().concat("1/(" + display.getText() + ")"));
                display.setText("");
                operand = 'p';
            }
            if (e.getSource() == negative){
                operandsDisplay.setText("");
                firstNum = Double.parseDouble(display.getText());
                display.setText(Double.toString(algorithm.nega(firstNum)));
                firstNum = Double.parseDouble(display.getText());
            }
            
            if (e.getSource() == clear){
                operandsDisplay.setText("");
                display.setText("");
            }
            if (e.getSource() == decimal){
                display.setText(display.getText().concat("."));
            }
            if (e.getSource() == about){
                if (aboutPanel.isVisible()){
                    aboutPanel.setVisible(false);
                    about.setBackground(Color.black);
                    for (int i = 0; i<10;i++){
                        numButtons[i].setEnabled(true);
                    }
                    for (int i = 0; i<14;i++){
                        funcButtons[i].setEnabled(true);
                    }
                    display.setEnabled(true);
                    operandsDisplay.setEnabled(true);
                }
                else{
                    aboutPanel.setVisible(true);
                    about.setBackground(new Color(30,0,0));
                    for (int i = 0; i<10;i++){
                        numButtons[i].setEnabled(false);
                    }
                    for (int i = 0; i<14;i++){
                        funcButtons[i].setEnabled(false);
                    }
                    display.setEnabled(false);
                    operandsDisplay.setEnabled(false);
                    
                }
            }
            if (e.getSource() == delete){
                String stringCurrent = display.getText();
                display.setText("");
                if (syntaxFlag){
                    display.setText("");
                    operandsDisplay.setText("");
                    syntaxFlag = false;
                }
                else{
                    for (int i = 0; i < (stringCurrent.length()-1); i++){
                        display.setText(display.getText() + stringCurrent.charAt(i));
                    }
                }
            }
            
            if (e.getSource() == equals){
                boolean undefinedFlag = false;
                double result = 0;
                
                if (operand == '+' || operand == '-' || operand == 'x' || operand == '÷' || operand == '%'){
                        secondNum = Double.parseDouble(display.getText());
                        operandsDisplay.setText(operandsDisplay.getText().concat(display.getText() + "="));
                        clearDisplay = true;

                        switch (operand){
                            case '+':
                                result = algorithm.addition(firstNum, secondNum);
                                break;
                            case '-':
                                result = algorithm.subtraction(firstNum, secondNum);
                                break;
                            case 'x':
                                result = algorithm.multiplication(firstNum, secondNum);
                                break;
                            case '÷':
                                if (secondNum == 0){
                                    undefinedFlag = true;
                                    break;
                                }
                                else {
                                    result = algorithm.division(firstNum, secondNum);
                                    break;
                                } 
                            case '%':
                                result = algorithm.modulo(firstNum, secondNum);
                                break;
                        }
                }
                else if (operand == 's'){
                    result = algorithm.squareAlgo(firstNum);
                }
                else if (operand == 'f'){
                    result = algorithm.factorial(firstNum);
                }
                else if (operand == 'p'){
                    result = algorithm.reciprocal(firstNum);
                }
                else if (operand == 'r'){
                    result = algorithm.radical(firstNum);
                }
               
                if (undefinedFlag){
                    operandsDisplay.setText("");
                    display.setText(String.valueOf("Syntax Error"));
                    syntaxFlag = true;
                }
                else{
                    display.setText(String.valueOf(result));
                    firstNum = Double.parseDouble(display.getText());
                }   
                
                
            }
        }
        catch (Exception ex){
            operandsDisplay.setText("");
            display.setText("Syntax Error");
            syntaxFlag = true;
        }
    }
}
