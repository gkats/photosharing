package app.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JList;

import app.gui.components.filechooser.FileChooserFactory;
import app.gui.filters.ImageFilter;

public class BrowseImagesAction extends AbstractAction {

	private static final long serialVersionUID = 4650219830823343728L;

	private JFileChooser fileChooser = FileChooserFactory.getFileChooser();
	private Component component;
	private Vector<File> imageFiles = new Vector<File>();
	private JList list;
	
	public BrowseImagesAction(Component component, JList list) {
		super("Add", null);
		this.component = component;
		this.list = list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fileChooser.setFileFilter(new ImageFilter());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setMultiSelectionEnabled(true);
		int returnVal = fileChooser.showDialog(component, "Select");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File[] selectedFiles = fileChooser.getSelectedFiles();
			for (File file : selectedFiles) {
				imageFiles.add(file);
			}
			list.setListData(imageFiles);
		}
		fileChooser.setSelectedFile(null);
		fileChooser.setMultiSelectionEnabled(false);
	}

}
