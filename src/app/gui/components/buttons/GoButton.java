package app.gui.components.buttons;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import app.gui.actions.GoAction;

public class GoButton extends JButton {

	private static final long serialVersionUID = 4456573222798840911L;
	
	public GoButton() {
		setLayout(null);
		setText("Go");
		setSize(103, 34);
		setMnemonic(KeyEvent.VK_G);
		
		setAction(new GoAction(getText(), getMnemonic()));
	} 

}
