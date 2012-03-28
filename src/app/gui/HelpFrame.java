package app.gui;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import app.gui.components.text.HelpTextPane;
import app.gui.events.EventBusService;
import app.gui.events.ShowHelpEvent;

import com.google.common.eventbus.Subscribe;

public class HelpFrame extends JFrame {

	private static final long serialVersionUID = 1068828926114057546L;

	private JTextPane helpPane;
	private JScrollPane helpScrollPane;
	
	public HelpFrame() {
		GroupLayout helpFrameLayout 
			= new GroupLayout((JComponent) getContentPane());
    	getContentPane().setLayout(helpFrameLayout);
    	setSize(400, 300);
    	setTitle("Help");
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	
    	helpPane = new HelpTextPane();
    	helpScrollPane = new JScrollPane();
    	helpScrollPane.setViewportView(helpPane);
		
    	setContent(helpFrameLayout);
    	
		EventBusService.getEventBus().register(this);
	}
	
	private void setContent(GroupLayout helpFrameLayout) {
		helpFrameLayout.setVerticalGroup(helpFrameLayout.createSequentialGroup()
			.addComponent(helpScrollPane, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
		);
		helpFrameLayout.setHorizontalGroup(helpFrameLayout.createSequentialGroup()
			.addComponent(helpScrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
		);
	}

	@Subscribe
	public void showHelp(ShowHelpEvent e) {
		setVisible(true);
	}
}
