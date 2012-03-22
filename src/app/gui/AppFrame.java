package app.gui;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import app.gui.components.menu.MenuBar;
import app.gui.components.scrolling.AppPanelScrollPane;
import app.gui.events.ClearFieldsEvent;
import app.gui.events.EventBusService;
import app.gui.events.ImagesCompressedEvent;

import com.google.common.eventbus.Subscribe;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = -7180367288739459084L;
	
	private JMenuBar menuBar;
	private JScrollPane appPanelScrollPane;
	
	public AppFrame() {
		GroupLayout appFrameLayout 
			= new GroupLayout((JComponent) getContentPane());
		getContentPane().setLayout(appFrameLayout);
		setSize(810, 610);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		appPanelScrollPane = new AppPanelScrollPane();

		setContent(appFrameLayout);
		pack();
		
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void finalOperation(ImagesCompressedEvent e) {
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
