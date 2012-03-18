package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class ManipulationPanel extends JPanel {

	private static final long serialVersionUID = -8246666744663868140L;
	
	private JPanel resizePanel;
	private JPanel compressPanel;
	
	public ManipulationPanel() {
		initGUI();
	}

	private void initGUI() {
		GroupLayout manipulationPanelLayout = 
			new GroupLayout((JComponent) this);
		setLayout(manipulationPanelLayout);
		setBorder(BorderFactory.createTitledBorder("Resize and Compress"));
		setSize(768, 133);
		
		resizePanel = new ResizePanel();
		compressPanel = new CompressPanel();
		
		setContent(manipulationPanelLayout);
	}
	
	private void setContent(GroupLayout manipulationPanelLayout) {
		manipulationPanelLayout.setHorizontalGroup(
			manipulationPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(resizePanel, GroupLayout.PREFERRED_SIZE, 140, 
				GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(compressPanel, 0, 582, Short.MAX_VALUE)
			.addContainerGap()
		);
		manipulationPanelLayout.setVerticalGroup(
			manipulationPanelLayout.createSequentialGroup()
			.addGroup(manipulationPanelLayout.createParallelGroup()
		    .addComponent(resizePanel, GroupLayout.Alignment.LEADING, 0, 
		    	97, Short.MAX_VALUE)
		    .addComponent(compressPanel, GroupLayout.Alignment.LEADING, 0, 
		    	97, Short.MAX_VALUE))
		    .addContainerGap()
		);
	}
	
	public boolean getResize() {
		return ((ResizePanel) resizePanel).getResize();
	}
	
	public String getWidthValue() {
		return getResizePanel().getWidthValue();
	}
	
	public String getHeightValue() {
		return getResizePanel().getHeightValue();
	}
	
	public boolean getCompress() {
		return getCompressPanel().getCompress();
	}
	
	public JTextField getArchiveNameTextField() {
		return getCompressPanel().getArchiveNameTextField();
	}
	
	public JButton getBrowseArchiveButton() {
		return getCompressPanel().getBrowseArchiveButton();
	}
	
	private ResizePanel getResizePanel() {
		return (ResizePanel) resizePanel;
	}
	
	private CompressPanel getCompressPanel() {
		return (CompressPanel) compressPanel;
	}
	
	public void clearAllFields() {
		getResizePanel().clearAllFields();
		getCompressPanel().clearAllFields();
	}
}
