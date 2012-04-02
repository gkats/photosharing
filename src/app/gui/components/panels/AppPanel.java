package app.gui.components.panels;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import app.di.annotations.Go;
import app.di.annotations.Images;
import app.di.annotations.Manipulation;
import app.di.annotations.Output;
import app.di.annotations.Reset;
import app.di.annotations.Share;

import com.google.inject.Inject;

public class AppPanel extends JPanel {

	private static final long serialVersionUID = -1037162277329834941L;

	private JPanel imagesPanel;
	private JPanel manipulationPanel;
	private JPanel sharePanel;
	private JPanel outputPanel;
	private JButton goButton;
	private JButton resetButton;
	
	@Inject
	public AppPanel(@Images JPanel imagesPanel, @Manipulation JPanel manipulationPanel,
			@Share JPanel sharePanel, @Output JPanel outputPanel, @Go JButton goButton,
			@Reset JButton resetButton) {
		
		this.imagesPanel = imagesPanel;
		this.manipulationPanel = manipulationPanel;
		this.sharePanel = sharePanel;
		this.outputPanel = outputPanel;
		this.goButton = goButton;
		this.resetButton = resetButton;
		
		GroupLayout appPanelLayout = new GroupLayout((JComponent) this);
		setLayout(appPanelLayout);
		
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
