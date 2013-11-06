import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;

public class DefaultRectSliderUI extends RectSliderUI {
	
	protected JRectSlider rectSlider;
	protected String displayValueText;
	protected MouseAdapter mouseListener;
	protected MouseMotionListener mouseMotionListener;
	protected ChangeListener rectSliderChangeListener;
	//TODO Check if needed 
	protected double rectX,rectY,rectW,rectH;
	protected Graphics2D rect1,rect2;
	
	
	public DefaultRectSliderUI(){
		
	}
	
	public static ComponentUI createUI(JComponent c){
		return new DefaultRectSliderUI();
	}
	
	public void installUI(JComponent c){
		this.rectSlider = (JRectSlider) c;
		installDefaults();
		installComponents();
		installListeners();
		c.setLayout(createLayoutManager());
		c.setBorder(new EmptyBorder(1,1,1,1));
	}
	
	public void uninstallUI(JComponent c){
		c.setLayout(null);
		uninstallListeners();
		uninstallComponents();
		uninstallDefaults();
		this.rectSlider = null;
	}

	private LayoutManager createLayoutManager() {

		return null;
	}

	private void installListeners() {
		this.mouseListener = new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
			public void mouseReleased(MouseEvent e){
				rectSlider.getModel().checkValueIsAdjusting(false);
			}
			
			public void mousePressed(MouseEvent e){
				rectSlider.getModel().checkValueIsAdjusting(true);
				double x = e.getX();
				double y = e.getY();
				double tempValue = computeDisplayValue(x,y);
				double finalPercentDisplayValue = tempValue * 10;
				rectSlider.setDisplayValue(String.valueOf(finalPercentDisplayValue));
				//TODO See if new solution works instead. (For drawing our second rectangle)
				
			}
		};
		
		this.mouseMotionListener = new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				rectSlider.getModel().checkValueIsAdjusting(true);
				double x = e.getX();
				double y = e.getY();
				double tempValue = computeDisplayValue(x,y);
				double finalPercentDisplayValue = tempValue * 10;
				rectSlider.setDisplayValue(String.valueOf(finalPercentDisplayValue));
			}
		};
		
		this.rectSliderChangeListener = new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				rectSlider.repaint();
			}
		};
		this.rectSlider.getModel().addChangeLisenter(this.rectSliderChangeListener);
	}

	private void installComponents() {
		
	}

	private void installDefaults() {
		// TODO Auto-generated method stub
		
	}

	private void uninstallDefaults() {
		// TODO Auto-generated method stub
		
	}

	private void uninstallComponents() {
		// TODO Auto-generated method stub
		
	}

	private void uninstallListeners() {
		// TODO Auto-generated method stub
		
	}
	
	/* LOGIC: we take the mouse X and Y coordinates passed by the UI delegate
	 * 1) check if mouseX and mouseY are inside the rectSlider's bounding box
	 * 2) if yes, calculate a value based on how high/low the mouseY is on the rectSlider, kind of like a ratio
	 * 3) set the model value to this value, the UI will refer to this value
	 * 4) fire a change event
	 * */
	public double computeDisplayValue(double mouseX, double mouseY) {
		double value,mouseX,mouseY;
		mouseX = this.mouseX;
		mouseY = this.mouseY;

		// check if mouseX is within component x's bounding box
		if (mouseX > this.rectSlider.getX() && mouseX < this.rectSlider.getX() + this.rectSlider.getWidth() 
				&& mouseY > this.rectSlider.getY() && mouseY < this.rectSlider.getY() + this.rectSlider.getHeight()) {
			// if yes, convert the mouseY to the value
			value = mouseY / (this.rectSlider.getY() + this.rectSlider.getHeight()); // from the processing example
		}
		return value;
	}
	
	// we want a rectangle: tall/vertical orientation
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
		this.paintSquares(g,c);
		this.paintValue(g, c);
	}
	
private void paintSquares(Graphics g, JComponent c) {
		double percentHeight = c.getHeight() / Double.parseDouble(rectSlider.getDisplayValue());
		Graphics2D r1 = (Graphics2D)g;
		Graphics2D r2 = (Graphics2D)g;
		r2.draw(new Rectangle2D.Double(0, 0, c.getWidth(), c.getHeight()));
		r1.draw(new Rectangle2D.Double(0, 0,c.getWidth(), percentHeight));
		// TODO try percentheight as the method to draw second square? its janky
	}

	protected void paintValue(Graphics g, JComponent c) {
		//TODO display the percentage filled (the number on the bottom.)
	}

	
	public Dimension preferredLayoutSize(Container c) {
		int width = 0;
		int height = 0;

		// JRectSlider rectSlider = (JRectSlider) c;

		// the preferred height is the height of the container [minus any borders]
		height = c.getHeight();

		// the preferred width is (arbitrary?)
		width = c.getWidth() / 10;

		return new Dimension(width, height);
	}
}
