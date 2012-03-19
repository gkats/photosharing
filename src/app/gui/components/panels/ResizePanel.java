package app.gui.components.panels;

import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import app.gui.components.text.ResizeCheckBox;
import app.gui.events.ClearFieldsEvent;
import app.gui.events.EventBusService;
import app.gui.events.ImagesResizedEvent;
import app.gui.events.ResizeImagesEvent;
import app.images.ImageResizer;
import app.log.Logger;
import app.log.Severity;

import com.google.common.eventbus.Subscribe;

public class ResizePanel extends JPanel {

	private static final long serialVersionUID = -8764266885580996037L;
	
	private JCheckBox resizeCheckBox;
	private JLabel widthLabel;
	private JLabel heightLabel;
	private JTextField heightTextField;
	private JTextField widthTextField;
	
	public ResizePanel() {
		initGUI();
		EventBusService.getEventBus().register(this);
	}

	private void initGUI() {
		GroupLayout resizePanelLayout = new GroupLayout((JComponent) this);
		setLayout(resizePanelLayout);
		setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
		
		resizeCheckBox = new ResizeCheckBox();
		widthLabel = new JLabel("Width:");
		widthTextField = new JTextField();
		heightLabel = new JLabel("Height:");
		heightTextField = new JTextField();
		
		resizePanelLayout.setHorizontalGroup(resizePanelLayout.createSequentialGroup()
		.addContainerGap()
		.addGroup(resizePanelLayout.createParallelGroup()
		    .addGroup(resizePanelLayout.createSequentialGroup()
		        .addGroup(resizePanelLayout.createParallelGroup()
		            .addComponent(widthLabel, GroupLayout.Alignment.LEADING, 
		            		GroupLayout.PREFERRED_SIZE, 55, 
		            		GroupLayout.PREFERRED_SIZE)
		            .addGroup(GroupLayout.Alignment.LEADING, 
		            		resizePanelLayout.createSequentialGroup()
		                .addComponent(heightLabel, GroupLayout.PREFERRED_SIZE, 
		                		48, GroupLayout.PREFERRED_SIZE)
		                .addGap(7)
		            )
		        )
		        .addGroup(resizePanelLayout.createParallelGroup()
		            .addGroup(resizePanelLayout.createSequentialGroup()
		                .addComponent(heightTextField, GroupLayout.PREFERRED_SIZE, 
		                		49, GroupLayout.PREFERRED_SIZE)
		                .addGap(0, 0, Short.MAX_VALUE))
		            .addComponent(widthTextField, GroupLayout.Alignment.LEADING, 
		            		0, 49, Short.MAX_VALUE)
		         )
		    )
		    .addGroup(GroupLayout.Alignment.LEADING, 
		    		resizePanelLayout.createSequentialGroup()
		        .addComponent(resizeCheckBox, GroupLayout.PREFERRED_SIZE, 
		        		74, GroupLayout.PREFERRED_SIZE)
		        .addGap(0, 30, Short.MAX_VALUE)
		    )
		)
		.addContainerGap(20, 20)
	);
	resizePanelLayout.setVerticalGroup(resizePanelLayout.createSequentialGroup()
		.addContainerGap()
		.addComponent(resizeCheckBox, GroupLayout.PREFERRED_SIZE, 
				GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
		.addGroup(
			resizePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    .addComponent(widthTextField, GroupLayout.Alignment.BASELINE, 
		    		GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
		    		GroupLayout.PREFERRED_SIZE)
		    .addComponent(widthLabel, GroupLayout.Alignment.BASELINE, 
		    		GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
		    		GroupLayout.PREFERRED_SIZE)
		)
		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		.addGroup(
			resizePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    .addComponent(heightTextField, GroupLayout.Alignment.BASELINE, 
		    		GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		    .addComponent(heightLabel, GroupLayout.Alignment.BASELINE, 
		    		GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, 
		    		GroupLayout.PREFERRED_SIZE))
		    .addContainerGap(17, 17)
		);
	}
	
	@Subscribe
	public void resizeImages(ResizeImagesEvent e) {
		ImageResizer resizer = new ImageResizer();
		for (File image : e.getImages()) {
			try {
				int width = Integer.parseInt(widthTextField.getText());
				int height = Integer.parseInt(heightTextField.getText());
				resizer.resize(image, width, height);
				EventBusService.getEventBus().post(
						new ImagesResizedEvent(e.getImages()));
			} catch (NumberFormatException nfe) {
				Logger.INSTANCE.log(Severity.ERROR, 
						"Invalid width/height value.");
				return;
			} catch (IOException ioe) {
				Logger.INSTANCE.log(Severity.ERROR, 
						"Could not resize file: " + image.getAbsolutePath());
			}
		}
		Logger.INSTANCE.log(Severity.INFO, "Resized " 
				+ resizer.getResizedImages() + " images.");
	}
	
	@Subscribe
	public void clearFields(ClearFieldsEvent e) {
		widthTextField.setText("");
		heightTextField.setText("");
	}
	
}
