package view_control;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import util.Math.OPERATOR;

public class CalculatorUI extends JFrame {
	private final JLabel calcArea = new JLabel("");

	private boolean initialCalcAreaInputState;
	private enum STATE { INITIAL, SAVE1, SAVE2, CALC }

	private STATE mathState;
	
	// calculator values
    private OPERATOR mathOp;
	private double arg1;
    private double arg2;
    private double calcAnswer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CalculatorUI frame = new CalculatorUI();
				frame.setTitle("Scientific Calculator");
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	private void calculateAnswer()  // method to perform calculation
	{
	    calcAnswer = util.Math.calculateIt(arg1, mathOp, arg2);
		calcArea.setText(String.valueOf(calcAnswer));
	    arg1 = Double.parseDouble(calcArea.getText());
	    mathState = STATE.CALC;
		initialCalcAreaInputState = true;
	}
	
	private void updateCalcArea(String string) {
		if (initialCalcAreaInputState) {  // sets text to string on initial key typed
			calcArea.setText(string);
			initialCalcAreaInputState = false;
	    } else  {                         // concatenates string to end of text subsequent keys typed
			calcArea.setText(calcArea.getText() + string);
	    }
	}
	
	/**
	 * Save values for Calculator.
	 */
	private void saveValueOfArg1() { // method to store 1st value in calculation (arg1)
	    arg1 = Double.parseDouble((calcArea.getText()));
	    mathState = STATE.SAVE1;
		initialCalcAreaInputState = true;
	}
	
	private void square() {
		arg1 = Double.parseDouble((calcArea.getText()));
		mathState = STATE.CALC;
		initialCalcAreaInputState = true;
	}
	
	private void saveValueOfArg2() { // method to store 2nd value in calculation (arg2)
		if (mathState != STATE.CALC) {
			arg2 = Double.parseDouble((calcArea.getText()));
			mathState = STATE.SAVE2;
		}
	}
	
	private void saveValueOfMathOp(OPERATOR op) { // method to store operator
		mathOp = op;
	}
	
	private void clearCalculator() {  // helper method to clear and update calculator to default
		// calculator control
		String calcAreaDefault = "0.0";
		calcArea.setText(calcAreaDefault);
		mathState = STATE.INITIAL;
		initialCalcAreaInputState = true;
		arg1 = 0.0;
		arg2 = 0.0;
		calcAnswer = 0.0;
	}

	/**
	 * Create the frame.
	 */
	public CalculatorUI() {
		getContentPane().setBackground(new Color(211, 211, 211));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 700, 375);
		getContentPane().setLayout(null);
		calcArea.setForeground(Color.BLACK);
		calcArea.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
		calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
		calcArea.setBounds(18, 6, 650, 67);
		getContentPane().add(calcArea);
		
		JButton button_1 = new JButton("1");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_1.setBackground(Color.ORANGE);
			}
		});
		button_1.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_1.setOpaque(true);
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(Color.ORANGE);
		button_1.addActionListener(e -> updateCalcArea(button_1.getText()));
		button_1.setBounds(35, 86, 75, 40);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_2.setBackground(Color.ORANGE);
			}
		});
		button_2.addActionListener(e -> updateCalcArea(button_2.getText()));
		button_2.setOpaque(true);
		button_2.setForeground(Color.BLACK);
		button_2.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_2.setBackground(Color.ORANGE);
		button_2.setBounds(122, 86, 75, 40);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_3.setBackground(Color.ORANGE);
			}
		});
		button_3.addActionListener(e -> updateCalcArea(button_3.getText()));
		button_3.setOpaque(true);
		button_3.setForeground(Color.BLACK);
		button_3.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_3.setBackground(Color.ORANGE);
		button_3.setBounds(209, 86, 75, 40);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_4.setBackground(Color.ORANGE);
			}
		});
		button_4.addActionListener(e -> updateCalcArea(button_4.getText()));
		button_4.setOpaque(true);
		button_4.setForeground(Color.BLACK);
		button_4.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_4.setBackground(Color.ORANGE);
		button_4.setBounds(35, 138, 75, 40);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_5.setBackground(Color.ORANGE);
			}
		});
		button_5.addActionListener(e -> updateCalcArea(button_5.getText()));
		button_5.setOpaque(true);
		button_5.setForeground(Color.BLACK);
		button_5.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_5.setBackground(Color.ORANGE);
		button_5.setBounds(122, 138, 75, 40);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_6.setBackground(Color.ORANGE);
			}
		});
		button_6.addActionListener(e -> updateCalcArea(button_6.getText()));
		button_6.setOpaque(true);
		button_6.setForeground(Color.BLACK);
		button_6.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_6.setBackground(Color.ORANGE);
		button_6.setBounds(209, 138, 75, 40);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setBackground(Color.ORANGE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_7.setBackground(Color.ORANGE);
			}
		});
		button_7.addActionListener(e -> updateCalcArea(button_7.getText()));
		button_7.setOpaque(true);
		button_7.setForeground(Color.BLACK);
		button_7.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_7.setBackground(Color.ORANGE);
		button_7.setBounds(35, 190, 75, 40);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_8.setBackground(Color.ORANGE);
			}
		});
		button_8.addActionListener(e -> updateCalcArea(button_8.getText()));
		button_8.setOpaque(true);
		button_8.setForeground(Color.BLACK);
		button_8.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_8.setBackground(Color.ORANGE);
		button_8.setBounds(122, 190, 75, 40);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setBackground(Color.ORANGE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_9.setBackground(Color.ORANGE);
			}
		});
		button_9.addActionListener(e -> updateCalcArea(button_9.getText()));
		button_9.setOpaque(true);
		button_9.setForeground(Color.BLACK);
		button_9.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_9.setBackground(Color.ORANGE);
		button_9.setBounds(209, 190, 75, 40);
		getContentPane().add(button_9);
		
		JButton button_0 = new JButton("0");
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_0.setBackground(Color.ORANGE);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_0.setBackground(Color.ORANGE);
			}
		});
		button_0.addActionListener(e -> updateCalcArea(button_0.getText()));
		button_0.setOpaque(true);
		button_0.setForeground(Color.BLACK);
		button_0.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_0.setBackground(Color.ORANGE);
		button_0.setBounds(122, 242, 75, 40);
		getContentPane().add(button_0);
		
		JButton button_plus = new JButton("+");
		button_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_plus.setBackground(Color.BLACK);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_plus.setBackground(Color.ORANGE);
			}
		});
		button_plus.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.PLUS);
		});
		button_plus.setOpaque(true);
		button_plus.setForeground(Color.BLACK);
		button_plus.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_plus.setBackground(Color.ORANGE);
		button_plus.setBounds(327, 138, 75, 40);
		getContentPane().add(button_plus);
		
		JButton button_minus = new JButton("-");
		button_minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_minus.setBackground(Color.BLACK);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_minus.setBackground(Color.ORANGE);
			}
		});
		button_minus.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.MINUS);
		});
		button_minus.setOpaque(true);
		button_minus.setForeground(Color.BLACK);
		button_minus.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_minus.setBackground(Color.ORANGE);
		button_minus.setBounds(327, 190, 75, 40);
		getContentPane().add(button_minus);

		JButton button_roots = new JButton("ROOTS	");
		button_roots.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_roots.setBackground(Color.BLACK);
			}

			public void mouseReleased(MouseEvent e) {
				button_roots.setBackground(Color.ORANGE);
			}
		});
		button_roots.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.ROOTS);
		});
		button_roots.setOpaque(true);
		button_roots.setForeground(Color.BLACK);
		button_roots.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_roots.setBackground(Color.ORANGE);
		button_roots.setBounds(588, 242, 75, 40);
		getContentPane().add(button_roots);

		
		JButton button_equals = new JButton("=");
		button_equals.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_equals.setBackground(Color.BLACK);
			}
			
			public void mouseReleased(MouseEvent e) {
				button_equals.setBackground(Color.ORANGE);
			}
		});
		button_equals.addActionListener(e -> {
			saveValueOfArg2();
			calculateAnswer();
		});
		button_equals.setOpaque(true);
		button_equals.setForeground(Color.BLACK);
		button_equals.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_equals.setBackground(Color.ORANGE);
		button_equals.setBounds(327, 242, 75, 40);
		getContentPane().add(button_equals);
		
		JButton button_clear = new JButton("AC");
		button_clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_clear.setBackground(new Color(0, 204, 255));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_clear.setBackground(new Color(0, 204, 255));
			}
		});
		button_clear.addActionListener(e -> clearCalculator());
		button_clear.setOpaque(true);
		button_clear.setForeground(Color.BLACK);
		button_clear.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_clear.setBackground(new Color(0, 204, 255));
		button_clear.setBounds(327, 85, 75, 40);
		getContentPane().add(button_clear);

		JButton button_divide = new JButton("/");
		button_divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_divide.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_divide.setBackground(Color.ORANGE);
			}
		});
		//button_divide.addActionListener(e -> clearCalculator());
		button_divide.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.DIVIDE);
		});
		button_divide.setOpaque(true);
		button_divide.setForeground(Color.BLACK);
		button_divide.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_divide.setBackground(Color.ORANGE);
		button_divide.setBounds(414, 138, 75, 40);
		getContentPane().add(button_divide);

		JButton button_multiply = new JButton("*");
		button_multiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_multiply.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_multiply.setBackground(Color.ORANGE);
			}
		});
		//button_divide.addActionListener(e -> clearCalculator());
		button_multiply.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.MULTIPLY);
		});
		button_multiply.setOpaque(true);
		button_multiply.setForeground(Color.BLACK);
		button_multiply.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_multiply.setBackground(Color.ORANGE);
		button_multiply.setBounds(414, 190, 75, 40);
		getContentPane().add(button_multiply);

		JButton button_power = new JButton("^");
		button_power.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_power.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_power.setBackground(Color.ORANGE);
			}
		});

		button_power.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.POWER);
		});
		button_power.setOpaque(true);
		button_power.setForeground(Color.BLACK);
		button_power.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_power.setBackground(Color.ORANGE);
		button_power.setBounds(414, 86, 75, 40);
		getContentPane().add(button_power);




		JButton button_sin = new JButton("sin");
		button_sin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_sin.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_sin.setBackground(Color.ORANGE);
			}
		});

		button_sin.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.SIN);
		});
		button_sin.setOpaque(true);
		button_sin.setForeground(Color.BLACK);
		button_sin.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_sin.setBackground(Color.ORANGE);
		button_sin.setBounds(501, 86, 75, 40);
		getContentPane().add(button_sin);

		JButton button_cos = new JButton("cos");
		button_cos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_cos.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_cos.setBackground(Color.ORANGE);
			}
		});

		button_cos.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.COSINE);
		});
		button_cos.setOpaque(true);
		button_cos.setForeground(Color.BLACK);
		button_cos.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_cos.setBackground(Color.ORANGE);
		button_cos.setBounds(501, 138, 75, 40);
		getContentPane().add(button_cos);

		JButton button_tan = new JButton("tan");
		button_tan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_tan.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_tan.setBackground(Color.ORANGE);
			}
		});

		button_tan.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.TAN);
		});
		button_tan.setOpaque(true);
		button_tan.setForeground(Color.BLACK);
		button_tan.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_tan.setBackground(Color.ORANGE);
		button_tan.setBounds(501, 190, 75, 40);
		getContentPane().add(button_tan);

		JButton button_asin = new JButton("sin^-1");
		button_asin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_asin.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_asin.setBackground(Color.ORANGE);
			}
		});

		button_asin.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.SINVERSE);
		});
		button_asin.setOpaque(true);
		button_asin.setForeground(Color.BLACK);
		button_asin.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_asin.setBackground(Color.ORANGE);
		button_asin.setBounds(588, 86, 75, 40);
		getContentPane().add(button_asin);


		JButton button_acos = new JButton("cos^-1");
		button_acos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_acos.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_acos.setBackground(Color.ORANGE);
			}
		});

		button_acos.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.CINVERSE);
		});
		button_acos.setOpaque(true);
		button_acos.setForeground(Color.BLACK);
		button_acos.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_acos.setBackground(Color.ORANGE);
		button_acos.setBounds(588, 138, 75, 40);
		getContentPane().add(button_acos);

		JButton button_atan = new JButton("tan^-1");
		button_atan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_atan.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_atan.setBackground(Color.ORANGE);
			}
		});

		button_atan.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.TINVERSE);
		});
		button_atan.setOpaque(true);
		button_atan.setForeground(Color.BLACK);
		button_atan.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_atan.setBackground(Color.ORANGE);
		button_atan.setBounds(588, 190, 75, 40);
		getContentPane().add(button_atan);

		JButton button_square = new JButton("^2");
		button_square.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_square.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_square.setBackground(Color.ORANGE);
			}
		});

		button_square.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.SQUARE);
		});
		button_square.setOpaque(true);
		button_square.setForeground(Color.BLACK);
		button_square.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_square.setBackground(Color.ORANGE);
		button_square.setBounds(414, 242, 75, 40);
		getContentPane().add(button_square);

		JButton button_ln = new JButton("ln");
		button_ln.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_ln.setBackground(Color.ORANGE);
			}

			public void mouseReleased(MouseEvent e) {
				button_ln.setBackground(Color.ORANGE);
			}
		});

		button_ln.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.LN);
		});
		button_ln.setOpaque(true);
		button_ln.setForeground(Color.BLACK);
		button_ln.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_ln.setBackground(Color.ORANGE);
		button_ln.setBounds(501, 242, 75, 40);
		getContentPane().add(button_ln);

		JButton button_pi = new JButton("PI");
		button_pi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_pi.setBackground(Color.BLACK);
			}

			public void mouseReleased(MouseEvent e) {
				button_pi.setBackground(Color.ORANGE);
			}
		});
		button_pi.addActionListener(e -> {
			square();
			saveValueOfMathOp(OPERATOR.PI);
		});
		button_pi.setOpaque(true);
		button_pi.setForeground(Color.BLACK);
		button_pi.setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
		button_pi.setBackground(Color.ORANGE);
		button_pi.setBounds(501, 300, 75, 40);
		getContentPane().add(button_pi);
		
		JLabel lblourCalculator = new JLabel("Aryan and Pranav's Calculator");
		lblourCalculator.setBounds(6, 300, 250, 16);
		getContentPane().add(lblourCalculator);

	}
}






	
