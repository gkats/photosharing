package app.gui.components.scrolling;

import java.io.File;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;

import app.gui.components.text.ImagesList;
import app.gui.events.ClearFieldsEvent;
import app.gui.events.EventBusService;
import app.gui.events.ImagesListedEvent;
import app.gui.events.ImagesSelectedEvent;
import app.gui.events.ListImagesEvent;
import app.images.ImageLister;
import app.log.Logger;
import app.log.Severity;
import app.util.CollectionUtils;

import com.google.common.eventbus.Subscribe;

public class ImageListScrollPane extends JScrollPane {

	private static final long serialVersionUID = -5495384672401369184L;
	
	private JList imagesList;
	
	public ImageListScrollPane() {
		imagesList = new ImagesList();
		setViewportView(imagesList);
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void selectImages(ImagesSelectedEvent e) {
		imagesList.setListData(CollectionUtils.extendModel(imagesList.getModel(), 
				e.getSelectedImages(), File.class));
	}
	
	@Subscribe
	public void listImages(ListImagesEvent e) {
		List<File> locations 
			= CollectionUtils.asList(imagesList.getModel(), File.class);
		ImageLister lister = new ImageLister();
		List<File> images = lister.listImages(locations);
		Logger.INSTANCE.log(Severity.INFO, "Found " 
				+ lister.getListedFiles() + " files, in " 
				+ lister.getListedDirs() + " folders.");
		EventBusService.getEventBus().post(new ImagesListedEvent(images));
	}
	
	@Subscribe
	public void clearFields(ClearFieldsEvent e) {
		imagesList.setListData(new Object[0]);
	}
	
}
