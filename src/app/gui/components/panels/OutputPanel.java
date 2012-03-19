package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import app.gui.components.scrolling.OutputScrollPane;

public class OutputPanel extends JPanel {

	private static final long serialVersionUID = 1664654325111627712L;

	private JScrollPane outputScrollPane;
	
	public OutputPanel() {
		GroupLayout outputPanelLayout = new GroupLayout((JComponent) this);
		setLayout(outputPanelLayout);
		setBorder(BorderFactory.createTitledBorder(null, 
				"Output", TitledBorder.LEADING, TitledBorder.TOP));
		
		outputScrollPane = new OutputScrollPane();
		setContent(outputPanelLayout);
	}

	private void setContent(GroupLayout outputPanelLayout) {
		outputPanelLayout.setVerticalGroup(
			outputPanelLayout.createSequentialGroup()
			.addComponent(outputScrollPane, GroupLayout.PREFERRED_SIZE, 
					52, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(12, 12)
		);
		outputPanelLayout.setHorizontalGroup(
			outputPanelLayout.createSequentialGroup()
			.addContainerGap(12, 12)
			.addComponent(outputScrollPane, GroupLayout.PREFERRED_SIZE, 
					608, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(12, 12)
		);
	}
}
