package app.gui.components.text;

import javax.swing.JTextPane;

public class HelpTextPane extends JTextPane {

	private static final long serialVersionUID = 8875261711629642269L;

	public HelpTextPane() {
		String text = "Went on a trip with your friends and you want to exchange " +
		"your photos? Have you ever been on an event where you were the only one with a camera?\n" +
		"\nThe PhotoSharing utility helps you quickly share photos with your friends. " + 
		"It adds all the photos in an archive, uploads them to your Dropbox account " +
		"and sends an email with the download link to all your friends. You can even " +
		"choose to resize the images or compress them before creating the archive. " +
		"Email accounts currently supported for sharing the download link are Gmail and Hotmail.\n" + 
		"\nAdd files/folders\n" +
		"\n" +
		"To start, press the Add button. You can select as many image files and folders as you want." +
		" You can clear the list anytime by pressing the Clear button.\n" + 
		"\nResize and Compress\n" +
		"\n" +
		"Next, you have the option of resizing the images, by checking the Resize checkbox and " + 
		"specifying a width and height value. Please note that resizing the images will result in " + 
		"the resizing of your actual files. Expect data loss when using this functionality.\n" +
		"Then, you can place your photos in an archive, with the option of compressing them first. " +
		"You must specify the filename for the archive to be saved, or overwrite an existing one. " +
		"Just press the Browse button to find an archive. If you also want compression, you must " + 
		"select the Compress? checkbox. The PhotSharing utility currently supports only .zip archives.\n" +
		"\nUpload and Share\n" +
		"\n" +
		"All the images will be uploaded to your Dropbox account. All you have to do is specify your " + 
		"Dropbox username and password and as soon as the upload is complete, the download link will show up.\n" +
		"The download link will be sent to as many friends as you want. Just select your email account " + 
		"type from the dropdown menu, fill in your username and password, add the email's recipients " +
		"(as comma separated values) and an optional subject for the email. Currently, only Gmail " + 
		"and Hotmail accounts are supported by the PhotSharing utility.\n" +
		"\nWhen you are done with selections, just press the Go button, sit back and let the app do " +
		"its work. You can clear your selections anytime, by pressing the Reset button.";
		setText(text);
	}
}
