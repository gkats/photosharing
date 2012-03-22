package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import app.gui.components.scrolling.RecipientsScrollPane;
import app.gui.components.text.MailAccountComboBox;

public class MailPanel extends JPanel {

	private static final long serialVersionUID = 7435439774062236519L;

	private JLabel accountLabelPartOne;
	private JComboBox accountComboBox;
	private JLabel accountLabelPartTwo;
	private JLabel userNameLabel;
	private JTextField userNameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel recipientsLabel;
	private JScrollPane recipientsScrollPane;
	
	public MailPanel() {
		GroupLayout mailPanelLayout = new GroupLayout((JComponent) this);
		setLayout(mailPanelLayout);
		setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		
		accountLabelPartOne = new JLabel("Send mail using my ");
		accountComboBox = new MailAccountComboBox();
		accountLabelPartTwo = new JLabel(" account.");
		userNameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		userNameTextField = new JTextField();
		passwordField = new JPasswordField();
		recipientsLabel = new JLabel("Recipients (comma-separated values):");
		recipientsScrollPane = new RecipientsScrollPane();
		
		setContent(mailPanelLayout);
	}

	private void setContent(GroupLayout mailPanelLayout) {
		mailPanelLayout.setHorizontalGroup(
			mailPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(
				mailPanelLayout.createParallelGroup()
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	mailPanelLayout.createSequentialGroup()
			        .addComponent(accountLabelPartOne, 
			        	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addGap(88)
			    )
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	mailPanelLayout.createSequentialGroup()
			        .addComponent(accountComboBox, GroupLayout.PREFERRED_SIZE, 
			        	115, GroupLayout.PREFERRED_SIZE)
			        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			        .addComponent(accountLabelPartTwo, GroupLayout.PREFERRED_SIZE, 
			        	66, GroupLayout.PREFERRED_SIZE)
			        .addGap(54)
			    )
			    .addGroup(
			    	mailPanelLayout.createSequentialGroup()
			        .addGroup(
			        	mailPanelLayout.createParallelGroup()
			            .addComponent(passwordLabel, 
			            	GroupLayout.Alignment.LEADING, 
			            	GroupLayout.PREFERRED_SIZE, 72, 
			            	GroupLayout.PREFERRED_SIZE)
			            .addComponent(userNameLabel, 
			            	GroupLayout.Alignment.LEADING, 
			            	GroupLayout.PREFERRED_SIZE, 72, 
			            	GroupLayout.PREFERRED_SIZE))
			        .addGroup(
			        	mailPanelLayout.createParallelGroup()
			            .addComponent(passwordField, 
			            	GroupLayout.Alignment.LEADING, 
			            	GroupLayout.PREFERRED_SIZE, 181, 
			            	GroupLayout.PREFERRED_SIZE)
			            .addComponent(userNameTextField, 
			            	GroupLayout.Alignment.LEADING, 
			            	GroupLayout.PREFERRED_SIZE, 181, 
			            	GroupLayout.PREFERRED_SIZE)
			        )
			    )
			)
			.addGap(56)
			.addGroup(
				mailPanelLayout.createParallelGroup()
			    .addGroup(
			    	mailPanelLayout.createSequentialGroup()
			        .addComponent(recipientsScrollPane, 
			        	GroupLayout.PREFERRED_SIZE, 395, 
			        	GroupLayout.PREFERRED_SIZE)
			        .addGap(0, 0, Short.MAX_VALUE)
			    )
			    .addGroup(
			    	GroupLayout.Alignment.LEADING, 
			    	mailPanelLayout.createSequentialGroup()
			        .addComponent(recipientsLabel, GroupLayout.PREFERRED_SIZE, 
			        	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			        .addGap(0, 270, Short.MAX_VALUE)
			    )
			)
			.addContainerGap()
		);
		mailPanelLayout.setVerticalGroup(
			mailPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(
				mailPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(recipientsLabel, GroupLayout.Alignment.BASELINE, 
			    	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			    	GroupLayout.PREFERRED_SIZE)
			    .addComponent(accountLabelPartOne, GroupLayout.Alignment.BASELINE, 
			    	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			    	GroupLayout.PREFERRED_SIZE)
			)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(
				mailPanelLayout.createParallelGroup()
			    .addGroup(
			    	mailPanelLayout.createSequentialGroup()
			        .addComponent(recipientsScrollPane, GroupLayout.PREFERRED_SIZE, 
			        	89, GroupLayout.PREFERRED_SIZE)
			        .addGap(0, 0, Short.MAX_VALUE)
			    )
			    .addGroup(
			    	mailPanelLayout.createSequentialGroup()
			        .addGroup(
			        	mailPanelLayout.createParallelGroup()
			            .addComponent(accountComboBox, GroupLayout.Alignment.LEADING, 
			            	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			            	GroupLayout.PREFERRED_SIZE)
			            .addGroup(
			            	GroupLayout.Alignment.LEADING, 
			            	mailPanelLayout.createSequentialGroup()
			                .addComponent(accountLabelPartTwo, 
			                	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			                	GroupLayout.PREFERRED_SIZE)
			                .addGap(7)
			            )
			        )
			        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			        .addGroup(
			        	mailPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(userNameTextField, 
			            	GroupLayout.Alignment.BASELINE, 
			            	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			            	GroupLayout.PREFERRED_SIZE)
			            .addComponent(userNameLabel, GroupLayout.Alignment.BASELINE, 
			            	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			            	GroupLayout.PREFERRED_SIZE)
			        )
			        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			        .addGroup(
			        	mailPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(passwordField, GroupLayout.Alignment.BASELINE, 
			            	GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
			            .addComponent(passwordLabel, GroupLayout.Alignment.BASELINE, 
			            	GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
			            	GroupLayout.PREFERRED_SIZE)
			        )
			        .addGap(8)
			    )
			)
			.addContainerGap()
		);
	}
}
