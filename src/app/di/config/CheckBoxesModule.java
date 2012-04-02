package app.di.config;

import javax.swing.JCheckBox;

import app.di.annotations.Compress;
import app.di.annotations.Resize;
import app.gui.components.text.CompressCheckBox;
import app.gui.components.text.ResizeCheckBox;

import com.google.inject.AbstractModule;

public class CheckBoxesModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JCheckBox.class).annotatedWith(Resize.class).to(ResizeCheckBox.class);
		bind(JCheckBox.class).annotatedWith(Compress.class).to(CompressCheckBox.class);
	}

}
