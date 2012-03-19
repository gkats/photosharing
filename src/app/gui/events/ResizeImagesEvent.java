package app.gui.events;

import java.io.File;
import java.util.List;

public class ResizeImagesEvent {

	private final List<File> images;

	public ResizeImagesEvent(List<File> images) {
		this.images = images;
	}
	
	public List<File> getImages() {
		return images;
	}
}
