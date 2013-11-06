import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class JRectSlider extends JComponent {
	private static final String uiClassID = "RectSliderUI";
	
	public void setUI(RectSliderUI ui) {
		super.setUI(ui);
	}
	
	public void updateUI(){
		if (UIManager.get(getUIClassID()) != null) {
			setUI((RectSliderUI) UIManager.getUI(this));
		} else {
			setUI(new DefaultRectSliderUI());
		}
	}
	
	public RectSliderUI getUI(){
		return (RectSliderUI) ui;
	}
	
	public String getUIClassID() {
		return uiClassID;
	}
	
	// Model
	protected RectRangeModel model;
	
	
	// Component Variable Storage
	private String displayValueText;
	private Dimension size;
	
	public JRectSlider(Dimension inpSize){
		//TODO fill with an import for value storage and display
		this.model = new DefaultRectRangeModel();
		this.model.setSize(inpSize);
		this.updateUI();
	}
	
	public String getDisplayValue() {
		return this.displayValueText;
	}
	
	public void setDisplayValue(String value){
		this.displayValueText = value;
	}
	
	public double getValue() {
		return this.model.getDisplayValue();
	}

	public RectRangeModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
