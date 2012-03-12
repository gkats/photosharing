package app.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {
	
	private FileUtils() { }

	public static final int BUFFER = 4096;
	
	public static final Set<String> IMAGE_EXTENSIONS = new HashSet<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("gif");
			add("jpg");
			add("jpeg");
			add("png");
			add("tif");
			add("tiff");
		}
	};
	
	public static final Set<String> ARCHIVE_EXTENSIONS = new HashSet<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("zip");
		}
	};
	
	/**
	 * @return a file's extension, or null if the extension cannot be determined.
	 */
	public static String getExtension(File file) {
		String extension = null;
		String name = file.getName();
		int index = name.lastIndexOf('.');
		if (index > 0 && index < name.length() - 1) {
			extension = name.substring(index + 1).toLowerCase();
		}
		return extension;
	}
	
	/**
	 * Compresses files in a zip archive.
	 * @param archiveName the absolute file path of the archive
	 * @param files the files to be compressed
	 * @throws IOException
	 */
	public static void zipFiles(String archiveName, File... files)
		throws IOException {
		
		final FileOutputStream dest = new FileOutputStream(archiveName);
		final ZipOutputStream out = 
			new ZipOutputStream(new BufferedOutputStream(dest));
		
		try {
			byte[] data = new byte[BUFFER];
			for (File file : files) {
				final FileInputStream fi = new FileInputStream(file);
				final BufferedInputStream origin = new BufferedInputStream(fi, BUFFER);
				out.putNextEntry(new ZipEntry(file.getName()));
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
				fi.close();
			}
		}
		finally {
			out.close();
			dest.close();
		}
	}
	
	/**
	 * Compresses the contents of a folder and adds them to a zip archive.
	 * @param archiveName the name of the archive
	 * @param folder the directory whose files should be compressed
	 * @throws IOException
	 */
	public static void zipFilesInFolder(String archiveName, String folder)
		throws IOException {
		
		File dir = new File(folder);
		if (dir != null & dir.isDirectory()) {
			zipFiles(archiveName, dir.listFiles());
		}
		else {
			throw new IOException(folder + " is not a directory.");
		}
	}
}