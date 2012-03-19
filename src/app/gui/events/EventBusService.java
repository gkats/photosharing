package app.gui.events;

import com.google.common.eventbus.EventBus;

public class EventBusService {

	private static EventBus eventBus = new EventBus();

	private EventBusService() { }
	
	public static EventBus getEventBus() {
		return eventBus;
	}
}
