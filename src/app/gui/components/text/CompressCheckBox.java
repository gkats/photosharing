package app.gui.components.text;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;

public class CompressCheckBox extends JCheckBox {

	private static final long serialVersionUID = 291033021236062178L;

	private boolean compress;
	
	public CompressCheckBox() {
		setText("Compress?");
		setMnemonic(KeyEvent.VK_C);
		addItemListener(new CompressCheckBoxItemListener());
	}
	
	public boolean getCompress() {
		return compress;
	}
	
	public class CompressCheckBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getItemSelectable() instanceof CompressCheckBox) {
				compress = (e.getStateChange() == ItemEvent.SELECTED);
			}
		}
	}
	
	public void clear() {
		compress = false;
		setSelected(false);
	}
}
