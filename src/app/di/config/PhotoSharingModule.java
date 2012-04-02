package app.di.config;

import com.google.inject.AbstractModule;

public class PhotoSharingModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new FramesModule());
		install(new MenusModule());
		install(new PanelsModule());
		install(new ScrollPanesModule());
		install(new ActionsModule());
		install(new ButtonsModule());
		install(new ListsModule());
		install(new CheckBoxesModule());
		install(new ComboBoxesModule());
		install(new TextAreasModule());
	}

}
