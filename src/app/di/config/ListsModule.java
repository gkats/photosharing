package app.di.config;

import javax.swing.JList;

import app.di.annotations.Images;
import app.gui.components.text.ImagesList;

import com.google.inject.AbstractModule;

public class ListsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JList.class).annotatedWith(Images.class).to(ImagesList.class);
	}

}
