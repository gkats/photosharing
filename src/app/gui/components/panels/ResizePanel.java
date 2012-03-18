package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import app.gui.components.text.ResizeCheckBox;

public class ResizePanel extends JPanel {

	private static final long serialVersionUID = -8764266885580996037L;
	
	private JCheckBox resizeCheckBox;
	private JLabel widthLabel;
	private JLabel heightLabel;
	private JTextField heightTextField;
	private JTextField widthTextField;
	
	public ResizePanel() {
		initGUI();
	}

	private void initGUI() {
		GroupLayout resizePanelLayout = new GroupLayout((JComponent) this);
		setLayout(resizePanelLayout);
		setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		
		resizeCheckBox = new ResizeCheckBox();
		widthLabel = new JLabel("Width:");
		widthTextField = new JTextField();
		heightLabel = new JLabel("Height:");
		heightTextField = new JTextField();
		
		resizePanelLayout.setHorizontalGroup(resizePanelLayout.createSequentialGroup()
		.addContainerGap()
		.addGroup(resizePanelLayout.createParallelGroup()
		    .addGroup(resizePanelLayout.createSequentialGroup()
		        .addGroup(resizePanelLayout.createParallelGroup()
		            .addComponent(widthLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
		            .addGroup(GroupLayout.Alignment.LEADING, resizePanelLayout.createSequentialGroup()
		                .addComponent(heightLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
		                .addGap(7)))
		        .addGroup(resizePanelLayout.createParallelGroup()
		            .addGroup(resizePanelLayout.createSequentialGroup()
		                .addComponent(heightTextField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
		                .addGap(0, 0, Short.MAX_VALUE))
		            .addComponent(widthTextField, GroupLayout.Alignment.LEADING, 0, 49, Short.MAX_VALUE)))
		    .addGroup(GroupLayout.Alignment.LEADING, resizePanelLayout.createSequentialGroup()
		        .addComponent(resizeCheckBox, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
		        .addGap(0, 30, Short.MAX_VALUE)))
		.addContainerGap(20, 20));
	resizePanelLayout.setVerticalGroup(resizePanelLayout.createSequentialGroup()
		.addContainerGap()
		.addComponent(resizeCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
		.addGroup(resizePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    .addComponent(widthTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
		    .addComponent(widthLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		.addGroup(resizePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    .addComponent(heightTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		    .addComponent(heightLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
		.addContainerGap(17, 17));
	}
	
	public boolean getResize() {
		return ((ResizeCheckBox) resizeCheckBox).getResize();
	}
	
	public String getWidthValue() {
		return widthTextField.getText();
	}
	
	public String getHeightValue() {
		return heightTextField.getText();
	}
	
	public void clearAllFields() {
		((ResizeCheckBox) resizeCheckBox).clear(); 
		widthTextField.setText("");
		heightTextField.setText("");
	}
}
