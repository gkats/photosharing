package app.gui.components.panels;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import app.gui.components.buttons.GoButton;
import app.gui.components.buttons.ResetButton;

public class AppPanel extends JPanel {

	private static final long serialVersionUID = -1037162277329834941L;

	private JPanel imagesPanel;
	private JPanel manipulationPanel;
	private JPanel sharePanel;
	private JPanel outputPanel;
	private JButton goButton;
	private JButton resetButton;
	
	public AppPanel() {
		GroupLayout appPanelLayout = new GroupLayout((JComponent) this);
		setLayout(appPanelLayout);
		
    	imagesPanel = new ImagesPanel();
    	manipulationPanel = new ManipulationPanel();
    	sharePanel = new SharePanel();
    	outputPanel = new OutputPanel();
    	goButton = new GoButton();
    	resetButton = new ResetButton();
    	
    	setContent(appPanelLayout);
	}

	private void setContent(GroupLayout appPanelLayout) {
		appPanelLayout.setVerticalGroup(appPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(imagesPanel, GroupLayout.PREFERRED_SIZE, 133, 
					GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(manipulationPanel, GroupLayout.PREFERRED_SIZE, 133, 
					GroupLayout.PREFERRED_SIZE)
			.addGap(17)
			.addComponent(sharePanel, GroupLayout.PREFERRED_SIZE, 255, 
					GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(
				appPanelLayout.createParallelGroup()
			    .addComponent(outputPanel, GroupLayout.Alignment.LEADING, 0, 
			    		88, Short.MAX_VALUE)
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	appPanelLayout.createSequentialGroup()
			        .addGap(0, 26, Short.MAX_VALUE)
			        .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 34, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			        .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 24, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addGap(28)
			    )
			)
			.addContainerGap()
		);
		
		appPanelLayout.setHorizontalGroup(appPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(
				appPanelLayout.createParallelGroup()
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	appPanelLayout.createSequentialGroup()
			        .addComponent(outputPanel, GroupLayout.PREFERRED_SIZE, 642, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			        .addGroup(appPanelLayout.createParallelGroup()
    			        .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 103, 
    			        	GroupLayout.PREFERRED_SIZE)
    			        .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 103, 
    			        	GroupLayout.PREFERRED_SIZE)
			        )
			        .addGap(0, 11, Short.MAX_VALUE)
			    )
			    .addComponent(imagesPanel, GroupLayout.Alignment.LEADING, 0, 
			    	768, Short.MAX_VALUE)
			    .addComponent(manipulationPanel, GroupLayout.Alignment.LEADING, 
			    	0, 768, Short.MAX_VALUE)
			    .addComponent(sharePanel, GroupLayout.Alignment.LEADING, 0, 
			    	768, Short.MAX_VALUE)
			)
			.addContainerGap()
		);
	}
}
