package app.exec;
import javax.swing.SwingUtilities;

import app.gui.AppFrame;
import app.gui.HelpFrame;
import app.gui.components.filechooser.FileChooserFactory;

public class Application {

	private static final long serialVersionUID = 5407640954864628060L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FileChooserFactory.getFileChooser();
				AppFrame appFrame = new AppFrame();
				appFrame.setLocationRelativeTo(null);
				appFrame.setVisible(true);
				HelpFrame helpFrame = new HelpFrame();
				helpFrame.setLocationRelativeTo(appFrame);
				helpFrame.setVisible(false);
			}
		});
	}
	
//	public Application() {
//		super();
//		try {
//			initGUI();
//		}
//		catch (Exception e) {
//			Logger.INSTANCE.log(Severity.ERROR, e.getMessage());
//		}
//	}

}
