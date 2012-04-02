package app.di.config;

import javax.swing.AbstractAction;

import app.di.annotations.Help;
import app.gui.actions.HelpAction;

import com.google.inject.AbstractModule;

public class ActionsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AbstractAction.class).annotatedWith(Help.class).to(HelpAction.class);
	}

}
