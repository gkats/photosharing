package app.gui.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import app.gui.components.filechooser.FileChooserFactory;
import app.gui.filters.ArchiveFilter;

public class BrowseArchiveAction extends AbstractAction {

	private static final long serialVersionUID = -525367833144538755L;

	private JFileChooser fileChooser = FileChooserFactory.getFileChooser();
	private Component component;
	private JTextField textField;
	
	public BrowseArchiveAction(Component component, JTextField textField) {
		super("Browse", null);
		this.component = component;
		this.textField = textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fileChooser.setFileFilter(new ArchiveFilter());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fileChooser.showDialog(component, "Select");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
		}
		fileChooser.setSelectedFile(null);
	}

}
