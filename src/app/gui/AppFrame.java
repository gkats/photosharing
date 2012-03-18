package app.gui;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import app.gui.actions.BrowseArchiveAction;
import app.gui.actions.BrowseImagesAction;
import app.gui.actions.GoAction;
import app.gui.components.buttons.GoButton;
import app.gui.components.menu.MenuBar;
import app.gui.components.panels.ImagesPanel;
import app.gui.components.panels.ManipulationPanel;
import app.gui.components.panels.OutputPanel;
import app.gui.components.panels.SharePanel;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = -7180367288739459084L;
	
	private JMenuBar menuBar;
	private JPanel imagesPanel;
	private JPanel manipulationPanel;
	private JPanel sharePanel;
	private JPanel outputPanel;
	private JButton goButton;
	
	public AppFrame() {
		GroupLayout appFrameLayout 
			= new GroupLayout((JComponent)getContentPane());
		getContentPane().setLayout(appFrameLayout);
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		imagesPanel = new ImagesPanel();
		manipulationPanel = new ManipulationPanel();
		sharePanel = new SharePanel();
		outputPanel = new OutputPanel();
		goButton = new GoButton();

		setContent(appFrameLayout);
		pack();
	
		getImagesPanel().getBrowseImagesButton().setAction(
			new BrowseImagesAction(this, getImagesPanel().getImagesList())
		);
		
		getManipulationPanel().getBrowseArchiveButton()
			.setAction(
				new BrowseArchiveAction(
					this, 
					getManipulationPanel().getArchiveNameTextField()
				)
		);
		
		goButton.setAction(new GoAction(getImagesPanel(), getManipulationPanel()));
	}
	
	private void setContent(GroupLayout appFrameLayout) {
		appFrameLayout.setVerticalGroup(appFrameLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(imagesPanel, GroupLayout.PREFERRED_SIZE, 133, 
					GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(manipulationPanel, GroupLayout.PREFERRED_SIZE, 133, 
					GroupLayout.PREFERRED_SIZE)
			.addGap(17)
			.addComponent(sharePanel, GroupLayout.PREFERRED_SIZE, 111, 
					GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(
				appFrameLayout.createParallelGroup()
			    .addComponent(outputPanel, GroupLayout.Alignment.LEADING, 0, 
			    		88, Short.MAX_VALUE)
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	appFrameLayout.createSequentialGroup()
			        .addGap(0, 26, Short.MAX_VALUE)
			        .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 34, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addGap(28)
			    )
			)
			.addContainerGap()
		);
		
		appFrameLayout.setHorizontalGroup(appFrameLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(
				appFrameLayout.createParallelGroup()
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	appFrameLayout.createSequentialGroup()
			        .addComponent(outputPanel, GroupLayout.PREFERRED_SIZE, 642, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			        .addComponent(goButton, GroupLayout.PREFERRED_SIZE, 103, 
			        	GroupLayout.PREFERRED_SIZE)
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
	
	public ImagesPanel getImagesPanel() {
		return (ImagesPanel) imagesPanel;
	}

	public ManipulationPanel getManipulationPanel() {
		return (ManipulationPanel) manipulationPanel;
	}
}
