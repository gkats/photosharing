package app.di.config;

import javax.swing.JTextArea;

import app.di.annotations.Output;
import app.gui.components.text.OutputArea;

import com.google.inject.AbstractModule;

public class TextAreasModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JTextArea.class).annotatedWith(Output.class).to(OutputArea.class);
	}

}
