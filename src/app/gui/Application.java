package app.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import app.gui.filters.ArchiveFilter;
import app.gui.filters.ImageFilter;
import app.images.ImageLister;
import app.images.ImageResizer;
import app.log.Logger;
import app.log.Severity;
import app.util.FileUtils;
import app.util.ListUtils;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Application extends javax.swing.JFrame {

	private static final long serialVersionUID = 5407640954864628060L;
	private JPanel imagesPanel;
	private JMenuBar menuBar;
	private JPanel resizePanel;
	private JCheckBox resizeCheckBox;
	private JPanel compressPanel;
	private JScrollPane imageListScrollPane;
	private JScrollPane outputScrollPane;
	private JTextArea outputArea;
	private JPanel outputPanel;
	private JTextField archiveNameTextField;
	private AbstractAction goAction;
	private JButton goButton;
	private AbstractAction browseArchivesAction;
	private JFileChooser fileChooser;
	private AbstractAction browseImagesAction;
	private JLabel heightLabel;
	private JLabel widthLabel;
	private JTextField heightTextField;
	private JTextField widthTextField;
	private JButton browseArchiveButton;
	private JButton browseImagesButton;
	private JPanel sharePanel;
	private JLabel archiveNameLabel;
	private JCheckBox compressCheckBox;
	private JList imagesList;
	private JPanel manipulationPanel;
	private JMenu jMenu1;
	
	// data
	private Vector<File> imageFiles = new Vector<File>();
	private Boolean resize = false;
	private Boolean compress = false;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Application inst = new Application();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Application() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				{
					jMenu1 = new JMenu();
					menuBar.add(jMenu1);
					jMenu1.setText("jMenu1");
				}
			}
			{
				imagesPanel = new JPanel();
				GroupLayout jPanelLayout = new GroupLayout((JComponent)imagesPanel);
				imagesPanel.setLayout(jPanelLayout);
				imagesPanel.setBorder(BorderFactory.createTitledBorder("Add files/folders"));
				{
					browseImagesButton = new JButton();
					browseImagesButton.setMnemonic(KeyEvent.VK_A);
					GroupLayout browseImagesButtonLayout = new GroupLayout((JComponent)browseImagesButton);
					browseImagesButton.setText("Add");
					browseImagesButton.setAction(getBrowseImagesAction());
					browseImagesButtonLayout.setVerticalGroup(browseImagesButtonLayout.createParallelGroup());
					browseImagesButtonLayout.setHorizontalGroup(browseImagesButtonLayout.createParallelGroup());
				}
				jPanelLayout.setVerticalGroup(jPanelLayout.createSequentialGroup()
					.addComponent(getImageListScrollPane(), GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(browseImagesButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, 11));
				jPanelLayout.setHorizontalGroup(jPanelLayout.createSequentialGroup()
					.addContainerGap(12, 12)
					.addGroup(jPanelLayout.createParallelGroup()
					    .addComponent(browseImagesButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					    .addComponent(getImageListScrollPane(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, 12));
			}
			{
				manipulationPanel = new JPanel();
				GroupLayout manipulationPanelLayout = new GroupLayout((JComponent)manipulationPanel);
				manipulationPanel.setLayout(manipulationPanelLayout);
				manipulationPanel.setBorder(BorderFactory.createTitledBorder("Resize and Compress"));
				manipulationPanel.setSize(768, 133);
				{
					resizePanel = new JPanel();
					GroupLayout resizePanelLayout = new GroupLayout((JComponent)resizePanel);
					resizePanel.setLayout(resizePanelLayout);
					resizePanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					{
						resizeCheckBox = new JCheckBox();
						resizeCheckBox.setMnemonic(KeyEvent.VK_R);
						resizeCheckBox.setText("Resize?");
						resizeCheckBox.addItemListener(new ResizeCheckBoxItemListener());
					}
					{
						widthLabel = new JLabel();
						GroupLayout widthLabelLayout = new GroupLayout((JComponent)widthLabel);
						widthLabel.setLayout(null);
						widthLabel.setText("Width:");
						widthLabelLayout.setVerticalGroup(widthLabelLayout.createParallelGroup());
						widthLabelLayout.setHorizontalGroup(widthLabelLayout.createParallelGroup());
					}
					{
						heightLabel = new JLabel();
						heightLabel.setText("Height:");
					}
					{
						widthTextField = new JTextField();
					}
					{
						heightTextField = new JTextField();
					}
					resizePanelLayout.setHorizontalGroup(resizePanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(resizePanelLayout.createParallelGroup()
						    .addGroup(resizePanelLayout.createSequentialGroup()
						        .addGroup(resizePanelLayout.createParallelGroup()
						            .addComponent(widthLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						            .addGroup(GroupLayout.Alignment.LEADING, resizePanelLayout.createSequentialGroup()
						                .addComponent(heightLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						                .addGap(7)))
						        .addGroup(resizePanelLayout.createParallelGroup()
						            .addGroup(resizePanelLayout.createSequentialGroup()
						                .addComponent(heightTextField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						                .addGap(0, 0, Short.MAX_VALUE))
						            .addComponent(widthTextField, GroupLayout.Alignment.LEADING, 0, 49, Short.MAX_VALUE)))
						    .addGroup(GroupLayout.Alignment.LEADING, resizePanelLayout.createSequentialGroup()
						        .addComponent(resizeCheckBox, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 30, Short.MAX_VALUE)))
						.addContainerGap(20, 20));
					resizePanelLayout.setVerticalGroup(resizePanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(resizeCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(resizePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(widthTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(widthLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(resizePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(heightTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						    .addComponent(heightLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(17, 17));
				}
				{
					compressPanel = new JPanel();
					GroupLayout compressPanelLayout = new GroupLayout((JComponent)compressPanel);
					compressPanel.setLayout(compressPanelLayout);
					compressPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					{
						compressCheckBox = new JCheckBox();
						compressCheckBox.setText("Compress?");
						compressCheckBox.setMnemonic(KeyEvent.VK_C);
						compressCheckBox.addItemListener(new CompressCheckBoxItemListener());
					}
					{
						archiveNameLabel = new JLabel();
						GroupLayout archiveNameLabelLayout = new GroupLayout((JComponent)archiveNameLabel);
						archiveNameLabel.setLayout(archiveNameLabelLayout);
						archiveNameLabel.setText("Archive filename:");
						archiveNameLabelLayout.setVerticalGroup(archiveNameLabelLayout.createParallelGroup());
						archiveNameLabelLayout.setHorizontalGroup(archiveNameLabelLayout.createParallelGroup());
					}
					{
						archiveNameTextField = new JTextField();
					}
					{
						browseArchiveButton = new JButton();
						GroupLayout browseArchiveButtonLayout = new GroupLayout((JComponent)browseArchiveButton);
						browseArchiveButton.setText("Browse");
						browseArchiveButton.setMnemonic(KeyEvent.VK_B);
						browseArchiveButton.setAction(getBrowseArchivesAction());
						browseArchiveButtonLayout.setVerticalGroup(browseArchiveButtonLayout.createParallelGroup());
						browseArchiveButtonLayout.setHorizontalGroup(browseArchiveButtonLayout.createParallelGroup());
					}
						compressPanelLayout.setVerticalGroup(compressPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(compressCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(archiveNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(compressPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							    .addComponent(archiveNameTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							    .addComponent(browseArchiveButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)));
						compressPanelLayout.setHorizontalGroup(compressPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(compressPanelLayout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, compressPanelLayout.createSequentialGroup()
						        .addComponent(compressCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(376))
						    .addGroup(GroupLayout.Alignment.LEADING, compressPanelLayout.createSequentialGroup()
						        .addComponent(archiveNameLabel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						        .addGap(268))
						    .addComponent(archiveNameTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(browseArchiveButton, 0, 104, Short.MAX_VALUE)
						.addContainerGap());
				}
				manipulationPanelLayout.setHorizontalGroup(manipulationPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(resizePanel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(compressPanel, 0, 582, Short.MAX_VALUE)
					.addContainerGap());
				manipulationPanelLayout.setVerticalGroup(manipulationPanelLayout.createSequentialGroup()
					.addGroup(manipulationPanelLayout.createParallelGroup()
					    .addComponent(resizePanel, GroupLayout.Alignment.LEADING, 0, 97, Short.MAX_VALUE)
					    .addComponent(compressPanel, GroupLayout.Alignment.LEADING, 0, 97, Short.MAX_VALUE))
					.addContainerGap());
			}
			{
				sharePanel = new JPanel();
				sharePanel.setSize(768, 133);
				sharePanel.setBorder(BorderFactory.createTitledBorder("Upload and Share"));
			}
				thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(imagesPanel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(manipulationPanel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(sharePanel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(thisLayout.createParallelGroup()
					    .addComponent(getOutputPanel(), GroupLayout.Alignment.LEADING, 0, 88, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
					        .addGap(0, 26, Short.MAX_VALUE)
					        .addComponent(getGoButton(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					        .addGap(28)))
					.addContainerGap());
				thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(thisLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
					        .addComponent(getOutputPanel(), GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					        .addComponent(getGoButton(), GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 11, Short.MAX_VALUE))
					    .addComponent(imagesPanel, GroupLayout.Alignment.LEADING, 0, 768, Short.MAX_VALUE)
					    .addComponent(manipulationPanel, GroupLayout.Alignment.LEADING, 0, 768, Short.MAX_VALUE)
					    .addComponent(sharePanel, GroupLayout.Alignment.LEADING, 0, 768, Short.MAX_VALUE))
					.addContainerGap());
			pack();
			this.setSize(800, 589);
		} catch (Exception e) {
		    //add your error handling code here
			Logger.INSTANCE.log(Severity.ERROR, e.getMessage());
		}
	}
	
	private AbstractAction getBrowseImagesAction() {
		if(browseImagesAction == null) {
			browseImagesAction = new AbstractAction("Add", null) {
				private static final long serialVersionUID = 1L;
				
				public void actionPerformed(ActionEvent evt) {
					getFileChooser().setFileFilter(new ImageFilter());
					getFileChooser().setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					getFileChooser().setMultiSelectionEnabled(true);
					int returnVal = getFileChooser().showDialog(Application.this, "Select");
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File[] selectedFiles = getFileChooser().getSelectedFiles();
						for (File file : selectedFiles) {
							imageFiles.add(file);
						}
						imagesList.setListData(imageFiles);
					}
					getFileChooser().setSelectedFile(null);
					getFileChooser().setMultiSelectionEnabled(false);
				}
			};
		}
		return browseImagesAction;
	}
	
	private JFileChooser getFileChooser() {
		if(fileChooser == null) {
			fileChooser = new JFileChooser();
		}
		return fileChooser;
	}
	
	private AbstractAction getBrowseArchivesAction() {
		if(browseArchivesAction == null) {
			browseArchivesAction = new AbstractAction("Browse", null) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					getFileChooser().setFileFilter(new ArchiveFilter());
					getFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
					int returnVal = getFileChooser().showDialog(Application.this, "Select");
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						archiveNameTextField.setText(getFileChooser().getSelectedFile().getAbsolutePath());
					}
					getFileChooser().setSelectedFile(null);
				}
			};
		}
		return browseArchivesAction;
	}
	
	private JButton getGoButton() {
		if(goButton == null) {
			goButton = new JButton();
			GroupLayout goButtonLayout = new GroupLayout((JComponent)goButton);
			goButton.setLayout(null);
			goButton.setText("Go");
			goButton.setSize(103, 34);
			goButton.setAction(getGoAction());
			goButtonLayout.setHorizontalGroup(goButtonLayout.createParallelGroup());
			goButtonLayout.setVerticalGroup(goButtonLayout.createParallelGroup());
		}
		return goButton;
	}
	
	private AbstractAction getGoAction() {
		if(goAction == null) {
			goAction = new AbstractAction("Go", null) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					List<File> images = listImages();
					if (resize) {
						resizeImages(images);
					}
					if (compress) {
						compressImages(images);
					}
					clearAllFields();
				}
			};
		}
		return goAction;
	}

	private List<File> listImages() {
		List<File> locations 
			= ListUtils.asList(imagesList.getModel(), File.class);
		ImageLister lister = new ImageLister();
		List<File> res = lister.listImages(locations);
		Logger.INSTANCE.log(Severity.INFO, "Found " 
				+ lister.getListedFiles() + " files, in " 
				+ lister.getListedDirs() + " folders.");
		return res;
	}
	
	private void resizeImages(List<File> images) {
		ImageResizer resizer = new ImageResizer();
		for (File image : images) {
			try {
				int width = Integer.parseInt(widthTextField.getText());
				int height = Integer.parseInt(heightTextField.getText());
				resizer.resize(image, width, height);
			} catch (NumberFormatException e) {
				Logger.INSTANCE.log(Severity.ERROR, 
						"Invalid width/height value.");
				return;
			} catch (IOException e) {
				Logger.INSTANCE.log(Severity.ERROR, 
						"Could not resize file: " 
						+ image.getAbsolutePath());
			}
		}
		Logger.INSTANCE.log(Severity.INFO, "Resized " 
				+ resizer.getResizedImages() + " images.");
	}
	
	private void compressImages(List<File> images) {
		String archiveName = archiveNameTextField.getText();
		try {
			FileUtils.zipFiles(archiveName, images.toArray(new File[0]));
		} catch (IOException e) {
			Logger.INSTANCE.log(Severity.ERROR, "Could not create archive.");
		}
		Logger.INSTANCE.log(Severity.INFO, "Created archive " + archiveName);
	}
	
	private void clearAllFields() {
		imageFiles.clear();
		imagesList.setListData(imageFiles);
		resize = false;
		resizeCheckBox.setSelected(false);
		compress = false;
		compressCheckBox.setSelected(false);
		widthTextField.setText("");
		heightTextField.setText("");
		archiveNameTextField.setText("");
	}
	
	private JPanel getOutputPanel() {
		if(outputPanel == null) {
			outputPanel = new JPanel();
			GroupLayout outputPanelLayout = new GroupLayout((JComponent)outputPanel);
			outputPanel.setLayout(outputPanelLayout);
			outputPanel.setBorder(BorderFactory.createTitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP));
			outputPanelLayout.setVerticalGroup(outputPanelLayout.createSequentialGroup()
				.addComponent(getOutputScrollPane(), GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, 12));
			outputPanelLayout.setHorizontalGroup(outputPanelLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addComponent(getOutputScrollPane(), GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(12, 12));
		}
		return outputPanel;
	}
	
	private JTextArea getOutputArea() {
		if(outputArea == null) {
			outputArea = new JTextArea();
			outputArea.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			outputArea.setEditable(false);
			outputArea.setLineWrap(true);
		}
		return outputArea;
	}
	
	private JScrollPane getOutputScrollPane() {
		if(outputScrollPane == null) {
			outputScrollPane = new JScrollPane();
			outputScrollPane.setViewportView(getOutputArea());
		}
		return outputScrollPane;
	}
	
	private JScrollPane getImageListScrollPane() {
		if(imageListScrollPane == null) {
			imageListScrollPane = new JScrollPane();
			{
				ListModel imagesListModel = new DefaultComboBoxModel(imageFiles);
				imagesList = new JList();
				imageListScrollPane.setViewportView(imagesList);
				GroupLayout imagesListLayout = new GroupLayout((JComponent)imagesList);
				imagesList.setModel(imagesListModel);
				imagesListLayout.setVerticalGroup(imagesListLayout.createParallelGroup());
				imagesListLayout.setHorizontalGroup(imagesListLayout.createParallelGroup());
			}
		}
		return imageListScrollPane;
	}

	public class ResizeCheckBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getItemSelectable() == resizeCheckBox) {
				resize = (e.getStateChange() == ItemEvent.SELECTED);
			}
		}
	}
	
	public class CompressCheckBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getItemSelectable() == compressCheckBox) {
				compress = (e.getStateChange() == ItemEvent.SELECTED);
			}
		}
	}
	
}