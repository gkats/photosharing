package app.di.config;

import javax.swing.JScrollPane;

import app.di.annotations.App;
import app.di.annotations.Images;
import app.di.annotations.Mail;
import app.di.annotations.Output;
import app.gui.components.scrolling.AppPanelScrollPane;
import app.gui.components.scrolling.ImageListScrollPane;
import app.gui.components.scrolling.OutputScrollPane;
import app.gui.components.scrolling.RecipientsScrollPane;

import com.google.inject.AbstractModule;

public class ScrollPanesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JScrollPane.class).annotatedWith(App.class).to(AppPanelScrollPane.class);
		bind(JScrollPane.class).annotatedWith(Images.class).to(ImageListScrollPane.class);
		bind(JScrollPane.class).annotatedWith(Mail.class).to(RecipientsScrollPane.class);
		bind(JScrollPane.class).annotatedWith(Output.class).to(OutputScrollPane.class);
	}

}
