package app.di.config;

import javax.swing.JButton;

import app.di.annotations.Compress;
import app.di.annotations.Go;
import app.di.annotations.Images;
import app.di.annotations.Reset;
import app.gui.components.buttons.BrowseArchiveButton;
import app.gui.components.buttons.BrowseImagesButton;
import app.gui.components.buttons.ClearImagesListButton;
import app.gui.components.buttons.GoButton;
import app.gui.components.buttons.ResetButton;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ButtonsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JButton.class).annotatedWith(Go.class).to(GoButton.class);
		bind(JButton.class).annotatedWith(Reset.class).to(ResetButton.class);
		bind(JButton.class).annotatedWith(Images.class).to(BrowseImagesButton.class);
		bind(JButton.class).annotatedWith(Names.named("clearImagesList")).to(ClearImagesListButton.class);
		bind(JButton.class).annotatedWith(Compress.class).to(BrowseArchiveButton.class);
	}

}
