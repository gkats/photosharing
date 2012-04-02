package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import app.di.annotations.Compress;
import app.di.annotations.Resize;

import com.google.inject.Inject;

public class ManipulationPanel extends JPanel {

	private static final long serialVersionUID = -8246666744663868140L;
	
	private JPanel resizePanel;
	private JPanel compressPanel;
	
	@Inject
	public ManipulationPanel(@Resize JPanel resizePanel, 
			@Compress JPanel compressPanel) {
		
		this.resizePanel = resizePanel;
		this.compressPanel = compressPanel;
		initGUI();
	}

	private void initGUI() {
		GroupLayout manipulationPanelLayout = 
			new GroupLayout((JComponent) this);
		setLayout(manipulationPanelLayout);
		setBorder(BorderFactory.createTitledBorder("Resize and Compress"));
		setSize(768, 133);
		
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
	
}
