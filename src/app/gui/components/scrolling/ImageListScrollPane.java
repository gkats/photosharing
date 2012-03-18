package app.gui.components.scrolling;

import javax.swing.JList;
import javax.swing.JScrollPane;

import app.gui.components.text.ImagesList;

public class ImageListScrollPane extends JScrollPane {

	private static final long serialVersionUID = -5495384672401369184L;
	
	private JList imagesList;
	
	public ImageListScrollPane() {
		imagesList = new ImagesList();
		setViewportView(imagesList);
	}
	
	public JList getImagesList() {
		return imagesList;
	}
}
