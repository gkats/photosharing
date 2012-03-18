package app.gui.components.filechooser;

import javax.swing.JFileChooser;

public class FileChooserFactory {

	private static JFileChooser fileChooser;
	
	private FileChooserFactory() { }
	
	public static JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
		}
		return fileChooser;
	}
}
