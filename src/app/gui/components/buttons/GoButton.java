package app.gui.components.buttons;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import app.gui.actions.GoAction;

public class GoButton extends JButton {

	private static final long serialVersionUID = 4456573222798840911L;
	
	public GoButton() {
		GroupLayout goButtonLayout = new GroupLayout((JComponent) this);
		setLayout(null);
		setText("Go");
		setSize(103, 34);
		goButtonLayout.setHorizontalGroup(goButtonLayout.createParallelGroup());
		goButtonLayout.setVerticalGroup(goButtonLayout.createParallelGroup());
		
		setAction(new GoAction());
	} 

}