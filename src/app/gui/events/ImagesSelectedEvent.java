package app.gui.events;

import java.io.File;

public class ImagesSelectedEvent {

	private final File[] selectedImages;

	public ImagesSelectedEvent(File[] selectedImages) {
		this.selectedImages = selectedImages;
	}
	
	public File[] getSelectedImages() {
		return selectedImages;
	}
}
