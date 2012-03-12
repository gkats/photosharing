package app.gui.filters;

import static app.util.FileUtils.ARCHIVE_EXTENSIONS;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import app.util.FileUtils;

public class ArchiveFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return ARCHIVE_EXTENSIONS.contains(FileUtils.getExtension(f));
	}

	@Override
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		for (String ext : ARCHIVE_EXTENSIONS) {
			if (sb.length() > 1) {
				sb.append(", ");
			}
			sb.append("*.").append(ext);
		}
		return "Archive files (" + sb.toString() + ")";
	}

}