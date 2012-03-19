package app.gui.components.filechooser;

import javax.swing.JFileChooser;

import app.gui.events.ArchiveSelectedEvent;
import app.gui.events.BrowseArchiveEvent;
import app.gui.events.BrowseImagesEvent;
import app.gui.events.EventBusService;
import app.gui.events.ImagesSelectedEvent;
import app.gui.filters.ArchiveFilter;
import app.gui.filters.ImageFilter;

import com.google.common.eventbus.Subscribe;

public class FileChooser extends JFileChooser {

	private static final long serialVersionUID = -2636605818003988269L;
	
	public FileChooser() {
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void browseImages(BrowseImagesEvent e) {
		setFileFilter(new ImageFilter());
		setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		setMultiSelectionEnabled(true);
		int returnVal = showDialog(this, "Select");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			EventBusService.getEventBus().post(
					new ImagesSelectedEvent(getSelectedFiles()));
		}
		setSelectedFile(null);
		setMultiSelectionEnabled(false);
	}
	
	@Subscribe
	public void browseArchives(BrowseArchiveEvent e) {
		setFileFilter(new ArchiveFilter());
		setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = showDialog(this, "Select");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			EventBusService.getEventBus().post(
				new ArchiveSelectedEvent(getSelectedFile()));
		}
		setSelectedFile(null);
	}

}
