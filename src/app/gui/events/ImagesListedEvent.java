package app.gui.events;

import java.io.File;
import java.util.List;

public class ImagesListedEvent {

	private final List<File> images;

	public ImagesListedEvent(List<File> images) {
		this.images = images;
	}
	
	public List<File> getImages() {
		return images;
	}
}
