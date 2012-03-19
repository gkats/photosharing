package app.gui.components.text;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;

import app.gui.events.ClearFieldsEvent;
import app.gui.events.CompressImagesEvent;
import app.gui.events.EventBusService;
import app.gui.events.ImagesCompressedEvent;
import app.gui.events.ImagesResizedEvent;

import com.google.common.eventbus.Subscribe;

public class CompressCheckBox extends JCheckBox {

	private static final long serialVersionUID = 291033021236062178L;

	private boolean compress;
	
	public CompressCheckBox() {
		setText("Compress?");
		setMnemonic(KeyEvent.VK_C);
		addItemListener(new CompressCheckBoxItemListener());
		EventBusService.getEventBus().register(this);
	}
	
	@Subscribe
	public void imagesResized(ImagesResizedEvent e) {
		if (compress) {
			EventBusService.getEventBus().post(
					new CompressImagesEvent(e.getImages()));
		}
		else {
			EventBusService.getEventBus().post(new ImagesCompressedEvent());
		}
	}
	
	@Subscribe
	public void clearFields(ClearFieldsEvent e) {
		compress = false;
		setSelected(false);
	}
	
	public class CompressCheckBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getItemSelectable() instanceof CompressCheckBox) {
				compress = (e.getStateChange() == ItemEvent.SELECTED);
			}
		}
	}
	
}
