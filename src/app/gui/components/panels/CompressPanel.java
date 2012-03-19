package app.gui.components.panels;

import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import com.google.common.eventbus.Subscribe;

import app.gui.components.buttons.BrowseArchiveButton;
import app.gui.components.text.CompressCheckBox;
import app.gui.events.ArchiveSelectedEvent;
import app.gui.events.ClearFieldsEvent;
import app.gui.events.CompressImagesEvent;
import app.gui.events.EventBusService;
import app.log.Logger;
import app.log.Severity;
import app.util.FileUtils;

public class CompressPanel extends JPanel {

	private static final long serialVersionUID = -6398204364191476122L;

	private JCheckBox compressCheckBox;
	private JLabel archiveNameLabel;
	private JTextField archiveNameTextField;
	private JButton browseArchiveButton;
	
	public CompressPanel() {
		GroupLayout compressPanelLayout = new GroupLayout((JComponent)this);
		setLayout(compressPanelLayout);
		setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		
		compressCheckBox = new CompressCheckBox();
		archiveNameLabel = new JLabel("Archive filename:");
		archiveNameTextField = new JTextField();
		browseArchiveButton = new BrowseArchiveButton();
		
		setContent(compressPanelLayout);
		
		EventBusService.getEventBus().register(this);
	}

	private void setContent(GroupLayout compressPanelLayout) {
		compressPanelLayout.setVerticalGroup(
			compressPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(compressCheckBox, GroupLayout.PREFERRED_SIZE, 
					GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(archiveNameLabel, GroupLayout.PREFERRED_SIZE, 
				GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(
				compressPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(archiveNameTextField, GroupLayout.Alignment.BASELINE, 
					GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
					GroupLayout.PREFERRED_SIZE)
				.addComponent(browseArchiveButton, GroupLayout.Alignment.BASELINE, 
					GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
					GroupLayout.PREFERRED_SIZE)
			)
		);
		
		compressPanelLayout.setHorizontalGroup(
			compressPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(
				compressPanelLayout.createParallelGroup()
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	compressPanelLayout.createSequentialGroup()
			    	.addComponent(compressCheckBox, GroupLayout.PREFERRED_SIZE, 
			    			GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    	.addGap(376)
			    )
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	compressPanelLayout.createSequentialGroup()
			        .addComponent(archiveNameLabel, GroupLayout.PREFERRED_SIZE, 
			        	178, GroupLayout.PREFERRED_SIZE)
			        .addGap(268)
			    )
			    .addComponent(archiveNameTextField, GroupLayout.Alignment.LEADING, 
			    	GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
			)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(browseArchiveButton, 0, 104, Short.MAX_VALUE)
			.addContainerGap()
		);
	}
	
	@Subscribe
	public void selectArchive(ArchiveSelectedEvent e) {
		archiveNameTextField.setText(e.getSelectedArchive().getAbsolutePath());
	}
	
	@Subscribe
	public void compressImages(CompressImagesEvent e) {
		String archiveName = archiveNameTextField.getText();
		try {
			FileUtils.zipFiles(archiveName, e.getImages().toArray(new File[0]));
			Logger.INSTANCE.log(Severity.INFO, "Created archive " + archiveName);
			EventBusService.getEventBus().post(new ClearFieldsEvent());
		} catch (IOException ioe) {
			Logger.INSTANCE.log(Severity.ERROR, "Could not create archive.");
		}
	}
	
	@Subscribe
	public void clearFields(ClearFieldsEvent e) {
		archiveNameTextField.setText("");
	}
	
	public JTextField getArchiveNameTextField() {
		return archiveNameTextField;
	}
	
	public JButton getBrowseArchiveButton() {
		return browseArchiveButton;
	}
	
	public void clearAllFields() {
		((CompressCheckBox) compressCheckBox).clear();
		archiveNameTextField.setText("");
	}
}
