package app.images;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Resizes image files.
 * @author gkats
 */
public class ImageResizer {

	private int resizedImages = 0;
	
	/**
	 * Resizes an image file. Fluent interface for 
	 * {@link ImageResizer#resize(BufferedImage, int, int)}. The resized file 
	 * is saved with the new dimensions. 
	 * @param input the file to be resized
	 * @param width the desired width
	 * @param height the desired height
	 * @exception IllegalArgumentException
	 * @throws IOException
	 */
	public void resize(File input, int width, int height) 
		throws IOException {
		
		BufferedImage img = ImageIO.read(input);
		if (img != null) {
			BufferedImage resized = resize(img, width, height);
			save(resized, input);
			resizedImages++;
		}
		else {
			throw new IllegalArgumentException("Could not read image: " 
					+ input.getAbsolutePath());
		}
	}

	/**
	 * Resizes an image.
	 * @param img the image to be resized
	 * @param width the desired width
	 * @param height the desired height
	 * @return the image with the desired dimensions
	 */
	public BufferedImage resize(BufferedImage img, int width, int height) {
		int w = img.getWidth();  
        int h = img.getHeight();
        BufferedImage resized = new BufferedImage(width, height, img.getType());
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
        		RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
        g.drawImage(img, 0, 0, width, height, 0, 0, w, h, null);  
        g.dispose();  
		return resized;
	}
	
	/**
	 * Writes an image to a file.
	 * @param img the image to be saved
	 * @param file the file to be written
	 * @throws IOException when the image cannot be saved
	 */
	private void save(BufferedImage img, File file) throws IOException {
		String name = file.getAbsolutePath();
		int index = name.lastIndexOf('.');
		if (index > 0) {
			ImageIO.write(img, name.substring(index + 1).toLowerCase(), file);
		}
		else {
			throw new IllegalArgumentException("Invalid extension for file: " 
					+ file.getAbsolutePath());
		}
	}
	
	public int getResizedImages() {
		return resizedImages;
	}
}