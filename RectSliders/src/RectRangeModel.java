import java.awt.Dimension;

import javax.swing.event.ChangeListener;

public interface RectRangeModel {

	double getDisplayValue();

	void setSize(Dimension inpSize);

	void checkValueIsAdjusting(boolean b);

	void addChangeLisenter(ChangeListener rectSliderChangeListener);

}
