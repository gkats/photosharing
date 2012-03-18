package app.gui.components.buttons;

import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

public class BrowseImagesButton extends JButton {

	private static final long serialVersionUID = 7385981425944754285L;

	public BrowseImagesButton() {
		setMnemonic(KeyEvent.VK_A);
		setText("Add");
		GroupLayout browseImagesButtonLayout 
			= new GroupLayout((JComponent) this);
		browseImagesButtonLayout.setVerticalGroup(
				browseImagesButtonLayout.createParallelGroup());
		browseImagesButtonLayout.setHorizontalGroup(
				browseImagesButtonLayout.createParallelGroup());
	}
}
