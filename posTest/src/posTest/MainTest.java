// TODO: screen switching when you press 'drink' button; payment screen (dialog); previous order screen; refund screen

package posTest;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MainTest implements ActionListener {

	private static JFrame frame = new JFrame("Point of Sale");
	private static JFrame dialog = new JFrame("Change");

	private String newline = "\n";

	// private static final int WIDTH = 1920;
	// private static final int HEIGHT = 1030;
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 900;

	// LAYOUTS
	private static final BorderLayout LAYOUT_STYLE_BORDER = new BorderLayout();
	private static final BoxLayout LAYOUT_STYLE_BOX = new BoxLayout(frame,
			BoxLayout.PAGE_AXIS);
	private static final FlowLayout LAYOUT_STYLE_FLOW = new FlowLayout();
	private static final GridLayout LAYOUT_STYLE_FOUR_GRID = new GridLayout(3,
			1);
	private static final GridLayout LAYOUT_STYLE_SIX_GRID = new GridLayout(5, 1);
	private static final GridLayout LAYOUT_STYLE_EIGHT_GRID = new GridLayout(4,
			1);
	private static final GridLayout LAYOUT_STYLE_NINE_GRID = new GridLayout(4,
			1);

	// COMPONENTS
	// top tabs
	private JButton bSel = new JButton("Selection");
	private JButton bFood = new JButton("Food");
	private JButton bPrev = new JButton("Previous Orders");
	private int tabHeight = HEIGHT / 10;

	// drink name label
	private String drinkNameText = new String("[DRINK]");
	private JLabel drinkName = new JLabel("testing");
	private JButton bDrink = new JButton(drinkNameText);

	// size buttons
	private JButton bSmall = new JButton("Small");
	private JButton bMed = new JButton("Medium");
	private JButton bLarge = new JButton("Large");

	// base drinks
	private JButton bDr1 = new JButton("Cappuccino");
	private JButton bDr2 = new JButton("Latte");
	private JButton bDr3 = new JButton("Mocha");
	private JButton bDr4 = new JButton("4");
	private JButton bDr5 = new JButton("5");
	private JButton bDr6 = new JButton("6");
	private JButton bDr7 = new JButton("7");
	private JButton bDr8 = new JButton("8");
	private JButton bDr9 = new JButton("9");

	// milk type
	private JLabel milkLabel = new JLabel("Milk");
	private JButton bMilk1 = new JButton("2%");
	private JButton bMilk2 = new JButton("Nonfat");
	private JButton bMilk3 = new JButton("Whole");
	private JButton bMilk4 = new JButton("Soy"); // set a different color

	// syrup type
	private JLabel syrLabel = new JLabel("Syrup");
	private JButton bSyr1 = new JButton("Caramel");
	private JButton bSyr2 = new JButton("Hazelnut");
	private JButton bSyr3 = new JButton("Mocha");
	private JButton bSyr4 = new JButton("Peppermint");
	private JButton bSyr5 = new JButton("Vanilla");
	private JButton bSyr6 = new JButton("White Mocha");

	// previous orders
	private JButton bOrd1 = new JButton("Previous order 1");
	private JButton bOrd2 = new JButton("Previous order 2");
	private JButton bOrd3 = new JButton("Previous order 3");
	private JButton bOrd4 = new JButton("Previous order 4");
	private JButton bOrd5 = new JButton("Previous order 5");
	private JButton bOrd6 = new JButton("Previous order 6");
	private JButton bOrd7 = new JButton("Previous order 7");
	private JButton bOrd8 = new JButton("Previous order 8");

	// numbers
	private JButton b0 = new JButton("0");
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton bDec = new JButton(".");
	private JButton bClr = new JButton("Clear");
	private JButton bBsp = new JButton("Backspace");
	private JButton bEnt = new JButton("Enter");

	// functions
	private JButton bReceipt = new JButton("Print receipt");
	private JButton bRef = new JButton("Refund");

	// milk button states
	private Boolean milkSelected = false;
	private String milkID = "";

	// syrup button states
	private Boolean syrSelected = false;
	private String syrID = "";

	// option panel
	private JTextArea optionTextArea = new JTextArea(milkID);
	private JScrollPane optionSP = new JScrollPane(optionTextArea);
	private JButton bNext = new JButton("Next Drink");

	// milk button states
	private Boolean drinkSelected = false;
	private String drinkID = "[DRINK]";

	// order panel
	private JTextArea orderTextArea = new JTextArea(
			"[list of orders goes here]");
	private JScrollPane orderSP = new JScrollPane(orderTextArea);
	private JButton bPay = new JButton("Confirm & Pay");

	// back button
	private JButton bBack = new JButton("Back");

	// screen label
	private JLabel screenLabel = new JLabel("", JLabel.CENTER);

	// ARRAYS
	private JButton[] tabsArr = { bSel, bFood, bPrev };
	private JButton[] sizeArr = { bSmall, bMed, bLarge };
	private JButton[] milkArr = { bMilk1, bMilk2, bMilk3, bMilk4 };
	private JButton[] syrArr = { bSyr1, bSyr2, bSyr3, bSyr4, bSyr5, bSyr6 };
	private JButton[] drinkArr = { bDr1, bDr2, bDr3, bDr4, bDr5, bDr6, bDr7,
			bDr8, bDr9 };
	private JButton[] orderArr = { bOrd1, bOrd2, bOrd3, bOrd4, bOrd5, bOrd6,
			bOrd7, bOrd8 };
	private JButton[] funcArr = { bReceipt, bRef };
	private JButton[] numArr = { b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDec };

	// PAYMENT
	private String payAmt = new String("");

	private JTextField payField = new JTextField(payAmt);
	Font font36 = new Font("Arial", Font.ROMAN_BASELINE, 36);
	Font font24 = new Font("Arial", Font.ROMAN_BASELINE, 24);
	private JPanel numGrid = new JPanel();

	// payment dialog
	String change = new String("$ XX.XX");
	JLabel changeDue = new JLabel("Change Due: " + change);
	JButton closeDrawer = new JButton("Close register");

	// MODES
	int screen; // 0 = selection; 1 = payment; 2 = previous order; 3 = refund

	int selectScreen; // 0 = customizations; 1 = base drinks

	// CONSTRUCTOR
	public MainTest() {
		screen = 0;
		selectScreen = 0;

		// TODO: register action listeners for the buttons
		bDrink.addActionListener(this);
		bFood.addActionListener(this);
		bSel.addActionListener(this);
		bPrev.addActionListener(this);
		bPay.addActionListener(this);

		createGUI();
	}

	private void showDialog() {
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(500, 400);
		dialog.setVisible(true);

		dialog.setLocationRelativeTo(frame);
		dialog.setLocation(WIDTH / 2 - dialog.getWidth() / 2, HEIGHT / 2
				- dialog.getHeight() / 2);

		Container c = dialog.getContentPane();
		c.setLayout(null);

		changeDue.setFont(font36);
		Dimension size = changeDue.getPreferredSize();
		changeDue.setBounds(c.getWidth() / 2 - size.width / 2, c.getHeight()
				/ 4 - size.height / 2, size.width, size.height);
		c.add(changeDue);

		closeDrawer.setFont(font24);
		closeDrawer.setPreferredSize(new Dimension(c.getWidth() / 2, c
				.getHeight() / 3));
		Dimension size1 = closeDrawer.getPreferredSize();
		closeDrawer.setBounds(c.getWidth() / 2 - size1.width / 2, c.getHeight()
				* 2 / 3 - size1.height / 2, size1.width, size1.height);
		c.add(closeDrawer);

		closeDrawer.addActionListener(closeDialog);

	}

	Action closeDialog = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
			screen = 0;
			updateScreen();

		}
	};

	private void showCustomScreen() {
		Container c = frame.getContentPane();
		Insets insets = frame.getInsets();
		c.setLayout(null);

		syrLabel.setBounds(20, HEIGHT * 3 / 5 - 50 + tabHeight / 2, 50, 50);
		c.add(syrLabel);
		// set up the syrup grid panel
		JPanel syrGrid = new JPanel();
		syrGrid.setLayout(LAYOUT_STYLE_SIX_GRID);
		syrGrid.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT / 2));
		Dimension gridSize2 = syrGrid.getPreferredSize();
		syrGrid.setBounds(0 + insets.left, HEIGHT * 3 / 5 + tabHeight / 2
				+ insets.top, gridSize2.width, gridSize2.height);
		c.add(syrGrid);
		// add buttons to grid
		for (int i = 0; i < syrArr.length; i++) {
			JButton tempSyr = syrArr[i];
			tempSyr.setPreferredSize(new Dimension(WIDTH / 20, tabHeight / 2));
			Dimension size = tempSyr.getPreferredSize();
			syrGrid.add(tempSyr);
			tempSyr.addActionListener(this);
		}

		milkLabel.setBounds(20, HEIGHT / 3 - 50, 50, 50);
		c.add(milkLabel);
		// set up the milk grid panel dimensions and location
		JPanel milkGrid = new JPanel();
		milkGrid.setLayout(LAYOUT_STYLE_FOUR_GRID);
		milkGrid.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT / 3));
		Dimension gridSize = milkGrid.getPreferredSize();
		milkGrid.setBounds(0 + insets.left, HEIGHT / 3 + insets.top,
				gridSize.width, gridSize.height);
		c.add(milkGrid);
		// add buttons to grid
		for (int i = 0; i < milkArr.length; i++) {
			JButton tempMilk = milkArr[i];
			tempMilk.setPreferredSize(new Dimension(WIDTH / 20, tabHeight / 2));
			Dimension milkSize = tempMilk.getPreferredSize();
			milkGrid.add(tempMilk);
			tempMilk.addActionListener(this);
		}

		// [TOP] TAB BAR
		for (int i = 0; i < tabsArr.length; i++) {
			JButton tempTab = tabsArr[i];
			tempTab.setPreferredSize(new Dimension(WIDTH / 3, tabHeight));
			Dimension size = tempTab.getPreferredSize();
			tempTab.setBounds(i * WIDTH / 3 + insets.left, 0 + insets.top,
					size.width, size.height);
			c.add(tempTab);
			tempTab.addActionListener(this);
		}

		// [SEL TOP] DRINK NAME & SIZE
		// drink name
		bDrink.setPreferredSize(new Dimension(150, 70));
		Dimension drinkSize = bDrink.getPreferredSize();
		bDrink.setBounds(WIDTH / 20, tabHeight * 4 / 3, drinkSize.width,
				drinkSize.height);
		c.add(bDrink);

		// size buttons
		for (int i = 0; i < sizeArr.length; i++) {
			JButton tempButton = sizeArr[i];
			tempButton.setPreferredSize(new Dimension(100, 30));
			Dimension size = tempButton.getPreferredSize();
			tempButton.setBounds(WIDTH / 4 + i * size.width, tabHeight + 50
					+ insets.top, size.width, size.height);
			c.add(tempButton);
		}

		// [OPTIONS] ORDER CUSTOMIZATIONS LIST
		// option pane
		optionSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight
				* 3 / 2));
		Dimension optSize = optionSP.getPreferredSize();
		optionSP.setBounds(WIDTH * 3 / 5 + insets.left, tabHeight + insets.top,
				optSize.width, optSize.height - tabHeight);
		c.add(optionSP);
		// next drink button
		bNext.setPreferredSize(new Dimension(WIDTH / 5, tabHeight));
		Dimension nextSize = bNext.getPreferredSize();
		bNext.setBounds(WIDTH * 3 / 5 + insets.left, HEIGHT - tabHeight * 3 / 2
				+ insets.top, nextSize.width, nextSize.height);
		c.add(bNext);
		bNext.addActionListener(this);

		optionTextArea.setFont(font24);
		optionTextArea.setText(drinkID.toUpperCase() + newline + milkID
				+ newline + syrID);

		// [RIGHT] ORDER LIST
		// confirm & pay button
		bPay.setPreferredSize(new Dimension(WIDTH / 5, 2 * tabHeight));
		Dimension butSize = bPay.getPreferredSize();
		bPay.setBounds(WIDTH * 4 / 5 + insets.left, HEIGHT - tabHeight * 5 / 2
				+ insets.top, butSize.width, butSize.height);
		c.add(bPay);

		orderSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight
				* 3 / 2));
		Dimension ordSize = orderSP.getPreferredSize();
		orderSP.setBounds(WIDTH * 4 / 5 + insets.left, tabHeight + insets.top,
				ordSize.width, ordSize.height);
		c.add(orderSP);

	}

	private void showDrinkScreen() {
		Container c = frame.getContentPane();
		Insets insets = frame.getInsets();
		c.setLayout(null);

		// display base drink buttons in a grid
		// set up the milk grid panel dimensions and location
		JPanel drinkGrid = new JPanel();
		drinkGrid.setLayout(LAYOUT_STYLE_NINE_GRID);
		drinkGrid.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT / 2));
		Dimension gridSize = drinkGrid.getPreferredSize();
		drinkGrid.setBounds(0 + insets.left, HEIGHT / 3 + insets.top,
				gridSize.width, gridSize.height);
		c.add(drinkGrid);
		// add buttons to grid
		for (int i = 0; i < drinkArr.length; i++) {
			JButton tempDrink = drinkArr[i];
			tempDrink
					.setPreferredSize(new Dimension(WIDTH / 20, tabHeight / 2));
			Dimension size = tempDrink.getPreferredSize();
			drinkGrid.add(tempDrink);
			tempDrink.addActionListener(this);
		}

		// [TOP] TAB BAR
		for (int i = 0; i < tabsArr.length; i++) {
			JButton tempTab = tabsArr[i];
			tempTab.setPreferredSize(new Dimension(WIDTH / 3, tabHeight));
			Dimension size = tempTab.getPreferredSize();
			tempTab.setBounds(i * WIDTH / 3 + insets.left, 0 + insets.top,
					size.width, size.height);
			c.add(tempTab);
			tempTab.addActionListener(this);
		}

		// [SEL TOP] DRINK NAME & SIZE
		// drink name
		bDrink.setPreferredSize(new Dimension(150, 70));
		Dimension drinkSize = bDrink.getPreferredSize();
		bDrink.setBounds(WIDTH / 20, tabHeight * 4 / 3, drinkSize.width,
				drinkSize.height);
		c.add(bDrink);

		// size buttons
		for (int i = 0; i < sizeArr.length; i++) {
			JButton tempButton = sizeArr[i];
			Dimension size = tempButton.getPreferredSize();
			tempButton.setBounds(WIDTH / 4 + i * size.width, tabHeight + 50
					+ insets.top, size.width, size.height);
			c.add(tempButton);
		}

		// [OPTIONS] ORDER CUSTOMIZATIONS LIST
		// option pane
		optionSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight
				* 3 / 2));
		Dimension optSize = optionSP.getPreferredSize();
		optionSP.setBounds(WIDTH * 3 / 5 + insets.left, tabHeight + insets.top,
				optSize.width, optSize.height - tabHeight);
		c.add(optionSP);
		// next drink button
		bNext.setPreferredSize(new Dimension(WIDTH / 5, tabHeight));
		Dimension nextSize = bNext.getPreferredSize();
		bNext.setBounds(WIDTH * 3 / 5 + insets.left, HEIGHT - tabHeight * 3 / 2
				+ insets.top, nextSize.width, nextSize.height);
		c.add(bNext);

		optionTextArea.setFont(font24);
		optionTextArea.setText(drinkID.toUpperCase() + newline + milkID
				+ newline + syrID);

		// [RIGHT] ORDER LIST
		// confirm & pay button
		bPay.setPreferredSize(new Dimension(WIDTH / 5, 2 * tabHeight));
		Dimension butSize = bPay.getPreferredSize();
		bPay.setBounds(WIDTH * 4 / 5 + insets.left, HEIGHT - tabHeight * 5 / 2
				+ insets.top, butSize.width, butSize.height);
		c.add(bPay);

		orderSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight
				* 3 / 2));
		Dimension ordSize = orderSP.getPreferredSize();
		orderSP.setBounds(WIDTH * 4 / 5 + insets.left, tabHeight + insets.top,
				ordSize.width, ordSize.height);
		c.add(orderSP);

	}

	public void showPaymentScreen() {
		Container c = frame.getContentPane();
		Insets insets = frame.getInsets();
		c.setLayout(null);

		// order list
		// confirm & pay button
		bPay.setPreferredSize(new Dimension(WIDTH / 5, 2 * tabHeight));
		Dimension butSize = bPay.getPreferredSize();
		bPay.setBounds(WIDTH * 4 / 5 + insets.left, HEIGHT - tabHeight * 5 / 2
				+ insets.top, butSize.width, butSize.height);
		c.add(bPay);

		orderSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight
				* 3 / 2));
		Dimension ordSize = orderSP.getPreferredSize();
		orderSP.setBounds(WIDTH * 4 / 5 + insets.left, tabHeight + insets.top,
				ordSize.width, ordSize.height);
		c.add(orderSP);

		// entry field and number buttons
		JPanel payWindow = new JPanel();
		payWindow.setLayout(LAYOUT_STYLE_BORDER);
		payWindow.setSize(500, 700);
		Dimension paySize = payWindow.getSize();
		payWindow.setBounds(WIDTH / 4, HEIGHT / 2 - paySize.height / 2
				+ tabHeight / 4, paySize.width, paySize.height);
		c.add(payWindow);

		payField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		payField.setFont(font36);
		payField.setPreferredSize(new Dimension(300, 50));
		Dimension fieldSize = payField.getSize();
		payField.setBounds(0, 0, fieldSize.width, fieldSize.height);
		payWindow.add(payField, BorderLayout.PAGE_START);
		payField.setText(payAmt);

		for (int i = 0; i < numArr.length; i++) {
			JButton tempNum = numArr[i];
			tempNum.setFont(font24);
			tempNum.addActionListener(this);
		}

		numGrid.setLayout(LAYOUT_STYLE_EIGHT_GRID);
		numGrid.add(b7);
		numGrid.add(b8);
		numGrid.add(b9);
		numGrid.add(b4);
		numGrid.add(b5);
		numGrid.add(b6);
		numGrid.add(b1);
		numGrid.add(b2);
		numGrid.add(b3);
		numGrid.add(bClr);
		numGrid.add(b0);
		numGrid.add(bDec);
		payWindow.add(numGrid, BorderLayout.CENTER);

		bBsp.setPreferredSize(new Dimension(200, 150));
		Dimension bspSize = bBsp.getPreferredSize();
		bBsp.setBounds(payWindow.getX() + payWindow.getWidth() + 50,
				payWindow.getY() + 50, bspSize.width, bspSize.height);
		c.add(bBsp);
		bBsp.addActionListener(this);
		bClr.addActionListener(this);

		// [TOP] TAB BAR
		for (int i = 0; i < tabsArr.length; i++) {
			JButton tempTab = tabsArr[i];
			tempTab.setPreferredSize(new Dimension(WIDTH / 3, tabHeight));
			Dimension size1 = tempTab.getPreferredSize();
			tempTab.setBounds(i * WIDTH / 3 + insets.left, 0 + insets.top,
					size1.width, size1.height);
			c.add(tempTab);
			tempTab.addActionListener(this);
		}
	}

	public void showPreviousOrderScreen() {

		System.out.println("Previous Order Screen Showing");
		Container c = frame.getContentPane();
		Insets insets = frame.getInsets();
		c.setLayout(null);

		// [TOP] TAB BAR
		for (int i = 0; i < tabsArr.length; i++) {
			JButton tempTab = tabsArr[i];
			tempTab.setPreferredSize(new Dimension(WIDTH / 3, tabHeight));
			Dimension size1 = tempTab.getPreferredSize();
			tempTab.setBounds(i * WIDTH / 3 + insets.left, 0 + insets.top,
					size1.width, size1.height);
			c.add(tempTab);
			tempTab.addActionListener(this);
		}

		// grid of previous order buttons
		JPanel ordGrid = new JPanel();
		ordGrid.setLayout(LAYOUT_STYLE_EIGHT_GRID);
		ordGrid.setPreferredSize(new Dimension(WIDTH * 3 / 4, HEIGHT / 2));
		Dimension gridSize = ordGrid.getPreferredSize();
		ordGrid.setBounds(0 + insets.left, 2 * tabHeight + insets.top,
				gridSize.width, gridSize.height);
		c.add(ordGrid);

		// add buttons to grid
		for (int i = 0; i < orderArr.length; i++) {
			JButton tempOrder = orderArr[i];
			tempOrder
					.setPreferredSize(new Dimension(WIDTH / 20, tabHeight / 2));
			Dimension buttonSize = tempOrder.getPreferredSize();
			ordGrid.add(tempOrder);
		}

		// grid of functions
		JPanel funcGrid = new JPanel();
		funcGrid.setLayout(LAYOUT_STYLE_EIGHT_GRID);
		funcGrid.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT / 2));
		Dimension funcSize = funcGrid.getPreferredSize();
		funcGrid.setBounds(WIDTH - funcSize.width + insets.left, 2 * tabHeight
				+ insets.top, funcSize.width, funcSize.height);
		c.add(funcGrid);
		for (int i = 0; i < funcArr.length; i++) {
			JButton tempFunc = funcArr[i];
			tempFunc.setPreferredSize(new Dimension(WIDTH / 20, tabHeight / 2));
			Dimension buttonSize = tempFunc.getPreferredSize();
			tempFunc.setBackground(Color.orange);
			funcGrid.add(tempFunc);
		}
	}

	private void createGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateScreen();
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}

	private void updateScreen() {
		Container c = frame.getContentPane();
		Insets insets = frame.getInsets();
		c.setLayout(null);

		c.removeAll();

		if (screen == 0) {
			if (selectScreen == 0) {
				showCustomScreen();
			} else if (selectScreen == 1) {
				showDrinkScreen();
			}
		} else if (screen == 1) {
			showPaymentScreen();
		} else if (screen == 2) {
			showPreviousOrderScreen();
		} else if (screen == 3) {

		} else if (screen == 4) {
			// showPaymentScreen();
		}
		c.validate();
		c.repaint();

		System.out.println("/////////////////////////////////////////");
		System.out.println("Screen Updated");
		System.out.println("Current Screen: " + screen);
		System.out.println("Current Selection Screen: " + selectScreen);
	}

	public void actionPerformed(ActionEvent e) {
		// insert numbers into payment screen text field
		for (int i = 0; i < numArr.length; i++) {
			JButton tempNum = numArr[i];
			if (e.getSource() == tempNum) {
				payAmt += tempNum.getLabel();
				updateScreen();
			}
			tempNum.removeActionListener(this);
		}

		// backspace
		if (e.getSource() == bBsp) {	
			payAmt = payAmt.substring(0, payAmt.length()-1);
			updateScreen();
			bBsp.removeActionListener(this);
		}
		
		if (e.getSource() == bClr) {
			payAmt = "";
		}
		
		// add drinks
		for (int i = 0; i < drinkArr.length; i++) {
			JButton tempDrink = drinkArr[i];
			if (e.getSource() == tempDrink) {
				if (drinkSelected == false) {
					drinkID = tempDrink.getLabel() + newline;
					drinkSelected = true;
				} else if (drinkSelected == true) {
					drinkID = tempDrink.getLabel();
				}

				updateScreen();
			}
			tempDrink.removeActionListener(this);
		}

		// add customizations to the list
		for (int i = 0; i < milkArr.length; i++) {
			JButton tempMilk = milkArr[i];
			if (e.getSource() == tempMilk) {
				if (milkSelected == false) {
					milkID = tempMilk.getLabel() + newline;
					milkSelected = true;
				} else if (milkSelected == true) {
					milkID = tempMilk.getLabel();
				}

				updateScreen();
			}
			tempMilk.removeActionListener(this);
		}

		for (int i = 0; i < syrArr.length; i++) {
			JButton tempSyr = syrArr[i];
			if (e.getSource() == tempSyr) {
				if (syrSelected == false) {
					syrID = tempSyr.getLabel() + newline;
					syrSelected = true;
				} else if (syrSelected == true) {
					syrID = tempSyr.getLabel();
				}

				updateScreen();
			}
			tempSyr.removeActionListener(this);
		}

		if (e.getSource() == bDrink) {

			if (selectScreen == 0) {
				bDrink.setLabel("Options");
				selectScreen = 1;
			} else if (selectScreen == 1) {
				bDrink.setLabel("Drink");
				selectScreen = 0;
			}
			updateScreen();
		}

		if (e.getSource() == bNext) {
			selectScreen = 0;
			updateScreen();
		}

		if (e.getSource() == bPay) {
			if (screen == 0) {
				screen = 1;
			} else if (screen == 1) {
				showDialog();
			}

			updateScreen();
		}

		if (e.getSource() == bPrev) {
			screen = 2;
			bPrev.removeActionListener(this);
			updateScreen();
		}
		if (e.getSource() == bSel) {
			screen = 0;
			selectScreen = 0;
			bSel.removeActionListener(this);
			updateScreen();
		}
	}

	public static void main(String[] args) {
		MainTest pos = new MainTest();
	}

}