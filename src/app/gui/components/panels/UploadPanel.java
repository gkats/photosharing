package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

public class UploadPanel extends JPanel {

	private static final long serialVersionUID = -3730443987974875475L;
	
	private JLabel titleLabel;
	private JLabel userNameLabel;
	private JTextField userNameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	public UploadPanel() {
		GroupLayout uploadPanelLayout = new GroupLayout((JComponent) this);
		setLayout(uploadPanelLayout);
		setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		
		titleLabel = new JLabel("Upload to my Dropbox account");
		userNameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		userNameTextField = new JTextField();
		passwordField = new JPasswordField();
		
		setContent(uploadPanelLayout);
	}

	private void setContent(GroupLayout uploadPanelLayout) {
		uploadPanelLayout.setHorizontalGroup(
			uploadPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(
				uploadPanelLayout.createParallelGroup()
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    		uploadPanelLayout.createSequentialGroup()
			    		.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 
			    			64, GroupLayout.PREFERRED_SIZE)
			    		.addGap(7)
			    		.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 
			    			195, GroupLayout.PREFERRED_SIZE)
			    		.addGap(50)
			    		.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 
			    			64, GroupLayout.PREFERRED_SIZE)
			    		.addGap(7)
			    		.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 
			    			195, GroupLayout.PREFERRED_SIZE)
			        .addGap(0, 153, Short.MAX_VALUE)
			    )
			    .addComponent(titleLabel, GroupLayout.Alignment.LEADING, 
			    	0, 763, Short.MAX_VALUE)
			)
		    .addContainerGap()
		);
		uploadPanelLayout.setVerticalGroup(
			uploadPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 
				16, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(
				uploadPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(userNameTextField, GroupLayout.Alignment.BASELINE, 
			    	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			    	GroupLayout.PREFERRED_SIZE)
			    .addComponent(userNameLabel, GroupLayout.Alignment.BASELINE, 
			    	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			    	GroupLayout.PREFERRED_SIZE)
			    .addComponent(passwordLabel, GroupLayout.Alignment.BASELINE, 
			    	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			    	GroupLayout.PREFERRED_SIZE)
			    .addComponent(passwordField, GroupLayout.Alignment.BASELINE, 
			    	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			    	GroupLayout.PREFERRED_SIZE)
			 )
			.addContainerGap()
		);
	}

}
