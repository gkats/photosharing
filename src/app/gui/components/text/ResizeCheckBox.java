package app.gui.components.text;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;

import app.gui.events.ClearFieldsEvent;
import app.gui.events.EventBusService;
import app.gui.events.ImagesListedEvent;
import app.gui.events.ImagesResizedEvent;
import app.gui.events.ResizeImagesEvent;

import com.google.common.eventbus.Subscribe;

public class ResizeCheckBox extends JCheckBox {

	private static final long serialVersionUID = 7548908287463406291L;

	private boolean resize = false;
	
	public ResizeCheckBox() {
		setMnemonic(KeyEvent.VK_R);
		setText("Resize?");
		addItemListener(new ResizeCheckBoxItemListener());
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void imagesListed(ImagesListedEvent e) {
		if (resize) {
			EventBusService.getEventBus().post(
					new ResizeImagesEvent(e.getImages()));
		}
		else {
			EventBusService.getEventBus().post(
					new ImagesResizedEvent(e.getImages()));
		}
	}
	
	@Subscribe
	public void clearFields(ClearFieldsEvent e) {
		resize = false;
		setSelected(false);
	}
	
	public class ResizeCheckBoxItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if (e.getItemSelectable() instanceof ResizeCheckBox) {
				resize = (e.getStateChange() == ItemEvent.SELECTED);
			}
		}
	}
	
}
