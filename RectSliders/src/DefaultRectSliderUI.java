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
	protected double rawValueOfY,rawValueOfX;
	protected double rectX,rectY,rectW,rectH,rect2Y;
	protected Graphics2D rect1,rect2;
	
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
				rectSlider.getModel().setValueIsAdjusting(false);
			}
			
			public void mousePressed(MouseEvent e){
				rectSlider.getModel().setValueIsAdjusting(true);
				double x = e.getX();
				double y = e.getY();
				model.computeDisplayValue(x,y);
				rectSlider.setDisplayValue(model.getDisplayValue().toString());
				//TODO Send computation to model to send back to graphics
			}
		};
		
		this.mouseMotionListener = new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				rectSlider.getModel().setValueIsAdjusting(true);
				double x = e.getX();
				double y = e.getY();
				model.computeDisplayValue(x,y);
				rectSlider.setDisplayValue(model.computeDisplayValue(x,y).toString());
				//TODO Send computation to model to send back to graphics for rect2
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
	
	public void paint(){
		
	}
}
