package app.gui.events;

import java.io.File;

public class ArchiveSelectedEvent {

	private final File selectedArchive;
	
	public File getSelectedArchive() {
		return selectedArchive;
	}

	public ArchiveSelectedEvent(File selectedArchive) {
		this.selectedArchive = selectedArchive;
	}
	
}
