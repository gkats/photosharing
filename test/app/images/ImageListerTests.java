package app.images;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.images.ImageLister;

public class ImageListerTests {

	private ImageLister lister = new ImageLister();
	
	@Test
	public void testListImages() {
		List<File> locations = new ArrayList<File>();
		String projectDir = "test";
		File fileLocation = new File(projectDir + "/resources/images/image.png");
		File dirLocation = new File(projectDir + "/resources/images/folder");
		locations.add(fileLocation);
		locations.add(dirLocation);
		
		List<File> images = lister.listImages(locations);
		
		assertEquals(7, lister.getListedFiles());
		assertEquals(2, lister.getListedDirs());
		assertTrue(images.contains(fileLocation));
	}
	
}