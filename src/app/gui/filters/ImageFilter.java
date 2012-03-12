package app.gui.filters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import app.util.FileUtils;

import static app.util.FileUtils.IMAGE_EXTENSIONS;

public class ImageFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return f.isDirectory()
			|| IMAGE_EXTENSIONS.contains(FileUtils.getExtension(f));
	}

	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		for (String ext : IMAGE_EXTENSIONS) {
			if (sb.length() > 1) {
				sb.append(", ");
			}
			sb.append("*.").append(ext);
		}
		return "Folders and image files (" + sb.toString() + ")";
	}

}