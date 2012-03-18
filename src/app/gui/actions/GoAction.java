package app.gui.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;

import app.gui.components.panels.ImagesPanel;
import app.gui.components.panels.ManipulationPanel;
import app.images.ImageLister;
import app.images.ImageResizer;
import app.log.Logger;
import app.log.Severity;
import app.util.FileUtils;
import app.util.ListUtils;

public class GoAction extends AbstractAction {

	private static final long serialVersionUID = 8171350959705350012L;

	private ImagesPanel images;
	private ManipulationPanel manipulation;
	
	public GoAction(ImagesPanel images, ManipulationPanel manipulation) {
		super("Go", null);
		this.images = images;
		this.manipulation = manipulation;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<File> images = listImages();
		if (manipulation.getResize()) {
			resizeImages(images);
		}
		if (manipulation.getCompress()) {
			compressImages(images);
		}
		clearAllFields();
	}

	private List<File> listImages() {
		List<File> locations 
			= ListUtils.asList(images.getImagesList().getModel(), File.class);
		ImageLister lister = new ImageLister();
		List<File> res = lister.listImages(locations);
		Logger.INSTANCE.log(Severity.INFO, "Found " 
				+ lister.getListedFiles() + " files, in " 
				+ lister.getListedDirs() + " folders.");
		return res;
	}
	
	private void resizeImages(List<File> images) {
		ImageResizer resizer = new ImageResizer();
		for (File image : images) {
			try {
				int width = Integer.parseInt(manipulation.getWidthValue());
				int height = Integer.parseInt(manipulation.getHeightValue());
				resizer.resize(image, width, height);
			} catch (NumberFormatException e) {
				Logger.INSTANCE.log(Severity.ERROR, 
						"Invalid width/height value.");
				return;
			} catch (IOException e) {
				Logger.INSTANCE.log(Severity.ERROR, 
						"Could not resize file: " 
						+ image.getAbsolutePath());
			}
		}
		Logger.INSTANCE.log(Severity.INFO, "Resized " 
				+ resizer.getResizedImages() + " images.");
	}
	
	private void compressImages(List<File> images) {
		String archiveName = manipulation.getArchiveNameTextField().getText();
		try {
			FileUtils.zipFiles(archiveName, images.toArray(new File[0]));
		} catch (IOException e) {
			Logger.INSTANCE.log(Severity.ERROR, "Could not create archive.");
		}
		Logger.INSTANCE.log(Severity.INFO, "Created archive " + archiveName);
	}
	
	private void clearAllFields() {
		images.clearAllFields();
		manipulation.clearAllFields();
	}
}
