package app.di.config;

import javax.swing.JPanel;

import app.di.annotations.App;
import app.di.annotations.Compress;
import app.di.annotations.Images;
import app.di.annotations.Mail;
import app.di.annotations.Manipulation;
import app.di.annotations.Output;
import app.di.annotations.Resize;
import app.di.annotations.Share;
import app.di.annotations.Upload;
import app.gui.components.panels.AppPanel;
import app.gui.components.panels.CompressPanel;
import app.gui.components.panels.ImagesPanel;
import app.gui.components.panels.MailPanel;
import app.gui.components.panels.ManipulationPanel;
import app.gui.components.panels.OutputPanel;
import app.gui.components.panels.ResizePanel;
import app.gui.components.panels.SharePanel;
import app.gui.components.panels.UploadPanel;

import com.google.inject.AbstractModule;

public class PanelsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JPanel.class).annotatedWith(App.class).to(AppPanel.class);
		bind(JPanel.class).annotatedWith(Images.class).to(ImagesPanel.class);
		bind(JPanel.class).annotatedWith(Manipulation.class).to(ManipulationPanel.class);
		bind(JPanel.class).annotatedWith(Share.class).to(SharePanel.class);
		bind(JPanel.class).annotatedWith(Output.class).to(OutputPanel.class);
		bind(JPanel.class).annotatedWith(Resize.class).to(ResizePanel.class);
		bind(JPanel.class).annotatedWith(Compress.class).to(CompressPanel.class);
		bind(JPanel.class).annotatedWith(Upload.class).to(UploadPanel.class);
		bind(JPanel.class).annotatedWith(Mail.class).to(MailPanel.class);
	}

}
