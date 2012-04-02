package app.gui;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import app.di.annotations.App;
import app.gui.events.ClearFieldsEvent;
import app.gui.events.EmailSentEvent;
import app.gui.events.EventBusService;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = -7180367288739459084L;
	
	private JScrollPane appPanelScrollPane;
	
	@Inject
	public AppFrame(JMenuBar menuBar, @App JScrollPane appPanelScrollPane) {
		this.appPanelScrollPane = appPanelScrollPane;
		GroupLayout appFrameLayout 
			= new GroupLayout((JComponent) getContentPane());
		getContentPane().setLayout(appFrameLayout);
		setSize(800, 600);
		setResizable(false);
		setTitle("PhotoSharing");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setJMenuBar(menuBar);

		setContent(appFrameLayout);
		pack();
		
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void finalOperation(EmailSentEvent e) {
		EventBusService.getEventBus().post(new ClearFieldsEvent());
	}
	
	private void setContent(GroupLayout appFrameLayout) {
		appFrameLayout.setHorizontalGroup(
			appFrameLayout.createSequentialGroup()
			.addComponent(appPanelScrollPane, GroupLayout.PREFERRED_SIZE, 800, 
				GroupLayout.PREFERRED_SIZE)
		);
		appFrameLayout.setVerticalGroup(
			appFrameLayout.createSequentialGroup()
			.addComponent(appPanelScrollPane, GroupLayout.PREFERRED_SIZE, 600, 
				GroupLayout.PREFERRED_SIZE)
		);
	}
	
}
