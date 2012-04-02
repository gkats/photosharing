package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import app.di.annotations.Images;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ImagesPanel extends JPanel {

	private static final long serialVersionUID = 2363980182499948598L;
	
	@Inject
	public ImagesPanel(@Images JButton browseImagesButton, 
			@Images JScrollPane imageListScrollPane, 
			@Named("clearImagesList") JButton clearImagesListButton) {
		
		GroupLayout imagesPanelLayout = new GroupLayout((JComponent) this);
		setLayout(imagesPanelLayout);
		setBorder(BorderFactory.createTitledBorder("Add files/folders"));
		
		imagesPanelLayout.setVerticalGroup(
			imagesPanelLayout.createSequentialGroup()
			.addComponent(imageListScrollPane, GroupLayout.PREFERRED_SIZE, 
				71, GroupLayout.PREFERRED_SIZE)
    		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
    		.addGroup(
    			imagesPanelLayout.createParallelGroup()
				.addComponent(browseImagesButton, GroupLayout.PREFERRED_SIZE, 
        			GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(clearImagesListButton, GroupLayout.PREFERRED_SIZE, 
        			GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    		)
    		.addContainerGap(11, 11)
    	);
		
		imagesPanelLayout.setHorizontalGroup(
			imagesPanelLayout.createSequentialGroup()
			.addContainerGap(12, 12)
			.addGroup(imagesPanelLayout.createParallelGroup()
			    .addGroup(imagesPanelLayout.createSequentialGroup()
					.addComponent(browseImagesButton, 
			    		GroupLayout.PREFERRED_SIZE, 95, 
			    		GroupLayout.PREFERRED_SIZE)
			    	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
    	    		.addComponent(clearImagesListButton, 
    			    		GroupLayout.PREFERRED_SIZE, 95, 
    			    		GroupLayout.PREFERRED_SIZE)
			    )
			    .addComponent(imageListScrollPane, 
			    		GroupLayout.Alignment.LEADING, 
			    		GroupLayout.PREFERRED_SIZE, 734, 
			    		GroupLayout.PREFERRED_SIZE)
			 )
			.addContainerGap(12, 12)
		);
	}
	
}
