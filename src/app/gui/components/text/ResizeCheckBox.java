package app.gui.components.text;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;

public class ResizeCheckBox extends JCheckBox {

	private static final long serialVersionUID = 7548908287463406291L;

	private boolean resize = false;
	
	public ResizeCheckBox() {
		setMnemonic(KeyEvent.VK_R);
		setText("Resize?");
		addItemListener(new ResizeCheckBoxItemListener());
	}
	
	public boolean getResize() {
		return resize;
	}
	
	public class ResizeCheckBoxItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if (e.getItemSelectable() == this) {
				resize = (e.getStateChange() == ItemEvent.SELECTED);
			}
		}
	}
	
	public void clear() {
		resize = false;
		setSelected(false);
	}
	
}
