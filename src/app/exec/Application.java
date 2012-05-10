package app.exec;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import app.di.annotations.App;
import app.di.annotations.Help;
import app.di.config.PhotoSharingModule;
import app.gui.components.filechooser.FileChooserFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Application {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PhotoSharingModule());
		ApplicationThread app = injector.getInstance(ApplicationThread.class);
		SwingUtilities.invokeLater(app);
	}
	
	public static class ApplicationThread implements Runnable {
		
		private JFrame appFrame;
		private JFrame helpFrame;
		
		@Inject
		public ApplicationThread(@App JFrame appFrame, @Help JFrame helpFrame) {
			this.appFrame = appFrame;
			this.helpFrame = helpFrame;
		}
		
		public void run() {
			FileChooserFactory.getFileChooser();
			appFrame.setLocationRelativeTo(null);
			appFrame.setVisible(true);
			helpFrame.setLocationRelativeTo(appFrame);
			helpFrame.setVisible(false);
		}
	}
	
}
