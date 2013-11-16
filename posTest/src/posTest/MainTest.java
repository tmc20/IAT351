// TODO: base drink button grid; screen switching when you press 'drink' button

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
	private static final GridLayout LAYOUT_STYLE_FOUR_GRID = new GridLayout(3,
			1);
	private static final GridLayout LAYOUT_STYLE_SIX_GRID = new GridLayout(5, 1);

	// COMPONENTS
	// top tabs
	private JButton bSel = new JButton("Selection");
	private JButton bFood = new JButton("Food");
	private JButton bPrev = new JButton("Previous Orders");
	private int tabHeight = HEIGHT / 10;

	// drink name label
	private String drinkNameText = new String("[DRINK]");
	private JLabel drinkName = new JLabel("testing");
	private JTextField textField = new JTextField(20);
	private JButton drinkButton = new JButton(drinkNameText);

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

	// milk type
	private JButton bMilk1 = new JButton("2%");
	private JButton bMilk2 = new JButton("Nonfat");
	private JButton bMilk3 = new JButton("Whole");
	private JButton bMilk4 = new JButton("Soy"); // set a different color

	// syrup type
	private JButton bSyr1 = new JButton("Caramel");
	private JButton bSyr2 = new JButton("Hazelnut");
	private JButton bSyr3 = new JButton("Mocha");
	private JButton bSyr4 = new JButton("Peppermint");
	private JButton bSyr5 = new JButton("Vanilla");
	private JButton bSyr6 = new JButton("White Mocha");

	// option panel
	private JScrollPane optionSP = new JScrollPane();
	private JButton bNext = new JButton("Next Drink");

	// order panel
	private JTextArea orderTextArea = new JTextArea();
	private JScrollPane orderSP = new JScrollPane(orderTextArea);

	// ARRAYS
	private JButton[] tabsArr = { bSel, bFood, bPrev };
	private JButton[] sizeArr = { bSmall, bMed, bLarge };
	private JButton[] milkArr = { bMilk1, bMilk2, bMilk3, bMilk4 };
	private JButton[] syrArr = { bSyr1, bSyr2, bSyr3, bSyr4, bSyr5, bSyr6 };
	private JButton[] drinksArr = { b1, b2, b3, b4, b5, b6, b7, b8, b9 };

	// MODES
	int screen; // 0 = selection; 1 = payment; 2 = previous order; 3 = refund
	int selectScreen; // 0 = customizations; 1 = base drinks

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

		// [RIGHT] ORDER LIST
		orderSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT - tabHeight
				* 3 / 2));
		Dimension ordSize = orderSP.getPreferredSize();
		orderSP.setBounds(WIDTH * 4 / 5 + insets.left, tabHeight + insets.top,
				ordSize.width, ordSize.height);
		c.add(orderSP);
	}

	private void createAndShowGUI() {
		JFrame frame = new JFrame("Demo Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// addComponentsToPane(frame.getContentPane());
		updateScreen(frame.getContentPane());

		Insets insets = frame.getInsets();
		frame.setSize(WIDTH, HEIGHT);

		frame.setVisible(true);
	}

	private void updateScreen(Container c) {
		c.setLayout(null);
		Insets insets = c.getInsets();

		switch (screen) {
		// selection/ready screen
		case 0: {

			// [SEL BOT] BASE DRINK & CUSTOMIZATION BUTTONS
			switch (selectScreen) {

			case 0: {
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
					tempMilk.setPreferredSize(new Dimension(WIDTH / 20,
							tabHeight / 2));
					Dimension size = tempMilk.getPreferredSize();
					milkGrid.add(tempMilk);
				}

				// //////////////////////////////////////////////////////////////////////

				// set up the syrup grid panel
				JPanel syrGrid = new JPanel();
				syrGrid.setLayout(LAYOUT_STYLE_SIX_GRID);
				syrGrid.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT / 2));
				Dimension gridSize2 = syrGrid.getPreferredSize();
				syrGrid.setBounds(0 + insets.left, HEIGHT * 3 / 5 + insets.top,
						gridSize2.width, gridSize2.height);
				c.add(syrGrid);
				// add buttons to grid
				for (int i = 0; i < syrArr.length; i++) {
					JButton tempSyr = syrArr[i];
					tempSyr.setPreferredSize(new Dimension(WIDTH / 20,
							tabHeight / 2));
					Dimension size = tempSyr.getPreferredSize();
					syrGrid.add(tempSyr);
				}
				break;
			}

			case 1: {
				// display base drink buttons in a grid

				break;
			}
			}

			// [TOP] TAB BAR
			for (int i = 0; i < tabsArr.length; i++) {
				JButton tempTab = tabsArr[i];
				tempTab.setPreferredSize(new Dimension(WIDTH / 3, tabHeight));
				Dimension size = tempTab.getPreferredSize();
				tempTab.setBounds(i * WIDTH / 3 + insets.left, 0 + insets.top,
						size.width, size.height);

				c.add(tempTab);
			}

			// [SEL TOP] DRINK NAME & SIZE
			// drink name
			drinkButton.setPreferredSize(new Dimension(150,70));
			Dimension drinkSize = drinkButton.getPreferredSize();
			drinkButton.setBounds(WIDTH / 20, tabHeight * 4 / 3, drinkSize.width, drinkSize.height);
			c.add(drinkButton);			
			
			//drinkName.setBounds(WIDTH / 20, tabHeight * 4 / 3, 50, 50);
			// c.add(drinkName);
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
			optionSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT
					- tabHeight * 3 / 2));
			Dimension optSize = optionSP.getPreferredSize();
			optionSP.setBounds(WIDTH * 3 / 5 + insets.left, tabHeight
					+ insets.top, optSize.width, optSize.height - tabHeight);
			c.add(optionSP);
			// next drink button
			bNext.setPreferredSize(new Dimension(WIDTH / 5, tabHeight));
			Dimension nextSize = bNext.getPreferredSize();
			bNext.setBounds(WIDTH * 3 / 5 + insets.left, HEIGHT - tabHeight * 3
					/ 2 + insets.top, nextSize.width, nextSize.height);
			c.add(bNext);

			// [RIGHT] ORDER LIST
			orderSP.setPreferredSize(new Dimension(WIDTH / 5, HEIGHT
					- tabHeight * 3 / 2));
			Dimension ordSize = orderSP.getPreferredSize();
			orderSP.setBounds(WIDTH * 4 / 5 + insets.left, tabHeight
					+ insets.top, ordSize.width, ordSize.height);
			c.add(orderSP);

			break;
		}

		// payment screen
		case 1: {
			break;
		}

		// previous order screen
		case 2: {
			break;
		}
		// refund screen
		case 3: {
			break;
		}
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");
		// TODO: get the drink name from the source button
		drinkButton.setText(drinkNameText);
	}

	public static void main(String[] args) {
		MainTest pos = new MainTest();
	}

}
