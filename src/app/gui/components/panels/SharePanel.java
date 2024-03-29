package app.gui.components.panels;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import app.di.annotations.Mail;
import app.di.annotations.Upload;

import com.google.inject.Inject;

public class SharePanel extends JPanel {

	private static final long serialVersionUID = -7532452903844152513L;
	
	private JPanel uploadPanel;
	private JPanel mailPanel;

	@Inject
	public SharePanel(@Upload JPanel uploadPanel, @Mail JPanel mailPanel) {
		GroupLayout sharePanelLayout = new GroupLayout((JComponent) this);
		setLayout(sharePanelLayout);
		setSize(768, 491);
		setBorder(BorderFactory.createTitledBorder("Upload and Share"));
		
		this.uploadPanel = uploadPanel;
		this.mailPanel = mailPanel;
		
		setContent(sharePanelLayout);
	}

	private void setContent(GroupLayout sharePanelLayout) {
		sharePanelLayout.setHorizontalGroup(
			sharePanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(sharePanelLayout.createParallelGroup()
			    .addComponent(uploadPanel, GroupLayout.Alignment.LEADING, 0, 
			    		791, Short.MAX_VALUE)
			    .addComponent(mailPanel, GroupLayout.Alignment.LEADING, 0, 
			    		791, Short.MAX_VALUE))
			.addContainerGap()
		);
		sharePanelLayout.setVerticalGroup(
			sharePanelLayout.createSequentialGroup()
			.addComponent(uploadPanel, GroupLayout.PREFERRED_SIZE, 70, 
					GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(mailPanel, 0, 99, Short.MAX_VALUE)
			.addContainerGap()
		);
	}
}
