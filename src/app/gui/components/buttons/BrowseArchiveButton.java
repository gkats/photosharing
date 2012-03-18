package app.gui.components.buttons;

import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

public class BrowseArchiveButton extends JButton {

	private static final long serialVersionUID = -3238782003214343436L;

	public BrowseArchiveButton() {
		setText("Browse");
		setMnemonic(KeyEvent.VK_B);
		GroupLayout browseArchiveButtonLayout 
			= new GroupLayout((JComponent) this);
		browseArchiveButtonLayout.setVerticalGroup(
				browseArchiveButtonLayout.createParallelGroup());
		browseArchiveButtonLayout.setHorizontalGroup(
				browseArchiveButtonLayout.createParallelGroup());
	}
}
