package app.gui.events;

import java.io.File;
import java.util.List;

public class CompressImagesEvent {

	private final List<File> images;

	public CompressImagesEvent(List<File> images) {
		this.images = images;
	}
	
	public List<File> getImages() {
		return images;
	}
}
