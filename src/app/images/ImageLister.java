package app.images;

import static app.util.FileUtils.IMAGE_EXTENSIONS;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import app.util.FileUtils;

/**
 * Lists all image files in specified locations. Each location can be a folder 
 * or a file directly. In the former case, all sub-folders are parsed as well.
 * @author gkats
 */
public class ImageLister {

	private int listedFiles = 0;
	private int listedDirs = 0;
	
	public List<File> listImages(List<File> locations) {
		List<File> images = new ArrayList<File>();
		for (File dir : locations) {
			parseDirs(dir, images);
		}
		return images;
	}

	private void parseDirs(File dir, List<File> images) {
		if (dir.isFile()) {
			if (IMAGE_EXTENSIONS.contains(FileUtils.getExtension(dir))){
				images.add(dir);
				listedFiles++;
			}
		}
		else if (dir.isDirectory()) {
			listedDirs++;
			for (File file : dir.listFiles()) {
				parseDirs(file, images);
			}
		}
	}
	
	public int getListedFiles() {
		return listedFiles;
	}

	public int getListedDirs() {
		return listedDirs;
	}
}
