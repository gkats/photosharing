package app.di.config;

import javax.swing.JFrame;

import app.di.annotations.App;
import app.di.annotations.Help;
import app.gui.AppFrame;
import app.gui.HelpFrame;

import com.google.inject.AbstractModule;

public class FramesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JFrame.class).annotatedWith(App.class).to(AppFrame.class);
		bind(JFrame.class).annotatedWith(Help.class).to(HelpFrame.class);
	}

}
