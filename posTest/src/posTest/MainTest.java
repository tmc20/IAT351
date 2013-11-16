package posTest;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MainTest implements ActionListener {

	// private static final int WIDTH = 1920;
	// private static final int HEIGHT = 1030;
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 900;

	private static JFrame window = new JFrame("Point of Sale");

	// LAYOUT
	private static final BorderLayout LAYOUT_STYLE_BORDER = new BorderLayout();
	private static final BoxLayout LAYOUT_STYLE_BOX = new BoxLayout(window,
			BoxLayout.PAGE_AXIS);
	private static final FlowLayout LAYOUT_STYLE_FLOW = new FlowLayout();
	private static final GridLayout LAYOUT_STYLE_GRID = new GridLayout(4, 1);

	// COMPONENTS
	// top tabs
	private JButton bSel = new JButton("Selection");
	private JButton bFood = new JButton("Food");
	private JButton bPrev = new JButton("Previous Orders");
	private int tabHeight = HEIGHT / 10;

	// drink name label
	private String drinkNameText = new String();
	private JLabel drinkName = new JLabel("testing");
	private JTextField textField = new JTextField(20);

	// size buttons
	private JButton bSmall = new JButton("Small");
	private JButton bMed = new JButton("Medium");
	private JButton bLarge = new JButton("Large");

	// base drinks
	private JButton b1 = new JButton("Cappuccino");
	private JButton b2 = new JButton("Latte");
	private JButton b3 = new JButton("Mocha");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");

	// option panel
	private JScrollPane optionSP = new JScrollPane();
	private JButton bNext = new JButton("Next Drink");

	// order panel
	private JTextArea orderTextArea = new JTextArea();
	private JScrollPane orderSP = new JScrollPane(orderTextArea);

	// ARRAYS
	private JButton[] tabsArr = { bSel, bFood, bPrev };
	private JButton[] drinksArr = { b1, b2, b3 };
	private JButton[] sizeArr = { bSmall, bMed, bLarge };

	// MODES
	int screen; // 0 = selection; 1 = payment; 2 = previous order; 3 = refund
	int selectScreen; // 0 = custom; 1 = base drinks

	public MainTest() {
		screen = 0;
		selectScreen = 0;
		createAndShowGUI();
	}

	public void addComponentsToPane(Container c) {

		c.setLayout(null);
		Insets insets = c.getInsets();

		// [TOP] TAB BAR
		for (int i = 0; i < tabsArr.length; i++) {
			JButton tempTab = tabsArr[i];
			tempTab.setPreferredSize(new Dimension(WIDTH / 3, tabHeight));
			Dimension size = tempTab.getPreferredSize();
			System.out.println(tempTab.getSize());
			tempTab.setBounds(i * WIDTH / 3 + insets.left, 0 + insets.top,
					size.width, tabHeight);
			
			c.add(tempTab);
		}

		// [SEL TOP] DRINK NAME & SIZE
		// drink name
		drinkName.setBounds(WIDTH / 20, tabHeight * 4 / 3, 50, 50);
		c.add(drinkName);
		// size buttons
		for (int i = 0; i < sizeArr.length; i++) {
			JButton tempButton = sizeArr[i];
			Dimension size = tempButton.getPreferredSize();
			tempButton.setBounds(WIDTH / 4 + i * size.width, tabHeight + 50
					+ insets.top, size.width, size.height);
			c.add(tempButton);
		}

		// [SEL BOT] BASE DRINK & CUSTOMIZATION BUTTONS
		// base drinks

		// customization

		// [OPTIONS] ORDER CUSTOMIZATIONS LIST
		optionSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight* 3/2));
		Dimension optSize = optionSP.getPreferredSize();
		optionSP.setBounds(WIDTH * 3 / 5 + insets.left, tabHeight + insets.top,
				optSize.width, optSize.height - tabHeight);
		c.add(optionSP);

		bNext.setPreferredSize(new Dimension(WIDTH / 5, tabHeight));
		Dimension nextSize = bNext.getPreferredSize();
		bNext.setBounds(WIDTH * 3 / 5 + insets.left, HEIGHT - tabHeight*3/2
				+ insets.top, nextSize.width, nextSize.height);
		c.add(bNext);

		// [RIGHT] ORDER LIST
		orderSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT-tabHeight*3/2));
		Dimension ordSize = orderSP.getPreferredSize();
		orderSP.setBounds(WIDTH * 4 / 5 + insets.left, tabHeight + insets.top,
				ordSize.width, ordSize.height);
		
		c.add(orderSP);

		/*
		 * Dimension size = b1.getPreferredSize(); b1.setBounds(25 +
		 * insets.left, 5 + insets.top, size.width, size.height); size =
		 * b2.getPreferredSize(); b2.setBounds(55 + insets.left, 40 +
		 * insets.top, size.width, size.height); size = b3.getPreferredSize();
		 * b3.setBounds(150 + insets.left, 15 + insets.top, size.width + 50,
		 * size.height + 20);
		 */
	}

	private void createAndShowGUI() {
		JFrame frame = new JFrame("Demo Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addComponentsToPane(frame.getContentPane());

		Insets insets = frame.getInsets();
		frame.setSize(WIDTH, HEIGHT);
		
		frame.setVisible(true);
	}
	
	private void updateScreen() {
		switch(screen) {
		// selection/ready screen
		case 0: {
			switch(selectScreen) {
			case 0: {
				
			}
			
			case 1: {
				
			}
			}
			
		}
		
		// payment screen
		case 1: {
			
		}
		
		// previous order screen
		case 2: {
			
		}
		// refund screen
		case 3: {
			
		}
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");
		drinkNameText = textField.getText();
		drinkName.setText(drinkNameText);
	}

	public static void main(String[] args) {
		MainTest pos = new MainTest();
	}

}
