package MediaPlayer;

import java.awt.event.MouseAdapter;
import java.io.File;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class MainController {
	
	int i = 0;
	
	private MediaPlayer mediaPlayer;
	
	@FXML
	private MediaView mediaView;
	
	private String filePath;
	
	@FXML
	private Slider slider;
	
	@FXML
	private Slider seekSlider;

	@FXML
	private void handleButtonAction(ActionEvent e)
	{
		FileChooser fileChooser = new FileChooser();	
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file(*.mp4, *.mp3)","*.mp4","*.mp3");
		fileChooser.getExtensionFilters().add(filter);
		File file = fileChooser.showOpenDialog(null);
		
		
		if(i !=0)
		{
			mediaPlayer.dispose();
		}
		//System.out.println(file);
		if(file != null)
			{
			filePath = file.toURI().toString();
			i = 1;
			}
		
		
		if(filePath != null)
		{
			Media media = new Media(filePath);
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
				DoubleProperty width = mediaView.fitWidthProperty();
				DoubleProperty height = mediaView.fitHeightProperty();
				
				width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
				height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
			
			slider.setValue(mediaPlayer.getVolume()*100);
			slider.valueProperty().addListener(new InvalidationListener(){

				@Override
				public void invalidated(Observable arg0) {
					mediaPlayer.setVolume(slider.getValue()/100);
					
				}
				
			});
			
			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){

				@Override
				public void changed(ObservableValue<? extends Duration> obseravable, Duration oldValue, Duration newValue) {
					seekSlider.setValue(newValue.toSeconds());
					
				}
				
			});
			
			seekSlider.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent me) {
					
					mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
				}
				
			});
			
			mediaPlayer.play();
		}
	}
	
	@FXML
	private void pauseVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
			mediaPlayer.pause();
		}
	}
	@FXML
	private void playVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
			mediaPlayer.play();
			mediaPlayer.setRate(1);
		}
	}
	@FXML
	private void stopVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
	}
	@FXML
	private void fastVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
			mediaPlayer.setRate(1.5);
		}
	}
	@FXML
	private void fasterVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
			mediaPlayer.setRate(2);
		}
	}
	@FXML
	private void slowVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
		mediaPlayer.setRate(.75);
		}
	}
	@FXML
	private void slowerVideo(ActionEvent e)
	{
		if(mediaPlayer != null)
		{
		mediaPlayer.setRate(.5);
		}
	}
	@FXML
	private void exitVideo(ActionEvent e)
	{
		System.exit(0);
	}
	
	
}
