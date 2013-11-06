import java.awt.Dimension;

import javax.swing.BoundedRangeModel;
import javax.swing.event.*;

public class DefaultRectRangeModel implements RectRangeModel {

	protected EventListenerList listenerList = new EventListenerList();

	private boolean valueIsAdjusting = false;
	
	double mouseX, mouseY;
	double value;

	double rectX, rectY, rectW, rectH;

	// CONSTRUCTOR
	DefaultRectRangeModel() {
		value = 0;
	}



	public double getDisplayValue() {
		return value;
	}

	public void setValue() {
		
	}
	
	public void setSize(Dimension inpSize){
		rectW = inpSize.getWidth();
		rectH = inpSize.getHeight();
	}

	public void addChangeListener(ChangeListener l) {
		listenerList.add(ChangeListener.class, l);
	}

	public void removeChangeListener(ChangeListener l) {
		listenerList.remove(ChangeListener.class, l);
	}

	public void fireStateChanged() {
		ChangeEvent event = new ChangeEvent(this);
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == ChangeListener.class) {
				((ChangeListener) listeners[i + 1]).stateChanged(event);
			}
		}
	}
	
	public void checkValueIsAdjusting(boolean b) {
		if (this.valueIsAdjusting != b) {
			this.valueIsAdjusting = b;
			this.fireStateChanged();
		}
	}
	
	public boolean getValueIsAdjusting() {
		return valueIsAdjusting;
	}

	// ////////////////////////////////////////////////////////////// DON'T NEED

	public int getExtent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMaximum() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMinimum() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setExtent(int newExtent) {
		// TODO Auto-generated method stub

	}

	public void setMaximum(int newMaximum) {
		// TODO Auto-generated method stub

	}

	public void setMinimum(int newMinimum) {
		// TODO Auto-generated method stub

	}

	public void setRangeProperties(int value, int extent, int min, int max,
			boolean adjusting) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChangeLisenter(ChangeListener rectSliderChangeListener) {
		// TODO Auto-generated method stub
		
	}

}
