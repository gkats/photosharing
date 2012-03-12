package app.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import app.images.ImageResizer;

public class ImageResizerTests {

	private ImageResizer resizer = new ImageResizer();
	private final String projectDir = "test";
	
	@Test
	public void testResize() throws IOException {
		String file = projectDir + "/resources/images/image.png";
		File input = new File(file);
		BufferedImage img = ImageIO.read(input);
		int width = img.getWidth();
		int height = img.getHeight();
		
		resizer.resize(input, width + 1, height + 1);
		
		img = ImageIO.read(input);
		assertEquals(1, resizer.getResizedImages());
		assertEquals(width + 1, img.getWidth());
		assertEquals(height + 1, img.getHeight());
	}
}