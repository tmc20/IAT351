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
			setUI(new BasicRectSliderUI());
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
	
	public JRectSlider(int inpSize){
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
	
	public RectRangeModel.Value getRawValue(){
		return this.model.getValue();
	}

	public RectRangeModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
