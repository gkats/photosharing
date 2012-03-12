package app.util;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static app.util.FileUtils.ARCHIVE_EXTENSIONS;
import static app.util.FileUtils.IMAGE_EXTENSIONS;
import static app.util.FileUtils.getExtension;

public class FileUtilsTests {

	@Test
	public void testImageExtensions() {
		assertTrue(IMAGE_EXTENSIONS.contains("gif"));
		assertTrue(IMAGE_EXTENSIONS.contains("jpg"));
		assertTrue(IMAGE_EXTENSIONS.contains("jpeg"));
		assertTrue(IMAGE_EXTENSIONS.contains("png"));
		assertTrue(IMAGE_EXTENSIONS.contains("tiff"));
		assertTrue(IMAGE_EXTENSIONS.contains("tif"));
	}
	
	@Test
	public void testArchiveExtensions() {
		assertTrue(ARCHIVE_EXTENSIONS.contains("zip"));
	}
	
	@Test
	public void testGetExtension() {
		final String ext = "ext"; 
		File file = new File("correct." + ext);
		assertEquals(ext, getExtension(file));
		file = new File("correct." + ext.toUpperCase());
		assertEquals(ext, getExtension(file));
		file = new File("invalid");
		assertNull(getExtension(file));
	}
	
	// TODO test zipUtils
}